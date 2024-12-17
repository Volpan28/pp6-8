package commands;

import gifts.Gift;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

import static menus.Main.logger;

public class ChooseExistingGiftCommand {
    private final Map<String, Gift> gifts;
    private final Scanner scanner;

    public ChooseExistingGiftCommand(Map<String, Gift> gifts, Scanner scanner) {
        this.gifts = gifts;
        this.scanner = scanner;
    }

    public void execute(Consumer<Gift> onGiftSelected) {
        if (gifts.isEmpty()) {
            System.out.println("Немає існуючих подарунків. Спочатку створіть новий.");
            logger.info("Спроба вибору подарунка, але список подарунків порожній.");
            return;
        }

        System.out.println("Виберіть назву подарунка:");
        logger.info("Користувачу відображено список доступних подарунків:");
        gifts.keySet().forEach(name -> {
            System.out.println("Подарунок: " + name);
            logger.info("Доступний подарунок: " + name);
        });

        scanner.nextLine();
        String giftName = scanner.nextLine();
        logger.info("Користувач ввів назву подарунка: " + giftName);


        if (gifts.containsKey(giftName)) {
            Gift selectedGift = gifts.get(giftName);
            System.out.println("Вибрано подарунок: " + giftName);
            logger.info("Користувач успішно вибрав подарунок: " + giftName);
            onGiftSelected.accept(selectedGift);
        } else {
            System.out.println("Неправильна назва.");
            logger.warn("Користувач ввів неправильну назву подарунка: " + giftName);
        }
    }

}
