/**
 * Created by mmadhusoodan on 9/2/15.
 */

//Load the request module
var request = require('request');

var URI = 'https://api.instagram.com/v1/media/popular?access_token=2164001407.42fbdc7.293af07c1fee422f834c7786b826fdde';
//Lets try to make a HTTPS GET request to modulus.io's website.
//All we did here to make HTTPS call is changed the `http` to `https` in INSTAGRAM_URL.
request(URI, function (error, response, body) {
    //Check for error
    if (error) {
        return console.log('Error:', error);
    }

    //Check for right status code
    if (response.statusCode !== 200) {
        return console.log('Invalid Status Code Returned:', response.statusCode);
    }

    JSONoutput = JSON.parse(body.toString());
    console.log(JSONoutput.data.length);

    console.log(JSONoutput.data[1].user.username);


    for (var i = 0; i < JSONoutput.data.length; i++) {
        console.log(JSONoutput.data[i].user.username);

        console.log(JSONoutput.data[i].user.full_name);

    }
    //All is good. Print the body

});

