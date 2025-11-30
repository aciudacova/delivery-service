DELETE FROM menu_items;
DELETE FROM users;
DELETE FROM restaurants;

INSERT INTO users (name, email, password, phone_number, address, created_at) VALUES
('Иван Петров', 'ivan.p@gmail.com', 'hashed_password_1', '123-456-7890', 'ул. Главная, 123', NOW()),
('Мария Сидорова', 'maria.s@gmail.com', 'hashed_password_2', '098-765-4321', 'пр. Центральный, 456', NOW());

INSERT INTO restaurants (name, address, cuisine_type, rating, operating_hours) VALUES
('Pizza Palace', 'ул. Сосновая, 789', 'Итальянская', 4.5, '11:00-22:00'),
('Sushi Spot', 'ул. Кленовая, 321', 'Японская', 4.8, '12:00-21:00');

-- restaurant_id=1 соответствует 'Pizza Palace'.
INSERT INTO menu_items (restaurant_id, name, description, price, category) VALUES
(1, 'Пицца Маргарита', 'Классическая пицца с томатами, моцареллой и базиликом', 120.00, 'Основное блюдо'),
(1, 'Чесночный хлеб', 'Поджаренный хлеб с чесночным маслом', 30.00, 'Закуска'),
-- restaurant_id=2 соответствует 'Sushi Spot'.
(2, 'Ролл Калифорния', 'Краб, авокадо и огурец', 150.00, 'Суши'),
(2, 'Мисо суп', 'Традиционный японский суп с тофу и водорослями', 100.00, 'Закуска');
