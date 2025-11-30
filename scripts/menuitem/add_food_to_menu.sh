#!/bin/bash
curl -X POST http://localhost:8080/restaurants/3/menuitems \
-H "Content-Type: application/json" \
-d '{
    "name": "Spicy Tuna Roll",
    "description": "Tuna, spicy mayo, and cucumber",
    "price": 9.50,
    "category": "Sushi"
}'