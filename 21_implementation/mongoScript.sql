use
consultorio

db.createCollection("Appoiment")
db.Appoiment.insertMany(
    {
        "date" :  "2021/01/01",
        "time" :  "12:30",
        "doctor": {
             "name" : "Doctor1",
             "edad" : 50
        },
        "paciente": {
            "name": "Ricardo",
            "tel":  "134123"
        }
    
    },
    
    {
        "date" :  "2021/01/01",
        "time" :  "13:00",
        "doctor": {
             "name" : "Doctor1",
             "edad" : 50
        },
        "paciente": {
            "name": "Mariano",
            "tel":  "134123"
        }
    
    },
    
    {
        "date" :  "2021/01/01",
        "time" :  "12:30",
        "doctor": {
             "name" : "Doctor2",
             "edad" : 50
        },
        "paciente": {
            "name": "Ricardo",
            "tel":  "134123"
        }
    
    },
    
    {
        "date" :  "2021/01/01",
        "time" :  "13:00",
        "doctor": {
             "name" : "Doctor2",
             "edad" : 50
        },
        "paciente": {
            "name": "Mariano",
            "tel":  "134123"
        }
    
    }
)
