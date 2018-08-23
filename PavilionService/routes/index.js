var request = require('request');
var express = require('express');
var router = express.Router();
var fs = require("fs");

exports.handleHOME = function (request, response) {
    response.render('pages/index');
};

exports.handleGETDatabase = function (request, response) {

   var contents = fs.readFileSync("database/CRICKET_V2.db");
  response.on('error', function(err) {
        console.error(err);
      });

  response.writeHead(200, {'Content-Type': 'application/json'})
  response.write((contents));
  response.end();
}

exports.handleGET = function (request, response) {

    var country = 'XXX';
    if (request.params.country == null){
        country = 'XXX'
    }
    var contents = fs.readFileSync("json/"+country+"PlayerStats.json");
    var jsonContent = JSON.parse(contents);

    response.on('error', function(err) {
          console.error(err);
        });

    response.writeHead(200, {'Content-Type': 'application/json'})
    response.write(JSON.stringify(jsonContent,null,2));
    response.end();
}

exports.handleGoat = function (request, response) {

    const sqlite3 = require('sqlite3').verbose();
    let db = new sqlite3.Database('./database/CRICKET_V2.db', (err) => {
      if (err) {
        console.error(err.message);
      }
      console.log('Connected to the CRICKET_V2 database.');
    });

db.serialize(function() {
  db.each("select * from PLAYER where bat_avg > 50.0 and tests > 30;", function(err, row) {
      console.log(row.player_name + " : " + row.country);
  });
});
    response.writeHead(200, {'Content-Type': 'application/json'})
    //response.write(JSON.stringify(jsonContent,null,2));
    response.end();
};

exports.handletop10 = function (request, response) {
    const sqlite3 = require('sqlite3').verbose();
    let db = new sqlite3.Database('./database/CRICKET_V2.db', (err) => {
      if (err) {
        console.error(err.message);
      }
      console.log('Connected to the CRICKET_V2 database.');
    });

db.serialize(function() {
  db.each("select * from PLAYER order by runs DESC limit 10", function(err, row) {
      console.log(row);
  });
});
    response.writeHead(200, {'Content-Type': 'application/json'})
//    response.write(JSON.stringify(jsonContent,null,2));
    response.end();
};