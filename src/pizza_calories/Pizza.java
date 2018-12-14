package pizza_calories;

class Pizza {
    private String name;
    private int numberOfToppings;
    private double calories;

    Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.calories = 0;
    }

    private void setName(String name) {
        if(name == null || name.length() < 1 || name.length() > 15 || name.trim().isEmpty()){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    String getName() {
        return this.name;
    }

    int getNumberOfToppings() {
        return this.numberOfToppings;
    }

    double getCalories() {
        return this.calories;
    }

    double setPizzaCalories(double calories){
        return this.calories += calories;
    }

}
