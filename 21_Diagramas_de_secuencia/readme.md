### Diagramas de secuencia


1 - Método POST `http://localhost:8080/clientes/crear`

```mermaid
sequenceDiagram
    participant U as User
    participant C as ClientController
    participant S as ClientService
    participant R as ClientRepository    
    U->>C: POST /clientes/crear Body {Client}
    C->>S: CREATE USER (Client)
    S-->R: FIND USER (Client)
    alt isPresent:
        R-->> S: return true
        S-->> C: throw Exception
        C-->> U: 400 BAD REQUEST
    else
        R-->> S: return false
        S->> R: SAVE(Client)
        R-->>S: return void
        S-->> C: return true
        C -->> U: 201 CREATED
    end
```


2 - Método DELETE con parámetro username `http://localhost:8080/clientes/eliminar?username=xxxx`

```mermaid
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
       C -->> U: 200 OK
   end
```

3 - Método PUT `http://localhost:8080/clientes/actualizar`

```mermaid
sequenceDiagram
   participant U as User
   participant C as ClientController
   participant S as ClientService
   participant R as ClientRepository

   U ->> C: UPDATE /clientes/actualizar Body {CLIENT}
   C ->> S: update client (CLIENT)
   S ->> R: find client (CLIENT)
   alt isPresente:
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
```

4 - Método GET con parámetro username `http://localhost:8080/clientes/buscar?username=xxxxxx`

```mermaid
sequenceDiagram
   participant U as User
   participant C as ClientController
   participant S as ClientService
   participant R as ClientRepository

   U ->> C: GET /clientes/buscar?username=xxxxxx
   C ->> S: get client by username
   S ->> R: find client by username
   R -->> S:return client
   S -->> C:return client
   alt [isPresent]:
       C -->> U:return client
   else
       C -->>U: 404 Not Found
   end
```

5 - Método GET sin parámetro

```mermaid
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
```
