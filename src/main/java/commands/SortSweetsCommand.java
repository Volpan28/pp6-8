package commands;

import gifts.Gift;
import sweets.Sweet;

import java.util.Comparator;
import java.util.logging.Logger;

import static menus.Main.logger;

public class SortSweetsCommand  {
    private final Gift gift;

    public SortSweetsCommand(Gift gift) {
        this.gift = gift;
    }

    public void execute() {
        logger.info("Розпочато сортування солодощів за вмістом цукру...");
        logger.info("До сортування: " + gift.getSweets());
        gift.getSweets().sort(Comparator.comparingDouble(Sweet::getSugarContent));
        logger.info("Після сортування: " + gift.getSweets());
        System.out.println("Солодощі відсортовані за вмістом цукру.");
    }
}
