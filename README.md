# API Teatro
Get information about theater via a RESTful API.

# ABOUT
This project was developed based on the:
- Spring 3.9.0.RELEASE.
- PostgreSQL.

# API Endpoints
Below are described the REST endpoints available that you can use to search for theaters.

### Swagger
- Swagger
``` html
http://localhost:8080/v2/api-docs
```

- Swagger UI
``` html
http://localhost:8080/swagger-ui.html
```

### Eventos
- Listar Eventos (Parâmetro: id usuário logado)
``` html
GET http://localhost:8080/eventos 
```
``` html
GET http://localhost:8080/eventos/listar/{uid}
```
- Buscar Eventos Favoritados pelo Usuário (Parâmetro: id usuário logado)
``` html
GET http://localhost:8080/favorito/{uid}
```
- Buscar Evento por ID (Parâmetro: código do evento)
``` html
GET http://localhost:8080/eventos/{codigo}
```
- Listar Eventos Filtrados (Parâmetro: id usuário logado)
``` html
GET http://localhost:8080/eventos/{uid}?filtrar&nome=evento&descricao=descricao&genero=genero&nomeLocal=nomeLocal&estadoLocal=estadoLocal
```
- Listar Eventos Paginado
``` html
GET http://localhost:8080/eventos?paginado&size=5&page=0
```
- Inserir Evento
``` html
POST http://localhost:8080/eventos
```
### Locais
- Listar Locais
``` html
GET http://localhost:8080/locais
```
- Buscar Local por ID (Parâmetro: código do local)
``` html
GET http://localhost:8080/locais/{codigo}
```
- Inserir Local
``` html
POST http://localhost:8080/locais
```
- Deletar Local (Parâmetro: código do evento)
``` html
DELETE http://localhost:8080/locais/{codigo}
```
### Usuários
- Listar Usuários
``` html
GET http://localhost:8080/usuarios
```
- Buscar Usuário por ID
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
### Favoritos
- Listar Favoritos
``` html
GET http://localhost:8080/favorito
```
- Inserir Favorito
``` html
POST http://localhost:8080/favorito
```
- Deletar Favorito (@RequestBody Favorito favorito)
``` html
DELETE http://localhost:8080/favorito
```
