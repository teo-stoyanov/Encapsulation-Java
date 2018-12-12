package animal_farm;

class Chicken {
    private String name;
    private int age;

    Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    double productPerDay() {
        double eggPerDAy;
        if (this.age < 6) {
            eggPerDAy = 2;
        } else if (this.age < 12) {
            eggPerDAy = 1;
        } else {
            eggPerDAy = 0.75;
        }

        return eggPerDAy;
    }
}
