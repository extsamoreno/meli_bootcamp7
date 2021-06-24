//var schematodo = db.collection_name.findOne();
//print("hola")
//for (var key in schematodo) { print (key, typeof key) ; }
[db.restaurants.findOne()].forEach( function(my_doc) { for (var key in my_doc) { print(key + ': ' + typeof my_doc[key]) } } )