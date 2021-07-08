METHOD CREATE

```
sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository
    participant D as Database
    U->>C: POST http://localhost:8080/clientes/crear
    U->>C: RequestBody USERDTO
    C->>C: Validation DTO
    C->>S: Send DTO to service
    S->>S: MAP USERDTO to USER
    S->>R: Send USER
    alt isPresent:
        D --> R:  USER-ALREADY-EXIST-EXCEPTION
    else: 
        D --> R: USER CREATED
    END
    R-->>S: Return USER
    S-->>S: MAP USER to USERDTO
    S-->>C: Return USERDTO
    C-->>U: Return USERDTO
```

METHOD DELET

```
sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository
    participant D as Database
    U->>C: DELETE http://localhost:8080/clientes/eliminar?username=xxxx
    C->>C: Valid request param
    C->>S: Search client by username
    S->>R: Search client by username
    R->>D: Search client by username
    alt isPresent:
        D-->>R: Return DELECT OK
    else
        D-->>R: 404 Not Found   USER-NOT-EXIST-EXCEPTION
    end
    R-->>S: DELECT OK
    S-->>C: DELECT OK
    C-->>U: Return 200 OK
```
UPDATE

```
sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository
    participant D as Database
    U->>C: PUT http://localhost:8080/clients/update
    U->>C: RequestBody USERDTO
    C->>C: Validation DTO
    C->>S: Send DTO to service
    S->>S: MAP USERDTO to USER
    S->>R: Send USER
    alt isPresent:
        D --> R:  update into database
    else: 
        D --> R: USER-NOT-EXIST-EXCEPTION
        D --> R: 404 NOT FOUND
    END
    R-->>S: Return USER
    S-->>S: MAP USER to USERDTO
    S-->>C: Return USERDTO
    C-->>U: Return USERDTO
```

