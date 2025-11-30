#!/bin/bash
curl -X POST http://localhost:8080/restaurants \
-H "Content-Type: application/json" \
-d "{
    \"name\": \"Andy's Pizza\",
    \"address\": \"39 Stefan cel Mare, Chisinau\",
    \"cuisineType\": \"Mediterranean\",
    \"rating\": 4.6,
    \"operatingHours\": \"10:00-23:00\"
}"
