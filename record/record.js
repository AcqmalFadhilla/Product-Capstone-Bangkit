const express = require('express')
const mysql = require('mysql')
const router = express.Router()


//Sesuaikan konfigurasi database
const connection = mysql.createConnection({
    host: '127.0.0.1',
    user: 'root',
    database: 'contoh',
    password: ''
})

// untuk mengambil gambar tempat wisata dengan id yang dicantumkan
router.get("/place/placeId/:id", (req, res) => {
    const id = req.params.id
    const query = `SELECT * FROM dbs WHERE ID = ${id}`
    connection.query(query, (err, rows, field) => {
        if(err) {
            res.status(500).send({message: err.sqlMessage})
        } else {
            res.status(200).json({succes : true, data: rows})
        }
    })
})

// untuk list lokasi berdasarkan jarak
router.get("/place/placeNearest", (req, res) => {
    const latitud = req.query.latitude
    const longitude = req.query.longitude
    const page = req.query.Page
    const data = req.query.Data
    let off = (data * page)-data
    const query = `SELECT Kota, Name, Header_image, Rating, (((acos(sin((${latitud}*pi()/180)) * sin((Latitude*pi()/180)) + cos((${latitud}*pi()/180)) * cos((Latitude*pi()/180)) * cos(((${longitude}-Longitude)*pi()/180)))) * 180/pi()) * 60 * 1.1515 * 1.609344) AS jarak FROM dbs ORDER BY jarak LIMIT ${data} OFFSET ${off}`
    connection.query(query, (err, rows, field) => {
        if(err) {
            res.status(500).send({message: err.sqlMessage})
        } else {
            res.status(200).json({succes : true, data: rows })
        }
    })
})

// untuk list lokasi berdasarkan kategori
router.get("/place/placeCategory/(:kategori)", (req, res) => {
    const kategori = req.params.kategori
    const page = req.query.Page
    const data = req.query.Data
    let off = (data * page)-data
    const query = `SELECT ID, Header_image, Name, Rating, Category FROM dbs WHERE Category = '${kategori}' LIMIT ${data} OFFSET ${off}`
    connection.query(query, (err, rows, field) => {
        if(err) {
            res.status(500).send({message: err.sqlMessage})
        } else {
            res.status(200).json({ success: true, data: rows })
        }
    })
})

module.exports = router