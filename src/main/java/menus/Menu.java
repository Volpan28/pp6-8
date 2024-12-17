package menus;

import commands.*;
import gifts.Gift;
import proposition.GiftProposition;
import sweets.*;

import java.util.*;
import static menus.Main.logger;

public class Menu {
    private Map<String, Gift> gifts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
            while (true) {
                System.out.println("1. Створити новий подарунок");
                System.out.println("2. Вибрати існуючий подарунок");
                System.out.println("3. Переглянути пропозиції подарунків");
                System.out.println("4. Вийти");
                System.out.println("Оберіть дію: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        new CreateGiftCommand(gifts, scanner).execute();
                        logger.info("Користувач натиснув (1) Створити новий подарунок");
                        break;
                    case 2:
                        new ChooseExistingGiftCommand(gifts, scanner).execute(this::manageGift);
                        logger.info("Користувач натиснув (2) Вибрати існуючий подарунок");
                        break;
                    case 3:
                        new ShowProposalsCommand().execute();
                        logger.info("Користувач натиснув (3) Переглянути пропозиції подарунків");
                        break;
                    case 4:
                        logger.info("Користувач натиснув (4) Вихід з програми");
                        return;
                    default:
                        System.out.println("Невірна опція. Спробуйте ще раз.");
                        logger.warn("Користувач ввів не вірну опцію: " + option);
                }
            }
    }

    private void manageGift(Gift gift) {
        while (true) {
                System.out.println("1. Додати солодощі до подарунку");
                System.out.println("2. Відсортувати солодощі за вмістом цукру");
                System.out.println("3. Знайти солодощі за заданим діапазоном цукру");
                System.out.println("4. Відобразити всі солодощі");
                System.out.println("5. Відобразити загальну вагу солодощів у подарунку");
                System.out.println("6. Повернутись до головного меню");
                System.out.println("Оберіть дію: ");

                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        new AddSweetsCommand(gift, scanner).execute();
                        logger.info("Користувач натиснув (1) Додати солодощі до подарунку для подарунка: " + gift.getName());
                        break;
                    case 2:
                        new SortSweetsCommand(gift).execute();
                        logger.info("Користувач натиснув (2) Відсортувати солодощі за вмістом цукру для подарунка: " + gift.getName());
                        break;
                    case 3:
                        new FindSweetBySugarCommand(gift).execute();
                        logger.info("Користувач натиснув (3) Знайти солодощі за заданим діапазоном цукру для подарунка: " + gift.getName());
                        break;
                    case 4:
                        new DisplaySweetsCommand(gift).execute();
                        logger.info("Користувач натиснув (4) Відобразити всі солодощі для подарунка: " + gift.getName());
                        break;
                    case 5:
                        new ShowTotalWeightCommand(gift).execute();
                        logger.info("Користувач натиснув (5) Відобразити загальну вагу солодощів для подарунка: " + gift.getName());
                        break;
                    case 6:
                        logger.info("Користувач натиснув (6) Повернутись до головного меню");
                        return;
                    default:
                        System.out.println("Невірна опція. Спробуйте ще раз.");
                        logger.warn("Користувач ввів невірну опцію в меню подарунка: " + option);
                }
        }
    }
}
