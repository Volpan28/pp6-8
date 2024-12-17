package commands;

import gifts.Gift;
import proposition.GiftProposition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static menus.Main.logger;

public class ShowProposalsCommand  {
    private static List<Gift> gifts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        logger.info("Читання пропозицій подарунків з файлу...");
        List<Gift> offers = GiftProposition.readOffersFromFile();

        if (offers.isEmpty()) {
            logger.warn("Немає доступних пропозицій подарунків.");
            System.out.println("Немає доступних пропозицій подарунків.");
            return;
        }

        logger.info("Доступні пропозиції подарунків: " + offers.size());
        System.out.println("Доступні пропозиції подарунків:");
        int count = 1;
        for (Gift offer : offers) {
            System.out.println(count++ + ". Подарунок: " + offer.getName() + ", Вага: " + offer.getTotalWeight() + " г.");
        }

        System.out.println("Оберіть подарунок для додавання:");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= offers.size()) {
            Gift selectedGift = offers.get(choice - 1);
            logger.info("Користувач обрав подарунок: " + selectedGift.getName());
            System.out.println("Ви обрали подарунок: " + selectedGift.getName());

            gifts.add(selectedGift);
            logger.info("Подарунок додано до списку: " + selectedGift.getName());
            System.out.println("Подарунок додано до ваших існуючих подарунків.");
        } else {
            logger.warn("Невірний вибір: " + choice);
            System.out.println("Невірний вибір.");
        }
    }

    public static List<Gift> getGifts() {
        return gifts;
    }
}
