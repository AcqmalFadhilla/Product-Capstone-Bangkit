from flask import Flask, request, jsonify
import pandas as pd
import pymysql
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

# Inisialisasi Flask
app = Flask(__name__)

# Koneksi ke database SQL
def get_data_from_sql():
    connection = pymysql.connect(host='localhost', port=3308, user='root', password='', db='CSV_DB 15')
    query = "SELECT * FROM _telokka1_csv_zip"
    df = pd.read_sql(query, connection)
    connection.close()
    return df

# Membaca data dari SQL dan memprosesnya
df = get_data_from_sql()
df["Review"] = df["Review"].str.replace(",", " ")
df["new_deskripsi"] = df["Deskripsi"] + " " + df["Review"]

vectorizer = TfidfVectorizer()
tfidf_matrix = vectorizer.fit_transform(df['new_deskripsi'])

# Membuat fungsi rekomendasi
def recommend_activities_new(activity, top_n=5):
    # Mengubah aktivitas menjadi vektor fitur dengan TF-IDF
    activity_vector = vectorizer.transform([activity])

    # Menghitung similarity antara vektor aktivitas dengan vektor deskripsi wisata
    similarity_scores = cosine_similarity(activity_vector, tfidf_matrix).flatten()

    # Mendapatkan indeks rekomendasi berdasarkan similarity scores
    top_indices = similarity_scores.argsort()[::-1][:top_n]

    # Mendapatkan rekomendasi wisata berdasarkan indeks
    recommended_activities = df.loc[top_indices, ['ID', 'Kota', 'Name', 'Address','image', 'Rating', 'Category', "Detail_URL", "Tags", "Latitude", "Longitude", "Website", "Phone", "Review", "Deskripsi" ]].values 
    return recommended_activities
# 

@app.route("/")
def home():
    return "tes"

# Route untuk menerima input aktivitas dan memberikan rekomendasi
@app.route('/recommend', methods=['GET'])
def get_recommendations():
    input_activity = request.args.get('activity')
    recommended_activities = recommend_activities_new(input_activity)
    recommendations = []
    for activity in recommended_activities:
        recommendations.append({
            'ID': activity[0],
            'Kota': activity[1],
            'Name': activity[2],
            'Address' : activity[3],
            'image': activity[4],
            'Rating' : activity[5],
            'Category': activity[6],
            'Detail_URL': activity[7],
            'Tags' : activity[8],
            'Latitude': activity[9],
            'Longitude': activity[10],
            'Website' : activity[11],
            'Phone': activity[12],
            'Review': activity[13],
            'Deskripsi' : activity[14]
        })
    return jsonify(recommendations)

if __name__ == '__main__':
    app.run(debug=True)
    