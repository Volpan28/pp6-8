package commands;

import gifts.Gift;
import sweets.Sweet;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static menus.Main.logger;

public class FindSweetBySugarCommand  {
    private final Gift gift;
    private final Scanner scanner;

    public FindSweetBySugarCommand(Gift gift) {
        this.gift = gift;
        this.scanner = new Scanner(System.in);
        logger.info("FindSweetBySugarCommand створено для подарунка.");
    }

    public void execute() {
        try {
            System.out.print("Введіть мінімальний вміст цукру (в процентах): ");
            double minSugar = scanner.nextDouble();
            logger.info("Користувач ввів мінімальний вміст цукру: " + minSugar);

            System.out.print("Введіть максимальний вміст цукру (в процентах): ");
            double maxSugar = scanner.nextDouble();
            logger.info("Користувач ввів максимальний вміст цукру: " + maxSugar);

            if (minSugar > maxSugar) {
                logger.warn("Мінімальний вміст цукру більше за максимальний.");
                System.out.println("Помилка: мінімальний вміст цукру не може бути більшим за максимальний.");
                return;
            }

            List<Sweet> sweets = gift.getSweets().stream()
                    .filter(sweet -> sweet.getSugarContent() >= minSugar && sweet.getSugarContent() <= maxSugar)
                    .collect(Collectors.toList());

            if (sweets.isEmpty()) {
                logger.info("Солодощі у заданому діапазоні не знайдені.");
                System.out.println("Солодощі у заданому діапазоні цукру не знайдені.");
            } else {
                logger.info("Знайдено солодощі у заданому діапазоні: " + sweets);
                System.out.println("Знайдено солодощі у заданому діапазоні:");
                sweets.forEach(System.out::println);
            }
        } catch (Exception e) {
            logger.error("Помилка під час виконання команди: " + e.getMessage(), e);
            System.out.println("Сталася помилка. Перевірте введені дані.");
        }
    }
}
