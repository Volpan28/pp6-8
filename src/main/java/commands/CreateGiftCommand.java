package commands;

import gifts.Gift;

import java.util.Map;
import java.util.Scanner;

import static menus.Main.logger;

public class CreateGiftCommand  {
    private final Map<String, Gift> gifts;
    private final Scanner scanner;

    public CreateGiftCommand(Map<String, Gift> gifts, Scanner scanner) {
        this.gifts = gifts;
        this.scanner = scanner;
    }

    public void execute() {
        logger.info("Розпочато створення нового подарунка.");

        System.out.print("Введіть назву нового подарунку: ");
        scanner.nextLine();
        String giftName = scanner.nextLine();
        logger.info("Користувач ввів назву подарунка: " + giftName);

        if (gifts.containsKey(giftName)) {
            System.out.println("Подарунок з такою назвою вже існує. Спробуйте іншу назву.");
            logger.warn("Спроба створити подарунок з назвою, яка вже існує: " + giftName);
            return;
        }

        Gift newGift = new Gift();
        gifts.put(giftName, newGift);
        System.out.println("Новий подарунок '" + giftName + "' створено.");
        logger.info("Новий подарунок створено: " + giftName);
    }
}
