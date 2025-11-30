#!/bin/bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
    "name": "Anna Karenina",
    "email": "anna.k@gmail.com",
    "password": "secure_password_3",
    "phoneNumber": "555-0103",
    "address": "43 Makarov str, New Yorkshire"
}'