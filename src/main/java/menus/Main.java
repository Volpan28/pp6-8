package menus;

import proposition.GiftProposition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        try {
            logger.info("Програму запущено");
            GiftProposition.createOffersFile();
            Menu menu = new Menu();
            menu.showMenu();
        } catch (Exception e) {
            System.out.println("Виникла помилка.");
            logger.error("Критична помилка у програмі: ", e);
        }
    }
}
