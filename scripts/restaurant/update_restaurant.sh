#!/bin/bash
curl -X PUT http://localhost:8080/restaurants/1 \
-H "Content-Type: application/json" \
-d "{
    \"name\": \"Pizza Palace\",
    \"address\": \"789 Pine St, Foodville\",
    \"cuisineType\": \"Italian\",
    \"rating\": 4.7,
    \"operatingHours\": \"11:00-22:30\"
}"