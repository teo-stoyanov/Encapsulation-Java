package pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Pizza pizza = null;
        boolean errMsg = false;
        int countToppings = 0;
        boolean hasMoreToppings = false;
        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("END".equals(input[0])) {
                break;
            }

            //null point EX?
            switch (input[0]) {
                case "Pizza":
                    try {
                        pizza = new Pizza(input[1], Integer.parseInt(input[2]));
                    } catch (IllegalArgumentException iae) {
                        errMsg = true;
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Dough":
                    //pizza don't exist?
                    try {
                        Dough dough = new Dough(input[1], input[2], Double.parseDouble(input[3]));
                        double calories = dough.setCalories();
                        if (pizza != null) {
                            pizza.setPizzaCalories(calories);
                        }

                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                        errMsg = true;
                    }
                    break;
                case "Topping":
                    try{
                        Toppings topping = new Toppings(input[1], Double.parseDouble(input[2]));
                        countToppings++;
                        if(countToppings > pizza.getNumberOfToppings()){
                            hasMoreToppings = true;
                            break;
                        }
                        double toppingCals = topping.setToppingCalories();
                        pizza.setPizzaCalories(toppingCals);
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                        errMsg = true;
                    }
                    break;
            }
            if(errMsg || hasMoreToppings){
                break;
            }
        }

        if(pizza != null && !errMsg){
            System.out.println(String.format("%s - %.2f",pizza.getName(),pizza.getCalories()));
        }
    }
}
