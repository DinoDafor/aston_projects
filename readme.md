# Aston_projects
## hm3_JDBC
__Also, it's my account in hackerrank where I solved some tasks for SQL.__
https://www.hackerrank.com/profile/dinodafor
### Requirements
- [X] create simple service
- [X] use serlvets
- [X] use  jdbc
- [X] forbidden spring, hibernate
- [X] Many-To-Many, One-to-Many
- [X] use PostgresSQL

### Tables in PSQL 
#### Client 

| ID |  Name   |
|----|:-------:|
| 1  |  Artem  |
| 2  |  Boris  |
| 3  | Cirilla |
| 4  |  Dimon  |
| 5  |   Eva   |
#### Cat
| ID |  Name   |
|----|:-------:|
| 1  |  Arya  |
| 2  |  Bergamot  |
| 3  | Corzes |
| 4  |  Dillir  |
| 5  |   Erik   |
#### Clients_cats (for many-to-many)
| client_id | cat_id |
|-----------|:------:|
| 1         |   1    |
| 2         |   2    |
| 2         |   3    |
| 3         |  null  |
| 4         |   4    |
| 5         |   4    |
| null      |   5    |
### HTTP requests 
#### For Client

```http request
GET http://localhost:8080/clients
```

```http request
POST http://localhost:8080/clients?name=Inseva
```

```http request
DELETE http://localhost:8080/clients?clientId=6
```

```http request
PUT http://localhost:8080/clients?clientId=7&name=Ura
```

#### For Cat  

```http request
GET http://localhost:8080/cats
```

```http request
POST http://localhost:8080/cats?name=Insersik
```

```http request
DELETE http://localhost:8080/cats?catId=6
```

```http request
PUT http://localhost:8080/cats?catId=7&name=Updetik
```

#### For Clients_Cats

```http request
GET http://localhost:8080/clientscats
```

```http request
POST http://localhost:8080/clientscats?clientId=6&catId=6
```
Delete by clientId
```http request
DELETE http://localhost:8080/clientscats?clientId=6
```
Delete by catId
```http request
DELETE http://localhost:8080/clientscats?catId=6
```
Update client for cat
```http request
PUT http://localhost:8080/clientscats?clientIdNew=2&clientIdOld=1&catId=1
```
Update cat for client
```http request
PUT http://localhost:8080/clientscats?catIdNew=1&catIdOld=2&clientId=3
```

### What I want to improve in this project?
Rewrite parts of code, create tests, improve readme.md



