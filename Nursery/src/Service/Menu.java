package Service;


public class Menu {
    public void mainMenu() {
        System.out.println("1. Добавить нового животного");
        System.out.println("2. Отобразить всех животных");
        System.out.println("3. Вывести список команд животного");
        System.out.println("4. Обучить новым командам");
        System.out.println("5. Вывести количество животных");
        System.out.println("6. Выход");
        System.out.println("Введите команду:");
    }

    public void selectedTypeAnimal() {
        System.out.println("Выберите тип животного:");
        System.out.println("1. Кот");
        System.out.println("2. Собака");
        System.out.println("3. Хомяк");
    }

    public void enterName() {
        System.out.println("Введите имя животного:");
    }

    public void enterYear() {
        System.out.println("Введите год рождения:");
    }

    public void enterMonth() {
        System.out.println("Введите месяц (от 01 до 12) рождения:");
    }

    public void enterId() {
        System.out.println("Введите идентификатор животного:");
    }

    public void enterDay() {
        System.out.println("Введите день рождения:");
    }

    public void enterCommands() {
        System.out.println("Введите обученную команду:");
    }

    public void errorType() {
        System.out.println("Ошибка типа животного!");
    }

    public void errorCreate() {
        System.out.println("Ошибка добавления!");
    }

    public void error() {
        System.out.println("Ошибка!");
    }

    public void errorId() {
        System.out.println("Ошибка идентификатора!");
    }

    public void successfulCreate() {
        System.out.println("Новое животное успешно добавлено!");
    }

    public void successful() {
        System.out.println("Успешно!");
    }

    public void listEmpty() {
        System.out.println("Список пуст!");
    }

    public void messageCount(int n) {
        System.out.println(String.format("Всего животных: %d",n));
    }
}
