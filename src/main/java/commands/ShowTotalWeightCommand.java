package commands;

import gifts.Gift;
import java.util.logging.Logger;

import static menus.Main.logger;

public class ShowTotalWeightCommand  {
    private Gift gift;

    public ShowTotalWeightCommand(Gift gift) {
        this.gift = gift;
    }

    public void execute() {
        logger.info("Обчислення загальної ваги подарунка...");
        double totalWeight = gift.getTotalWeight();
        logger.info("Загальна вага подарунка: " + totalWeight + " г.");
        System.out.println("Загальна вага солодощів у подарунку: " + totalWeight + " г.");
    }
}
