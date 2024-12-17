package proposition;

import gifts.Gift;
import sweets.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static menus.Main.logger;

public class GiftProposition {
    private static List<Gift> proposals = new ArrayList<>();
    private static final String FILE_PATH = "src/main/java/propositiontxt/gift_offers.txt";

    public static List<Gift> readOffersFromFile() {
        proposals = new ArrayList<>();
        List<Gift> giftOffers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) { // Перевірка правильності формату рядка
                    String giftName = parts[0];
                    String sweetType = parts[1];
                    double weight = Double.parseDouble(parts[2]);
                    double sugar = Double.parseDouble(parts[3]);
                    String flavor = parts[4];

                    Sweet sweet = switch (sweetType) {
                        case "Chocolate" -> new Chocolate(giftName, weight, sugar, flavor);
                        case "Gummy" -> new Gummy(giftName, weight, sugar, flavor);
                        case "Cookie" -> new Cookie(giftName, weight, sugar, flavor);
                        case "Lolipop" -> new Lolipop(giftName, weight, sugar, flavor);
                        default -> null;
                    };

                    if (sweet != null) {
                        Gift gift = new Gift();
                        gift.setName(giftName);
                        gift.addSweets(sweet);
                        giftOffers.add(gift);
                    } else {
                        logger.warn("Невідомий тип солодощів: " + sweetType + " для подарунка: " + giftName);
                    }
                } else {
                    logger.warn("Пропуск некоректного рядка в файлі: " + line);
                }
            }
        } catch (IOException e) {
            logger.error("Помилка при зчитуванні файлу: " + FILE_PATH, e);
            System.err.println("Помилка при зчитуванні файлу: " + FILE_PATH);
        }

        proposals = giftOffers;
        if (giftOffers.isEmpty()) {
            logger.warn("Не знайдено жодної валідної пропозиції подарунка в файлі.");
        } else {
            logger.info("Завантажено пропозицій подарунків: " + giftOffers.size());
        }
        return giftOffers;
    }

    public static void createOffersFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("Gift1,Chocolate,200,20,Milk\n");
            writer.write("Gift2,Gummy,150,15,Fruit\n");
            writer.write("Gift3,Cookie,100,10,Vanilla\n");
            writer.write("Gift4,Lolipop,50,5,Strawberry\n");
            logger.info("Файл пропозицій подарунків створено/оновлено успішно.");
        } catch (IOException e) {
            logger.error("Помилка при створенні/оновленні файлу пропозицій подарунків.", e);
            System.err.println("Помилка при створенні/оновленні файлу.");
        }
    }
}
