/**
 * Created by mmadhusoodan on 9/2/15.
 */

var request = require('sync-request');
var CLIENT_ID = 'a60a41e5bc3d440e9ddb6f50160df41b', REDIRECT_URI = 'http://localhost:4002/redirect'

exports.getUpcomingSeries = function () {

    var upcomingSeriesUrl = 'https://query.yahooapis.com/v1/public/yql?q=' +
        'select%20*%20from%20cricket.series.upcoming&format=json' +
        '&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0'

    console.log('upcomingSeriesUrl: ', upcomingSeriesUrl);
    var res = request('GET', upcomingSeriesUrl);
    try {
        var JSONoutput = JSON.parse(res.body.toString());
    }
    catch (e) {
        console.log(e);
    }
    return JSONoutput;
}

exports.getAuthenticated =  function (req, res) {

    var instagramAuthURI = 'https://instagram.com/oauth/authorize/?client_id=a60a41e5bc3d440e9ddb6f50160df41b&redirect_uri=http://localhost:4002/redirect&response_type=code'
    console.log('instagramAuthURI: ', instagramAuthURI);
    res = request('POST', instagramAuthURI);
    try {
        var JSONoutput = JSON.parse(res.body.toString());
        console.log('JSONoutput" ', JSONoutput);
    }
    catch (e) {
        console.log(e);
    }
    return JSONoutput;
}