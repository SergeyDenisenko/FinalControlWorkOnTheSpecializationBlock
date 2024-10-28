import java.util.Scanner;

import Service.Controll;
import Service.Counter;
import Service.Menu;
import Service.Repository;

public class App {
    public static void main(String[] args) {
        boolean isWork = true;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Repository repository = new Repository(new Counter());
        Controll controller = new Controll(menu, repository, scanner);

        while (isWork) {
            menu.mainMenu();
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("-----");
                    controller.addAnimal();
                    break;
                case 2:
                    System.out.println("-----");
                    controller.showAllAnimals();
                    break;
                case 3:
                    System.out.println("-----");
                    controller.showCommandsById();
                    break;
                case 4:
                    System.out.println("-----");
                    controller.trainById();
                    break;
                case 5:
                    System.out.println("-----");
                    controller.showCount();
                    break;
                case 6:
                    isWork = false;
                    break;
                default:
                    menu.error();
            }
            System.out.println();
        }
        scanner.close();
    }
}
