# Spring-Security-JWT
Demo Spring-Boot API Security with JWT

Demo from https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/


#### HTTP 403 Forbidden status is expected
curl http://localhost:8080/v1/task

#### Registers a new user
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8080/users/sign-up

#### Login into the application (JWT is generated)
curl -i -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8080/login

#### Remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Content-Type: application/json" \
-H "Authorization: Bearer xxx.yyy.zzz" \
-X POST -d '{
    "description": "Buy watermelon"
}'  http://localhost:8080/v1/task

#### remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8080/v1/task
####  Get Item - Remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Content-Type: application/json"  \
-H "Authorization: Bearer xxx.yyy.zzz" \
-X GET  http://localhost:8080/v1/task/1