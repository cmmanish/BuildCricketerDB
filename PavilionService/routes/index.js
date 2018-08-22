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
};
