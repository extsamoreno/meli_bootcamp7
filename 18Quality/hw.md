sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository
    participant D as Memory

    U->>C: POST /clientes/crear 
    Note right of U: { "username":"usuario", <br/> "password":"123456", <br/> "nombre":"minombre", <br/> "apellido":"miapellido", <br/> "email":"algunmail@mail.com"  }
    C->>S: create client 
    S->>R: create client 
    R->>D: Save DB
    alt Succses:
        D-->>R: Return userId
        R-->>S: Return userId
        S-->>C: Return userId
        C-->>U: Return userId
    else
        D-->>R: Throw DB Expetion
        R-->>S: Return Invalid operation
        S-->>C: Return Invalid operation
        C-->>U: 400 Bad Request
    end

    U->>C: DELETE /clientes/eliminar?username
    C->>S: Delete client by username
    S->>R: Delete client by username
    R->>D: Search DB by username
    D-->>R: Return user
    alt isPresent:
        R->>+D: Delete DB
        D-->>-R: Return ok
        R-->>S: Return ok
        S-->>C: Return ok
        C-->>U:  200 OK
    else
        R-->>S: Return Invalid operation
        S-->>C: Return Invalid operation
        C-->>U: 400 Bad Request
    end


    U->>C: PUT /clientes/actualizar
    Note right of U: { "username":"usuario", <br/> "password":"123456", <br/> "nombre":"minombre", <br/> "apellido":"miapellido", <br/> "email":"algunmail@mail.com"  }
    C->>S: update client 
    S->>R: update client 
    R->>D: Search DB by username
    D-->>R: Return user
    alt isPresent:
        R->>+D: Update DB
        D-->>-R: Return ok
        R-->>S: Return ok
        S-->>C: Return ok
        C-->>U:  200 OK
    else
        R-->>S: Return Invalid operation
        S-->>C: Return Invalid operation
        C-->>U: 400 Bad Request
    end


    U->>C: GET /clientes/buscar?username
    C->>S: Search client by username
    S->>R: Search client by username
    R->>+D: Search DB by username
    D-->>-R: Return user
    R-->>S: Return user
    S-->>C: Return user
    alt isPresent:
        C-->>U: Return user
    else
        C-->>U: 404 Not Found
    end

    U->>C: GET clientes/listar
    C->>S: Search clients
    S->>R: Search clients
    R->>+D: Search DB
    D-->>-R: Return list<user>
    R-->>S: Return list<user>
    S-->>C: Return list<user>
    C-->>U: Return list<user>
