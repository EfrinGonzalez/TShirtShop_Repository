# TShirtShop_Repository

Containerless Full stack T-Shirt Application. 
Note: It contains API CRUD operations implemented.

Back-end 
Java 1.8
Maven
Spring STS
Spring Boot
Spring Core
Spring MVC
Spring Data
JPA Spring JDB
H2 Database
Flyway DB Framework

Testing 
JUnit
Harmcrest
Mockito
Spring Test

Front-end
AngularJS

API
Entry point to interact with angular: http://localhost:8080/index.html#/tshirts

API Endpoint
Get - List all: http://localhost:8080/api/shop/tshirts
Get - find one: http://localhost:8080/api/shop/tshirts/{id}
Post - Create: http://localhost:8080/api/shop/tshirts
(receives a TShirt object)
PUT - update  one: http://localhost:8080/api/shop/tshirts/{id}
(receives id an a TShirt object)
DELETE-delete one: http://localhost:8080/api/shop/tshirts/{id}



Curl operations to test the API
----------------------------------------------------------------------------------------------
Get All
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET  http://localhost:8080/api/shop/tshirts
----------------------------------------------------------------------------------------------
Get one
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET  http://localhost:8080/api/shop/tshirts/1
----------------------------------------------------------------------------------------------
Create
curl -H "Content-Type: application/json" -X POST -d "{"""name""":"""NBA""","""size""":"""M""","""colour""":"""BLACK""","""price""":"""34.00""","""image""":"""images/nba.jpg""" }" http://localhost:8080/api/shop/tshirts
----------------------------------------------------------------------------------------------
Update
curl -i -X PUT -H "Content-Type: application/json" -d "{"""id""":"""35""","""name""":"""NBA""","""size""":"""L""","""colour""":"""BLACK""","""price""":"""33.00""","""image""":"""images/nba.jpg""" }"  http://localhost:8080/api/shop/tshirts/35
----------------------------------------------------------------
Delete
curl -i -X DELETE http://localhost:8080/api/shop/tshirts/34
-----------------------------------------------

