# API Teatro
Get information about theater via a RESTful API.

# ABOUT
This project was developed based on the:
- Spring 3.9.0.RELEASE.
- PostgreSQL.

# API Endpoints
Below are described the REST endpoints available that you can use to search for theaters.

### Eventos
- Listar Eventos
``` html
GET http://localhost:8080/eventos
```
- Buscar Evento por ID
``` html
GET http://localhost:8080/eventos/{codigo}
```
- Inserir Evento
``` html
POST http://localhost:8080/eventos
```
- Listar Eventos Paginado
``` html
GET http://localhost:8080/eventos?paginado&size=5&page=0
```
- Listar Eventos Filtrados
``` html
GET http://localhost:8080/eventos?filtrar&nome=evento&descricao=descricao&genero=genero&nomeLocal=nomeLocal&estadoLocal=estadoLocal
```
### Locais
- Listar Locais
``` html
GET http://localhost:8080/locais
```
- Inserir Local
``` html
POST http://localhost:8080/locais
```
- Deletar Local
``` html
DELETE http://localhost:8080/locais/{codigo}
```
### Usuários
- Listar Usuário por ID
``` html
GET http://localhost:8080/usuarios/{codigo}
```
- Inserir Usuário
``` html
POST http://localhost:8080/usuarios
```
- Atualizar Usuário por ID
``` html
PUT http://localhost:8080/usuarios/{id}
```
