package shopping_spree;

class Product {
    private String name;
    private double coast;

    Product(String name, double coast) {
        this.name = setName(name);
        this.coast = setCoast(coast);
    }

    private String setName(String name) {
        if(name.length() < 1 || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name;
    }

    private double setCoast(double coast) {
        if(coast < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        return coast;
    }

    public String getName() {
        return this.name;
    }

    public double getCoast() {
        return this.coast;
    }
}
