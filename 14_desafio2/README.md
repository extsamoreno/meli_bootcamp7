

ENDPOINTS

localhost:8080/tucasita/v1/district/districtList GET

	Show a list of district saved 



localhost:8080/tucasita/v1/district/newDistrict POST

	Save a new District - district : { "name" : String , "price": float }

		

localhost:8080/tucasita/v1/realState/realStateList

	Show a list of Real States(propieties) with all data( district, enviroments, totalmeters , totalprice)


localhost:8080/tucasita/v1/realState/newRealState

	Save a new Real State - realStateIn : {"name":String, "districtId":Integer, enviromentList:[{"name":String, "width":Float, "length:Float"},...]}


localhost:8080/tucasita/v1/realState/realStateByName/{realStateName}

	Show a real state with its district, every environment with total meters and a variable isBiggestRoom, total meters real state and price


localhost:8080/tucasita/v1/realState/realStateById/{realStateId}

	Show a real state with its district, every environment with total meters and a variable isBiggestRoom, total meters real state and price