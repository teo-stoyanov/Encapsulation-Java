package pizza_calories;

import java.util.ArrayList;
import java.util.List;

class Toppings {
    private String toppingType;
    private double weight;

    Toppings(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight, toppingType);
    }

    private void setToppingType(String toppingType) {
        List<String> toppingsTypeList = new ArrayList<>();
        toppingsTypeList.add("Meat");
        toppingsTypeList.add("Veggies");
        toppingsTypeList.add("Cheese");
        toppingsTypeList.add("Sauce");
        if (!toppingsTypeList.contains(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight, String toppingType) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    double setToppingCalories() {
        double calories = this.weight * 2;
        switch (toppingType) {
            case "Meat":
                calories *= 1.2;
                break;
            case "Veggies":
                calories *= 0.8;
                break;
            case "Cheese":
                calories *= 1.1;
                break;
            case "Sause":
                calories *= 0.9;
                break;
        }
        return calories;
    }
}
