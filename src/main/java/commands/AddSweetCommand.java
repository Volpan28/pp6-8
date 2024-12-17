package commands;

import gifts.Gift;
import sweets.Sweet;

import static menus.Main.logger;

public class AddSweetCommand {
    private Gift gift;
    private Sweet sweet;

    public AddSweetCommand(Gift gift, Sweet sweet) {
        this.gift = gift;
        this.sweet = sweet;
    }

    public void execute() {
        gift.addSweets(sweet);
        System.out.println("Додано солодощі: " + sweet);
        logger.info("Додано солодощі: " + sweet);
    }
}
