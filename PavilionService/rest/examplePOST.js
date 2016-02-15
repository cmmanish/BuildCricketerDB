/**
 * Created by mmadhusoodan on 9/2/15.
 */

//Load the request module
var request = require('request');
var CODE = '1ad4a88bf2a8452984596965d774217a'
var CLIENT_ID = 'a60a41e5bc3d440e9ddb6f50160df41b'
var CLIENT_SECRET = '4ee366e72df84bd4be5765691ab53f04'
var REDIRECT_URL = 'http://localhost:4002/redirect'

//Lets configure and request
request({
    url: 'https://api.instagram.com/oauth/access_token', //INSTAGRAM_URL to hit
    method: 'POST',
    //Lets post the following key/values as form
    form: {
        client_id: CLIENT_ID,
        client_secret: CLIENT_SECRET,
        grant_type: 'authorization_code',
        redirect_uri: REDIRECT_URL,
        code: CODE
    }
}, function (error, response, body) {
    if (error) {
        console.log(error);
    } else {
        console.log(response.statusCode, body);
    }
});