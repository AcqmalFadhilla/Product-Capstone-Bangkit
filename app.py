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
    query = "SELECT * FROM clear_dataset_csv_zip"
    df = pd.read_sql(query, connection)
    connection.close()
    return df

# Membaca data dari SQL dan memprosesnya
df = get_data_from_sql()
df["review"] = df["review"].str.replace(",", " ")
df["new_deskripsi"] = df["deskripsi"] + " " + df["review"]

vectorizer = TfidfVectorizer()
tfidf_matrix = vectorizer.fit_transform(df['new_deskripsi'])

# Membuat fungsi rekomendasi
def recommend_activities_new(activity, top_n=len(df)):
    # Mengubah aktivitas menjadi vektor fitur dengan TF-IDF
    activity_vector = vectorizer.transform([activity])

    # Menghitung similarity antara vektor aktivitas dengan vektor deskripsi wisata
    similarity_scores = cosine_similarity(activity_vector, tfidf_matrix).flatten()

    # Mendapatkan indeks rekomendasi berdasarkan similarity scores
    top_indices = similarity_scores.argsort()[::-1][:top_n]

    # Mendapatkan rekomendasi wisata berdasarkan indeks
    recommended_activities = df.loc[top_indices, ["id", 'kota', 'nama', "kategori", "jalan", "rating", "deskripsi"]].values

    return recommended_activities

# Route untuk menerima input aktivitas dan memberikan rekomendasi
@app.route('/recommend', methods=['GET'])
def get_recommendations():
    input_activity = request.args.get('activity')
    recommended_activities = recommend_activities_new(input_activity)
    recommendations = []
    for activity in recommended_activities:
        recommendations.append({
            'id': activity[0],
            'kota': activity[1],
            'nama': activity[2],
            'kategori': activity[3],
            'rating' : activity[5],
            'jalan': activity[4],
            'deskripsi': activity[6]
        })
    return jsonify(recommendations)

if __name__ == '__main__':
    app.run()