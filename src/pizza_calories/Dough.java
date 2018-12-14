package pizza_calories;

import java.util.ArrayList;
import java.util.List;

class Dough {
    private String typeDough;
    private String typeOfPreparation;
    private double weight;

    Dough(String typeDough, String typeOfPreparation, double weight) {
        this.setTypeDough(typeDough);
        this.setTypeOfPreparation(typeOfPreparation);
        this.setWeight(weight);
    }

    private void setTypeDough(String typeDough) {
        List<String> typeList = new ArrayList<>();
        typeList.add("Wholegrain");
        typeList.add("White");
        if (!typeList.contains(typeDough)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.typeDough = typeDough;
    }

    private void setTypeOfPreparation(String typeOfPreparation) {
        List<String> typeOfPrepList = new ArrayList<>();
        typeOfPrepList.add("Crispy");
        typeOfPrepList.add("Chewy");
        typeOfPrepList.add("Homemade");
        if (!typeOfPrepList.contains(typeOfPreparation)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", typeOfPreparation));
        }
        this.typeOfPreparation = typeOfPreparation;
    }

    //double?
    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    double setCalories() {
        double calories = this.weight * 2.0;
        if (this.typeDough.equals("White")) {
            calories *= 1.5;
        } else {
            calories *= 1.0;
        }

        switch (this.typeOfPreparation) {
            case "Crispy":
                calories *= 0.9;
                break;
            case "Chewy":
                calories *= 1.1;
                break;
            case "Homemade":
                calories *= 1.0;
                break;
        }
        return calories;
    }
}
