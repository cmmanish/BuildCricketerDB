/**
 * Created by mmadhusoodan on 9/2/15.
 */

var request = require('request');

var options={
    'key':'28',
    'key1':'value',
    'key2':'value'
}

request({
    url:"http://dev.api.ean.com/ean-services/rs/hotel/v3/ping?minorRev="+options.key+
    "&cid="+options.key1+"&apiKey="+options.key2,
    method:"POST",
    json:true},function(error,response,body){
    console.log(body)
}
);