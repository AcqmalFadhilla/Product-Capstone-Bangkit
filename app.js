
const express = require('express')
const app = express()
const recordRouter = require('./record/record')

app.use(recordRouter)

app.get("/", (req, res) => {
    console.log("Response success")
    res.send("Response Success!")
})

const PORT = process.env.PORT || 8800
app.listen(PORT, () => {
    console.log("Server is up and listening on " + PORT)
})