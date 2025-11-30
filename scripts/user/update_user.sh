#!/bin/bash
curl -X PUT http://localhost:8080/users/1 \
-H "Content-Type: application/json" \
-d '{
    "name": "Ivan Ivanov",
    "email": "ivan.i@yandex.ru",
    "password": "new_password",
    "phoneNumber": "111-222-3333",
    "address": "123 Stefan cel Mare, Chisinau"
}'