package commands;

import sweets.*;
import gifts.Gift;
import java.util.Scanner;

import static menus.Main.logger;

public class AddSweetsCommand {
    private final Gift gift;
    private final Scanner scanner;

    public AddSweetsCommand(Gift gift, Scanner scanner) {
        this.gift = gift;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Введіть назву солодощі: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        logger.info(name);

        System.out.print("Введіть вагу солодощі (в грамах): ");
        double weight = scanner.nextDouble();

        System.out.print("Введіть вміст цукру солодощі (в процентах): ");
        double sugar = scanner.nextDouble();

        System.out.print("Оберіть тип солодощі (1 - Шоколад, 2 - Мармелад, 3 - Печиво, 4 - Льодяник, 5 - Цукерка): ");
        int type = scanner.nextInt();

        scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Введіть смак шоколаду (молочний, чорний, білий): ");
                String chocolateType = scanner.nextLine();
                new AddSweetCommand(gift, new Chocolate(name, weight, sugar, chocolateType)).execute();
                break;
            case 2:
                System.out.print("Введіть смак мармеладу: ");
                String gummyFlavor = scanner.nextLine();
                new AddSweetCommand(gift, new Gummy(name, weight, sugar, gummyFlavor)).execute();
                break;
            case 3:
                System.out.print("Введіть смак печива: ");
                String cookieFlavor = scanner.nextLine();
                new AddSweetCommand(gift, new Cookie(name, weight, sugar, cookieFlavor)).execute();
                break;
            case 4:
                System.out.print("Введіть смак льодяника: ");
                String lollipopFlavor = scanner.nextLine();
                new AddSweetCommand(gift, new Lolipop(name, weight, sugar, lollipopFlavor)).execute();
                break;
            case 5:
                System.out.print("Введіть смак цукерки: ");
                String candyFlavor = scanner.nextLine();
                new AddSweetCommand(gift, new Candy(name, weight, sugar, candyFlavor)).execute();
                break;
            default:
                System.out.println("Невідомий тип солодощі.");
        }

    }
}
