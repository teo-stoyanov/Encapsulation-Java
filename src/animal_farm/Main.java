package animal_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String name = console.readLine();
        int age = Integer.parseInt(console.readLine());

        try {
            Chicken chicken = new Chicken(name, age);
            if(chicken.productPerDay() > (int)chicken.productPerDay()){
                System.out.println(String.format("Chicken %s (age %d) can produce %.2f eggs per day.", chicken.getName(),
                        chicken.getAge(), chicken.productPerDay()));
            } else {
                System.out.println(String.format("Chicken %s (age %d) can produce %.0f eggs per day.", chicken.getName(),
                        chicken.getAge(), chicken.productPerDay()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
