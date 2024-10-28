package Service;

import java.util.Scanner;

import Models.Animal;
import Models.Cat;
import Models.Dog;
import Models.Hamster;

public class Controll {
    protected Menu menu;
    protected Repository repository;
    protected Scanner scanner;

    public Controll(Menu menu, Repository repos, Scanner scanner) {
        this.menu = menu;
        this.repository = repos;
        this.scanner = scanner;
    }

    public void addAnimal() {
        int type, year, month, day;
        String name, commands;

        menu.selectedTypeAnimal();
        type = scanner.nextInt();

        if (!verifyTypeAnimal(type)) {
            menu.errorType();
        } else {
            scanner.nextLine();
            menu.enterName();
            name = scanner.nextLine();
            menu.enterYear();
            year = scanner.nextInt();
            menu.enterMonth();
            month = scanner.nextInt();
            menu.enterDay();
            day = scanner.nextInt();
            scanner.nextLine();
            menu.enterCommands();
            commands = scanner.nextLine();
            Animal animal = createAnimal(type, name, String.format("%d-%d-%d", year, month, day), commands);
            try {
                repository.append(animal);
                menu.successfulCreate();
            } catch (Exception e) {
               menu.errorCreate();
            }
        }
    }

    public void showAllAnimals() {
        var listAnimals = repository.getAll();
        if (listAnimals != null) {
            for (Integer id : listAnimals.keySet()) {
                System.out.println(listAnimals.get(id));
            }
        } else {
            menu.listEmpty();
        }
    }

    public void showCommandsById() {
        menu.enterId();
        int id = scanner.nextInt();
        String commands = repository.getCommandsById(id);
        if (commands == null || commands.isEmpty()) {
            menu.listEmpty();
        } else {
            System.out.println(commands);
        }
    }

    public void trainById() {
        menu.enterId();
        int id = scanner.nextInt();
        scanner.nextLine();
        Animal animal = repository.getById(id);

        if (animal != null) {
            menu.enterCommands();
            animal.addCommands(scanner.nextLine());
            try {
                repository.update(animal);
                menu.successful();
            } catch (Exception e) {
                menu.errorCreate();
            }
        }
    }

    public void showCount() {
        menu.messageCount(repository.size());
    }

    private boolean verifyTypeAnimal(int typeId) {
        int minTypeId = 1;
        int maxTypeId = 3;
        return maxTypeId >= typeId && typeId >= minTypeId;
    }

    public Animal createAnimal(int type, String name, String birthday, String commands) {
        Animal animal;
        switch (type) {
            case 1:
                animal = new Cat("cat", name, birthday);
                animal.setCommands(commands);
                break;
            case 2:
                animal = new Dog("dog", name, birthday);
                animal.setCommands(commands);
                break;
            case 3:
                animal = new Hamster("cat", name, birthday);
                animal.setCommands(commands);
                break;
            default:
                return null;
        }
        return animal;
    }
}
