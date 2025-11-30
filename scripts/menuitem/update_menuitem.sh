#!/bin/bash
curl -X PUT http://localhost:8080/restaurants/3/menuitems/1 \
-H "Content-Type: application/json" \
-d '{
    "name": "Margherita Pizza Super",
    "description": "Classic pizza with extra tomato, mozzarella, and basil",
    "price": 13.50,
    "category": "Main Course"
}'