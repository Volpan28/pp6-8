package gifts;

import sweets.Sweet;

import java.util.ArrayList;
import java.util.List;

public class Gift {
    private String name;
    private List<Sweet> sweets = new ArrayList<>();

    public Gift() {
    }

    public Gift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    public void addSweets(Sweet sweet) {
        sweets.add(sweet);
    }

    public void SetName(String giftName) {
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.getWeight();  // Припускаємо, що у Sweet є метод getWeight()
        }
        return totalWeight;
    }

}
