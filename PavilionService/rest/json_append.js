var absorb = require('absorb');
var fs = require("fs");
var obj1, obj2;

var contents1 = fs.readFileSync("data/json/"+"IND"+"PlayerStats.json");
var jsonContent1 = JSON.parse(contents1);
var contents2 = fs.readFileSync("data/json/"+"AUS"+"PlayerStats.json");
var jsonContent2 = JSON.parse(contents2);

//console.log(jsonContent2);

var merged_object = JSON.parse((JSON.stringify(contents1) + JSON.stringify(contents2)).replace(/}{/g,","))

//absorb(jsonContent1, jsonContent2);

console.log(JSON.stringify(jsonContent1) + JSON.stringify(jsonContent2));