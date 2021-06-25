[db.restaurants.findOne()].forEach( function(my_doc) { for (var key in my_doc) { print(key + ': ' + typeof my_doc[key]) } } )
[db.neighborhoods.findOne()].forEach( function(my_doc) { for (var key in my_doc) { print(key + ': ' + typeof my_doc[key]) } } )
