var http = require('http'),
    express = require('express'),
    app = express(),
    routes = require('./routes'),       // by default, brings in routes/index.js
    port = process.env.PORT || 4000,
    router = express.Router(),
    host = process.env.HOST || "http://localhost";

app.use(express.bodyParser());

app.configure(function () {// set the view engine to ejs
    app.set('view engine', 'ejs');
});

app.get('/', routes.handleHOME);

app.get('/GET', routes.handleGETDatabase);

app.get('/GET/:country', routes.handleGET);

// Starts the server itself
app.listen(port, function (req, res) {
    console.log(host + ':' + port + '/');
});
