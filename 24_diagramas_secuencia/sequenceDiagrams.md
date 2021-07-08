##Diagrama de secuencia para POST

    sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository    
    U ->>C: POST /clientes/crear Body --> {USER}
    C ->>S: CREATE USER (USER)
    S ->>R: FIND USER (USER)
    alt isPresent:
        R -->> S: true
        S -->> C: throw Exception
        C -->> U: 400 BAD REQUEST
    else
        R -->> S: false
        S ->> R: SAVE(USER)
        R -->> S: VOID
        S -->> C: true
        C -->> U: 201 CREATED
    end

##Diagrama de secuencia para DELETE

    sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository
    U->>C: DELETE /clientes/eliminar?username=xxxx
    C->>S: delete client by username
    S->>R: search client by username
    alt isPresent:
        R-->> S: return false 
        S-->> C: throw Exception
        C-->> U: 400 BAD REQUEST
    else
        R-->> S: return true;
        S->> R: delete user by username
        R-->>S: return true
        S-->> C: return true
        C -->> U: 204 No Content
    end


##Diagrama para UPDATE

    sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository

    U ->> C: UPDATE /clientes/actualizar Body {CLIENT}
    C ->> S: update client (CLIENT)
    S ->> R: find client (CLIENT)
    alt [isPresente]:
        R -->> S: return false
        S -->> C: throw Exception
        C -->> U: 404 Not Found
    else
        R -->> S: return true
        S ->> R: Update client (CLIENT)
        R -->> S: return true
        S -->> C: return true
        C -->> U: 204 NO CONTENT 
    end

##Diagrama de secuencia para GET

    sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository

    U ->> C: GET /clientes/buscar?username=xxxxxx
    C ->> S: get client by username
    S ->> R: find client by username
    R -->> S:return client
    S -->> C:retuen client
    alt [isPresent]:
        C -->> U:return user
    else
        C -->>U: 404 Not Found
    end

##Diagrama de secuencia para GET ALL

    sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository

    U ->> C: GET /clientes/listar
    C ->> S: get all clients
    S ->> R: find all clients
    R -->> S:return clients
    S -->> C:return clients
    C -->> U:return clients