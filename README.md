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