# Создаем базу данных
DROP DATABASE IF EXISTS  HumanFriends;
CREATE DATABASE HumanFriends;

# Переключаемся на базу данных для ее использования
USE HumanFriends;

# Создаем таблицу с категориями животных
DROP TABLE IF EXISTS Category;
CREATE TABLE Category (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	name VARCHAR(45) NOT NULL UNIQUE
);

# Создаем таблицу с типами животных
DROP TABLE IF EXISTS Types;
CREATE TABLE IF NOT EXISTS Types (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	name VARCHAR(45) NOT NULL UNIQUE,
	category_id INT NOT NULL,
	FOREIGN KEY (category_id) REFERENCES Category(id)
);

# Создаем таблицу с животными
DROP TABLE IF EXISTS Animals;
CREATE TABLE IF NOT EXISTS Animals (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(45) NOT NULL,
	birthday DATETIME DEFAULT(NOW()),
	commands VARCHAR(255),
	type_id INT NOT NULL,
	FOREIGN KEY (type_id) REFERENCES Types(id)
);

# Вставляем категории животных
INSERT INTO Category(name) VALUES ('Pets'), ('Pack Animals');

# Вставляем виды животных
INSERT INTO Types(name, category_id)
VALUES
('Dog', 1),
('Cat', 1),
('Hamster', 1),
('Horse', 2),
('Camel', 2),
('Donkey', 2);

# Заполняем таблицу животных
INSERT INTO Animals(name, birthday, commands, type_id)
VALUES
('Gerda', '2022-10-23', 'sit, lie down, voice', 1),
('Axel', '2020-8-03', 'sit, lie down, give me a paw', 1),
('Garfield', '2018-11-26', 'say meow', 2),
('Dusty', '2021-01-01', '', 2),
('Bunny', '2024-06-11', '', 3),
('Zizi', '2016-05-24', '', 3),
('Thunder', '2022-11-20', 'lie down', 4),
('Gamble', '2015-04-29', 'lie down, give me a paw', 4),
('Chloe', '2023-09-18', 'lie down', 5),
('Bo', '2020-07-13', 'lie down', 5),
('Bertie', '2021-05-25', '',  6),
('Dora', '2022-12-23', '',  6);

# Удаляем верблюдов
DELETE FROM Animals WHERE type_id = 5;

# Создаем новую таблицу вьючных животных
# состоящую из ослов и лошадей
DROP TABLE IF EXISTS Pack_Animals;
CREATE TABLE Pack_Animals SELECT * FROM Animals WHERE type_id IN (4, 6);

# Создаем таблицу молодых животных
# указывая возраст в месяцах
DROP TABLE IF EXISTS Young_Animals;
CREATE TABLE Young_Animals
SELECT id, name, commands, type_id, birthday, 
DATEDIFF(CURRENT_DATE(),birthday) DIV 31 as age
FROM Animals
WHERE DATE_ADD(birthday, INTERVAL 1 YEAR) < CURRENT_DATE() 
AND DATE_ADD(birthday, INTERVAL 3 YEAR) > CURRENT_DATE();

# Объединение таблицы животных и молодых животных
SELECT id, name, commands, type_id, birthday FROM Animals
UNION
SELECT id, name, commands, type_id, birthday FROM Young_Animals;