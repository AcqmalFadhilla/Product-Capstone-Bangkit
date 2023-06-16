# Product-Capstone-Bangkit
# Jangan Lupa install node modulesnya npm install

## Dokumentasi API

### Endpoint pertama

    https://backendcloud-dot-capstone-telokka.et.r.appspot.com/ 
1. Detail Lokasi

* URL
     ```markdown
     /place/placeId/:ID
     ```
* Method
  
      GET

* Response

```markdown
  {
    "succes": true,
    "data": [
        {
            "ID": 3,
            "Kota": "bulukumba",
            "Name": "pantai bara, bulukumba",
            "Address": "Bira, Kec. Bonto Bahari, Kabupaten Bulukumba, Sulawesi Selatan",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipNvH_3zMNiO6tn8Sr_72C6eO-_q33Ph3Ml4mD-a=w408-h306-k-no",
            "Rating": 4.6,
            "Category": "danau",
            "Detail_URL": "https://www.google.com/maps/place/Pantai+Bara,+Bulukumba/data=!4m7!3m6!1s0x2dbbf3fe86b4acef:0x70b5c6d0a460856!8m2!3d-5.6082681!4d120.4389893!16s%2Fg%2F11p11c3zfj!19sChIJ76y0hv7zuy0RVghGCm1cCwc?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"Tempat wisata yang menyenangkan.\"\"\"",
            "Latitude": -5.6082681,
            "Longitude": 120.4389893,
            "Website": "",
            "Phone": "",
            "Review": "pasir,air,pemandangan,parkir,banana boat,malam,kelapa,orang,kursi,biaya",
            "Deskripsi": "Pantai Bara adalah pantai menakjubkan lainnya yang terletak di Bulukumba, Sulawesi Selatan. Pantai ini menawarkan suasana pantai yang tenang dengan pasir keemasan dan perairan yang tenang. Pantai ini dikelilingi oleh tebing-tebing berbatu yang menambah pesona alamnya. Pantai Bara merupakan tempat yang tepat untuk bersantai, berjalan-jalan santai di sepanjang pantai, dan menikmati pemandangan matahari terbenam yang menakjubkan. Pantai ini juga terkenal dengan hidangan lautnya yang segar, sehingga pengunjung dapat menikmati hidangan lokal yang lezat sambil menikmati suasana pantai."
        }
    ]
}
```





2. List lokasi berdasarkan jarak
    * URL
      ```mrkdown
      /place/placeNearest
      ```

* Method
  
      GET

* Paramters
  * latitude as double , koordinat latitude dari user
  * longitude as double , koordinat longitude dari user
  * page as int , halaman list lokasi
  * Data as int  , jumlah lokasi perhalaman
    
* Response
```markdown
{
    "succes": true,
    "data": [
        {
            "ID": 154,
            "Kota": "sinjai",
            "Name": "taman purbakala batu pake gojeng",
            "Address": "Jl. Veteran, Biringere, Kec. Sinjai Utara, Kabupaten Sinjai, Sulawesi Selatan 92611",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipNkexh-OkJEwZq0CT3IRFJ9_BlGt5jf92xg-hwy=w408-h306-k-no",
            "Rating": 4.4,
            "Category": "taman",
            "Detail_URL": "https://www.google.com/maps/place/Taman+Purbakala+Batu+Pake+Gojeng/data=!4m7!3m6!1s0x2dbc267a38732735:0x2ec5bb28646bc50e!8m2!3d-5.1297074!4d120.2444294!16s%2Fg%2F11b86zn1y0!19sChIJNSdzOHomvC0RDsVrZCi7xS4?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"Tempat Wisata di sinjai Lo..\"\"\"",
            "Latitude": -5.1297074,
            "Longitude": 120.2444294,
            "Website": "",
            "Phone": "",
            "Review": "pemandangan,puncak,bukit,sejarah,keluarga,laut,orang,dataran tinggi,situs purbakala,tarif",
            "Deskripsi": "Taman Purbakala Batu Pake Gojeng adalah sebuah taman purbakala yang terletak di Sinjai. Tempat ini menampilkan situs arkeologi berupa batu-batu peninggalan zaman dahulu. Pengunjung dapat menjelajahi situs purbakala, mempelajari sejarahnya, atau bahkan mengagumi keindahan arsitektur batu-batu kuno. Taman Purbakala Batu Pake Gojeng adalah tempat yang menarik bagi penggemar sejarah dan arkeologi.",
            "jarak": 1.021762721122548
        },
        {
            "ID": 156,
            "Kota": "sinjai",
            "Name": "benteng balangnipa",
            "Address": "Jl. Sungai Tangka, Balangnipa, Kec. Sinjai Utara, Kabupaten Sinjai, Sulawesi Selatan 92614",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipPPoMPKYvOdOiJ1iLww9DV41stqFC1_wk5r_sBG=w408-h253-k-no",
            "Rating": 4.3,
            "Category": "museum",
            "Detail_URL": "https://www.google.com/maps/place/Benteng+Balangnipa/data=!4m7!3m6!1s0x2dbc25df7e947f67:0x44eafa6c0a3a79ab!8m2!3d-5.1168677!4d120.2628809!16s%2Fg%2F11bc8d11p0!19sChIJZ3-Uft8lvC0Rq3k6Cmz66kQ?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"Tempat wisata edukasi\"\"\"",
            "Latitude": -5.1168677,
            "Longitude": 120.2628809,
            "Website": "",
            "Phone": "0852-9841-1400",
            "Review": "sejarah,bangunan,daerah,pemerintah,warga,latar,penjajahan,kata,perang,luas",
            "Deskripsi": "Benteng Balangnipa adalah sebuah benteng sejarah yang terletak di sinjai. Benteng ini memiliki nilai sejarah dan merupakan warisan budaya penting bagi daerah tersebut. Pengunjung dapat mengunjungi benteng, menjelajahi sisa-sisa bangunan, atau bahkan belajar lebih banyak tentang sejarahnya. Benteng Balangnipa adalah tempat yang menarik bagi pecinta sejarah dan penggemar budaya.",
            "jarak": 1.688600830216251
        },
        {
            "ID": 22,
            "Kota": "bone",
            "Name": "permandian alam waetuwo",
            "Address": "W68G+694, Waetuwo, Kec. Kajuara, Kabupaten Bone, Sulawesi Selatan 92776",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipPg2udIQgEtcnhGx2ujOhjmUU8x8hzThgyDTILr=w426-h240-k-no",
            "Rating": 3.9,
            "Category": "permandian",
            "Detail_URL": "https://www.google.com/maps/place/Permandian+Alam+Waetuwo/data=!4m7!3m6!1s0x2dbc28951a48355f:0x57b7330470348a4e!8m2!3d-5.0844751!4d120.2259381!16s%2Fg%2F11cn13x_12!19sChIJXzVIGpUovC0RToo0cAQzt1c?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"Iya bisalah jdi tempat wisata\"\"\"",
            "Latitude": -5.0844751,
            "Longitude": 120.2259381,
            "Website": "",
            "Phone": "",
            "Review": "air,sejuk",
            "Deskripsi": "Permandian Alam Waetuwo adalah tempat yang cocok untuk relaksasi dan menikmati keindahan alam. Terletak di Sulawesi Selatan, permandian alam ini menawarkan air terjun yang indah dan kolam alami yang jernih. Pengunjung dapat berenang, bermain air, atau hanya duduk bersantai di sekitar kolam sambil menikmati suasana alam yang tenang dan segar.",
            "jarak": 5.817067306617734
        }
    ]
}
```

3. List lokasi berdasarkan kategori
    * URL
      ```markdown
      /place/placeCategory/(:kategori)
      ```

* Method
  
      GET

* Paramters
  * kategori as string , kategori yang diinginkan
  * page as int , halaman list lokasi
  * Data as int  , jumlah lokasi perhalaman

* Response
```markdown
{
    "success": true,
    "data": [
        {
            "ID": 58,
            "Kota": "makassar",
            "Name": "pura giri natha",
            "Address": "Jl. Perintis Kemerdekaan No.162, Tamalanrea, Kec. Tamalanrea, Kota Makassar, Sulawesi Selatan 90245",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipPZuoJrLJ-WqDv80iask6XujL-uYRrliCkiSTq8=w408-h544-k-no",
            "Rating": 4.8,
            "Category": "religi",
            "Detail_URL": "https://www.google.com/maps/place/Pura+Giri+Natha/data=!4m7!3m6!1s0x2dbefca5b3db2ced:0xe099dffa274e03a8!8m2!3d-5.1268844!4d119.502861!16s%2Fg%2F1q2vycx48!19sChIJ7Szbs6X8vi0RqANOJ_rfmeA?authuser=0&hl=id&rclk=1",
            "Tags": "",
            "Latitude": -5.1268844,
            "Longitude": 119.502861,
            "Website": "",
            "Phone": "",
            "Review": "tempat ibadah,minggu,luas,damai,hari besar",
            "Deskripsi": "Pura Giri Natha adalah sebuah pura Hindu yang terletak di Sulawesi Selatan. Pura ini menjadi tempat ibadah bagi umat Hindu di daerah tersebut dan juga menjadi pusat kegiatan keagamaan dan budaya Hindu. Dengan arsitektur yang khas dan dekorasi yang megah, Pura Giri Natha menciptakan suasana yang sakral dan penuh keheningan. Pengunjung dapat mengunjungi pura ini untuk merasakan atmosfer keagamaan yang khusyuk dan mengagumi keindahan seni dan tradisi Hindu yang dipamerkan di sini."
        },
        {
            "ID": 59,
            "Kota": "makassar",
            "Name": "kompleks makam raja-raja tallo",
            "Address": "VCWW+R6V, Jl. Sultan Abdullah Raya belakang makam raja, raja, Kec. Tallo, Kota Makassar, Sulawesi Selatan 90212",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipMrgxaIP7-c7-AdqhDsDTN9_DBQCST5sG1VXxP0=w408-h306-k-no",
            "Rating": 4.5,
            "Category": "religi",
            "Detail_URL": "https://www.google.com/maps/place/Kompleks+Makam+Raja-Raja+Tallo/data=!4m7!3m6!1s0x2dbefda0e913f6b5:0xecb1e0022c7b727!8m2!3d-5.1028762!4d119.4455574!16s%2Fg%2F1hm27xd29!19sChIJtfYT6aD9vi0RJ7fHIgAeyw4?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"Tempat bersejarah dan wisata religi\"\"\"",
            "Latitude": -5.1028762,
            "Longitude": 119.4455574,
            "Website": "",
            "Phone": "",
            "Review": "sejarah,masa lalu,pahlawan,orang",
            "Deskripsi": "Kompleks Makam Raja-Raja Tallo adalah sebuah kompleks pemakaman yang terletak di Sulawesi Selatan. Kompleks ini menjadi tempat peristirahatan terakhir bagi para raja-raja dan kerabat kerajaan Tallo. Kompleks Makam Raja-Raja Tallo memiliki nilai sejarah yang tinggi dan menjadi saksi bisu dari kejayaan masa lalu daerah tersebut. Pengunjung dapat mengunjungi kompleks ini untuk mempelajari sejarah kerajaan Tallo dan menghormati jasa-jasa mereka yang telah berjasa dalam membangun dan mempertahankan daerah tersebut."
        },
        {
            "ID": 66,
            "Kota": "gowa",
            "Name": "kerkhof van gowa-tallo koninklijke familie",
            "Address": "Makam Sultan Hasanuddin Raja Gowa ke-XVI, Makassar, South Sulawesi, Jl. Pallantikang No.83d, Katangka, Kec. Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92114",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipONXp0rEVHIoJWlXGKYEMxsIq-NC5vwRFmDNNBW=w426-h240-k-no",
            "Rating": 4.5,
            "Category": "religi",
            "Detail_URL": "https://www.google.com/maps/place/Kerkhof+van+Gowa-Tallo+Koninklijke+Familie/data=!4m7!3m6!1s0x2dbee24616ecfea5:0x65bd1b00c8540ae7!8m2!3d-5.1923606!4d119.4519122!16s%2Fg%2F11bycf926q!19sChIJpf7sFkbivi0R5wpUyAAbvWU?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"... kunjungan wisata yg penuh dng nilai sejarah dr perjuangan salah ...\"\"\"",
            "Latitude": -5.1923606,
            "Longitude": 119.4519122,
            "Website": "",
            "Phone": "",
            "Review": "sejarah,wisata,pahlawan,taman,bangsa,patung,rakyat,nama",
            "Deskripsi": "Kerkhof van Gowa-Tallo Koninklijke Familie adalah sebuah kompleks pemakaman yang terletak di Sulawesi Selatan. Kompleks pemakaman ini merupakan tempat peristirahatan terakhir bagi keluarga kerajaan Gowa-Tallo. Kompleks pemakaman ini memiliki nilai sejarah dan budaya yang tinggi, dan juga menjadi tempat yang tenang untuk mengenang dan menghormati para leluhur. Pengunjung dapat mengunjungi kompleks ini untuk mempelajari sejarah kerajaan dan budaya Sulawesi Selatan."
        },
        {
            "ID": 68,
            "Kota": "gowa",
            "Name": "masjid tua al-hilal katangka",
            "Address": "Jl. Syech Yusuf No.57, Katangka, Kec. Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92114",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipMSsh6XsPZgfYesXzmQL47AjfZdtCWNPuY8du1G=w408-h306-k-no",
            "Rating": 4.8,
            "Category": "religi",
            "Detail_URL": "https://www.google.com/maps/place/Masjid+Tua+Al-Hilal+Katangka/data=!4m7!3m6!1s0x2dbee245c1f4a6fd:0x2eeee004d8ae931c!8m2!3d-5.1907147!4d119.4512236!16s%2Fg%2F1hm5r3bsz!19sChIJ_ab0wUXivi0RHJOu2ATg7i4?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"Cocok untuk jadi wisata religi\"\"\"",
            "Latitude": -5.1907147,
            "Longitude": 119.4512236,
            "Website": "",
            "Phone": "0821-8800-8992",
            "Review": "sejarah,islam,alhamdulillah,namanya,pemerintah,dinding,sejuk,saksi,tanah,pahlawan",
            "Deskripsi": "Masjid Tua Al-Hilal Katangka adalah sebuah masjid yang memiliki sejarah yang kaya dan terletak di Sulawesi Selatan. Masjid ini adalah salah satu masjid tertua di daerah tersebut dan menjadi pusat kegiatan keagamaan bagi umat Muslim setempat. Dengan arsitektur tradisional yang indah, masjid ini menciptakan suasana yang khusyuk dan sakral. Pengunjung dapat mengunjungi masjid ini untuk merasakan ketenangan spiritual dan mengagumi keindahan arsitektur yang khas."
        },
        {
            "ID": 70,
            "Kota": "makassar",
            "Name": "masjid 99 kubah cpi makassar",
            "Address": "VC43+FHH Kawasan CPI, Makassar City, 90111",
            "Header_image": "https://lh5.googleusercontent.com/p/AF1QipMsKVKIhrIfCY8MJliox6bY1lTGIdkL6CbXbn7t=w408-h306-k-no",
            "Rating": 4.7,
            "Category": "religi",
            "Detail_URL": "https://www.google.com/maps/place/Masjid+99+Kubah+CPI+Makassar/data=!4m7!3m6!1s0x2dbf1d4d6ad24f79:0x9f982d45f386a9fe!8m2!3d-5.1438118!4d119.4039966!16s%2Fg%2F11hcvvs6q0!19sChIJeU_Sak0dvy0R_qmG80UtmJ8?authuser=0&hl=id&rclk=1",
            "Tags": " \n\"Wisata Religi Makassar\"\"\"",
            "Latitude": -5.1438118,
            "Longitude": 119.4039966,
            "Website": "",
            "Phone": "",
            "Review": "arsitektur,desain,ridwan kamil,foto,asma'ul husna,masyarakat,tangga,ikon,karya,gelap",
            "Deskripsi": "Masjid 99 Kubah CPI Makassar adalah sebuah masjid yang terletak di Makassar, Sulawesi Selatan. Masjid ini memiliki ciri khas yang unik dengan atapnya yang dihiasi oleh 99 kubah yang indah. Arsitektur masjid ini mencerminkan keindahan dan kemegahan Islam, menciptakan suasana yang khusyuk dan menarik bagi para pengunjung. Masjid 99 Kubah CPI Makassar juga merupakan tempat ibadah yang ramai dikunjungi oleh umat Muslim, baik untuk beribadah maupun untuk mengagumi keindahan arsitektur masjid ini."
        }
    ]
}
```


### endpoint kedua
```markdown
https://capstone-telokka.et.r.appspot.com/
```
4. List lokasi berdasarkan kategori
    * URL
      ```markdown
      /recommended
      ```

* Method
  
      GET

* Paramters
  * activity as string , aktivitas yang ingin dilakukan

* Response
```markdown

```
