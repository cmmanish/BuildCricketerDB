/**
 * Created by mmadhusoodan on 9/2/15.
 */

var CLIENT_ID = 'a60a41e5bc3d440e9ddb6f50160df41b', REDIRECT_URI = 'http://localhost:4002/redirect'
var host = 'https://api.instagram.com/oauth/authorize/?client_id=' + CLIENT_ID + '&redirect_uri=' + REDIRECT_URI + '&response_type=code'

exports.getAuthenticated = function (req, res) {

    console.log("httpAsyncGet : getAuthenticated");
    var request = require('request');
    var options = {
        host: 'https://instagram.com/oauth/authorize/?client_id=' + CLIENT_ID + '&redirect_uri=' + REDIRECT_URI + '&response_type=code'
    };

    request(options, function (error, response, body) {
        if (!error && response.statusCode == 200) {
            console.log(body);
        }
    });
}