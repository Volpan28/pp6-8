package sweets;

public class Sweet {
    private String name;          // Назва солодощів
    private double weight;        // Вага солодощів
    private double sugarContent;  // Вміст цукру
    private String flavor;        // Смак (наприклад, виноград, полуниця)
    private String type;          // Тип солодощів (наприклад, Lolipop, Chocolate)

    // Оновлений конструктор
    public Sweet(String name, double weight, double sugarContent, String flavor, String type) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.flavor = flavor;
        this.type = type;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getType() {
        return type;
    }

    // Метод toString для відображення інформації про солодощі
    @Override
    public String toString() {
        return type + " {" +
                "Назва='" + name + '\'' +
                ", Смак='" + flavor + '\'' +
                ", Вага=" + weight +
                "гр., Вміст цукру=" + sugarContent + "%}";
    }
}



