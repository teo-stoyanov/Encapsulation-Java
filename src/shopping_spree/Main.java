package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] peopleMoney = console.readLine().split(";");
        String[] productsCoast = console.readLine().split(";");

        List<Product> productList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();

        try {
            Arrays.stream(peopleMoney).forEach(pm -> {
                String tokens[] = pm.split("=");
                String name = tokens[0];
                double coast = Double.parseDouble(tokens[1]);
                Person person = new Person(name, coast);
                personList.add(person);
            });

            for (String product : productsCoast) {
                String tokens[] = product.split("=");
                String item = tokens[0];
                double coast = Double.parseDouble(tokens[1]);
                Product pro = new Product(item, coast);
                productList.add(pro);
            }

            while (true) {
                String[] input = console.readLine().split("\\s+");
                if ("END".equals(input[0])) {
                    break;
                }

                String name = input[0];
                String product = input[1];
                double productCoast = 0;

                for (Product product1 : productList) {
                    if (product1.getName().equals(product)) {
                        productCoast = product1.getCoast();
                    }
                }

                for (Person person : personList) {
                    if (person.getName().equals(name)) {
                        person.payProduct(productCoast, product);
                    }
                }
            }
            personList.forEach(Person::printProducts);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
