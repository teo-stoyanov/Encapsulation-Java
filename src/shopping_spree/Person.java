package shopping_spree;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<String> bagOfProducts;

    Person(String name, double money) {
        this.name = setName(name);
        this.money = setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private String setName(String name) {
        if (name.length() < 1 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name;
    }

    private double setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        return money;
    }

    String getName() {
        return this.name;
    }

    double getMoney() {
        return this.money;
    }

    List<String> getBagOfProducts() {
        return this.bagOfProducts;
    }

    void payProduct(double productCoast, String productName) {
        if (productCoast > this.getMoney()) {
            System.out.println(String.format("%s can't afford %s", this.getName(), productName));
        } else {
            this.money -= productCoast;
            getBagOfProducts().add(productName);
            System.out.println(String.format("%s bought %s", this.getName(), productName));
        }
    }

    void printProducts() {
        if (this.getBagOfProducts().size() == 0) {
            System.out.println(String.format("%s - Nothing bought", this.getName()));
        } else {
            System.out.println(String.format("%s - %s", this.getName(), String.join(", ", this.getBagOfProducts())));
        }
    }
}
