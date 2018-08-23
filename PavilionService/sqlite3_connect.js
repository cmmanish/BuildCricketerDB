var sqlite3 = require('sqlite3').verbose();
     let db = new sqlite3.Database('./database/CRICKET_V2.db', (err) => {
       if (err) {
         console.error(err.message);
       }
       console.log('Connected to the CRICKET_V2 database.');
     });

db.serialize(function() {

  db.each("select * from PLAYER where bat_avg > 50.0 and tests > 30;", function(err, row) {
      //console.log(row.player_name + " : " + row.country);
      console.log(row);
  });
});

db.close();