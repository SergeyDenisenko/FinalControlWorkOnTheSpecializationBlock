# Итоговая контрольная работа по блоку специализация

Организуйте систему учёта для питомника, в котором живут домашние и вьючные животные.

## Операционные системы и виртуализация (Linux)

1. Использование команды cat в Linux
   - Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
    
     >\> cat Pats.txt<br>Dogs<br>Cats<br>Hamsters<br>
    \> cat Pack\ Animals.txt<br>Horses<br>Camels<br>Donkeys<br>

   - Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
        >\> cat Pats.txt Pack\ Animals.txt >Animals.txt<br>
        \> cat Animals.txt
   - Переименовать получившийся файл в "Human Friends"
        > \> mv Animals.txt "Human Friends.txt"
2. Работа с директориями в Linux
   - Создать новую директорию и переместить туда файл "Human Friends".
      > \> mkdir animals<br> \> mv "Human Friends.txt" animals/
3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
   - Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.
      > \> wget https://dev.mysql.com/get/mysql-apt-config_0.8.32-1_all.deb<br>
      \> sudo dpkg -i mysql-apt-config_0.8.32-1_all.deb<br>
      \> sudo apt install mysql-server
4. Управление deb-пакетами
   - Установить и затем удалить deb-пакет, используя команду `dpkg`.
      > \> sudo dpkg -i ./Downloads/Yandex.deb<br>
      \> sudo dpkg -r $(dpkg -f ./Downloads/Yandex.deb Package)
5. Выложить историю команд в терминале ubuntu
    > \> history > history.txt
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).
7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”<br>
    > <br>CREATE DATABASE HumanFriends;<br><br>
8. Создать таблицы с иерархией из диаграммы в БД
    > <br>CREATE TABLE Category (<br>
	&nbsp;&nbsp;&nbsp;&nbsp;id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,<br>
	&nbsp;&nbsp;&nbsp;&nbsp;name VARCHAR(45) NOT NULL UNIQUE<br>
    );<br><br>
    DROP TABLE IF EXISTS Types;<br>
    CREATE TABLE IF NOT EXISTS Types (<br>
    &nbsp;&nbsp;&nbsp;&nbsp;id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,<br>
    &nbsp;&nbsp;&nbsp;&nbsp;name VARCHAR(45) NOT NULL UNIQUE,<br>
    &nbsp;&nbsp;&nbsp;&nbsp;category_id INT NOT NULL,<br>
    &nbsp;&nbsp;&nbsp;&nbsp;FOREIGN KEY (category_id) REFERENCES Category(id)<br>
    );<br><br>
    DROP TABLE IF EXISTS Animals;<br>
    CREATE TABLE IF NOT EXISTS Animals (<br>
    &nbsp;&nbsp;&nbsp;&nbsp;id INT AUTO_INCREMENT PRIMARY KEY,<br>
    &nbsp;&nbsp;&nbsp;&nbsp;name VARCHAR(45) NOT NULL,<br>
    &nbsp;&nbsp;&nbsp;&nbsp;birthday DATETIME DEFAULT(NOW()),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;commands VARCHAR(255),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;type_id INT NOT NULL,<br>
    &nbsp;&nbsp;&nbsp;&nbsp;FOREIGN KEY (type_id) REFERENCES Types(id)<br>
    );<br><br>
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
    > <br>INSERT INTO Category(name) VALUES ('Pets'), ('Pack Animals');<br><br>
    INSERT INTO Types(name, category_id)<br>
    VALUES<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Dog', 1),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Cat', 1),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Hamster', 1),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Horse', 2),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Camel', 2),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Donkey', 2);<br><br>
    INSERT INTO Animals(name, commands, type_id)<br>
    VALUES<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Gerda', '2022-10-23', 'sit, lie down, voice', 1),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Axel', '2020-8-03', 'sit, lie down, give me a paw', 1),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Garfield', '2018-11-26', 'say meow', 2),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Dusty', '2021-01-01', '', 2),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Bunny', '2024-06-11', '', 3),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Zizi', '2016-05-24', '', 3),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Thunder', '2022-11-20', 'lie down', 4),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Gamble', '2015-04-29', 'lie down, give me a paw', 4),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Chloe', '2023-09-18', 'lie down', 5),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Bo', '2020-07-13', 'lie down', 5),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Bertie', '2021-05-25', '',  6),<br>
    &nbsp;&nbsp;&nbsp;&nbsp;('Dora', '2022-12-23', '',  6);<br><br>
1.  Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
    > <br># удаляем верблюдов<br>DELETE FROM Animals WHERE type_id = 5;<br># создаем новую таблицу с лошадями и осламиCREATE TABLE Pack_Animals SELECT * FROM Animals WHERE type_id IN (4, 6);<br><br>
1.  Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
    > <br>CREATE TABLE Young_Animals<br>
    SELECT id, name, commands, type_id, birthday,<br>
    DATEDIFF(CURRENT_DATE(),birthday) DIV 31 as age<br>
    FROM Animals<br>
    WHERE DATE_ADD(birthday, INTERVAL 1 YEAR) < CURRENT_DATE()<br>
    AND DATE_ADD(birthday, INTERVAL 3 YEAR) > CURRENT_DATE();<br><br>
1.  Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
    > <br>SELECT id, name, commands, type_id, birthday FROM Animals<br>
    UNION<br>
    SELECT id, name, commands, type_id, birthday FROM Young_Animals;<br><br>

## ООП и Java

- Создать иерархию классов в Java, который будет повторять диаграмму классов созданную в задаче 6 (Диаграмма классов) .
- Написать программу на Java, которая будет имитировать реестр домашних животных.

### В программе должен быть реализован следующий функционал:

    14.1 Завести новое животное
    14.2 Определять животное в правильный класс
    14.3 Увидеть список команд, которое выполняет животное
    14.4 Обучить животное новым командам
    14.5 Реализовать навигацию по меню

1.  Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля