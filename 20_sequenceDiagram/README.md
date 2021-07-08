#  Diagramas de Sequencia 
https://mermaid-js.github.io/mermaid-live-editor/

#### 1. Método POST http://localhost:8080/clientes/crear
~~~
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
 ~~~
 ![image](https://user-images.githubusercontent.com/84474950/124957700-f91b9400-dfde-11eb-89ec-b94733844de6.png) 

#### 2. Método DELETE con parámetro username http://localhost:8080/clientes/eliminar?username=xxxx

 ~~~
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
 ~~~
 
 ![image](https://user-images.githubusercontent.com/84474950/124957979-47c92e00-dfdf-11eb-9683-020e0a275e93.png)


#### 3. Método PUT http://localhost:8080/clientes/actualizar

 ~~~
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
 ~~~
 
 ![image](https://user-images.githubusercontent.com/84474950/124958200-7f37da80-dfdf-11eb-8a6b-96eefa88c974.png)

#### 4. Método GET con parámetro username http://localhost:8080/clientes/buscar?username=xxxxxx

 ~~~
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
 ~~~
 
 ![image](https://user-images.githubusercontent.com/84474950/124958334-abebf200-dfdf-11eb-8f9c-f407508de3aa.png)


#### 5. Método GET sin parámetro

 ~~~
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
 ~~~
 
 ![image](https://user-images.githubusercontent.com/84474950/124958435-c4f4a300-dfdf-11eb-90b9-7332379862db.png)




