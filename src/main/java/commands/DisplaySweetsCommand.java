package commands;

import gifts.Gift;

import java.util.logging.Logger;

import static menus.Main.logger;

public class DisplaySweetsCommand  {
    private final Gift gift;

    public DisplaySweetsCommand(Gift gift) {
        this.gift = gift;
        logger.info("DisplaySweetsCommand створено для подарунка.");
    }

    public void execute() {
        if (gift.getSweets().isEmpty()) {
            logger.info("У подарунку немає солодощів.");
            System.out.println("У подарунку немає солодощів.");
        } else {
            logger.info("Виконується відображення солодощів у подарунку.");
            System.out.println("Солодощі у подарунку:");
            gift.getSweets().forEach(sweet -> {
                logger.info("Солодощі: " + sweet);
                System.out.println(sweet);
            });
        }
    }
}
