var http = require('http'),
    express = require('express'),
    app = express(),
    routes = require('./routes'),       // by default, brings in routes/index.js
    port = process.env.PORT || 4000,
    router = express.Router(),

    host = process.env.HOST || "http://localhost";
    var bodyParser = require('body-parser');
    var morgan     = require('morgan');
    // configure app to use bodyParser()
    // this will let us get the data from a POST

// configure app
app.use(morgan('dev')); // log requests to the console
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
//app.set('view engine', 'html');
app.set('view engine', 'ejs');

app.get('/', routes.handleHOME);

app.get('/get/:country', routes.handleGET);

app.get('/goat', routes.handleGoat);

app.get('/top10', routes.handletop10);

// START THE SERVER
// =============================================================================
app.listen(port);
console.log('Magic happens on port ' + port);
