package part2;

public abstract class Pizza {
    
    // Template Method
    public final void makeFromScratch() {
        pickToppings();
        makeCrust();
        addToppings();
        preHeatOven();
        cook();
    }
    
    // Abstract to override in sub-classes
    public abstract void pickToppings();
    
    public void makeCrust() {
        System.out.println("Make crust!");
    }
    
    public void addToppings() {
        System.out.println("Add toppings!");
    }
    
    public void preHeatOven() {
        System.out.println("Preheat oven!");
    }
    
    public void cook() {
        System.out.println("Cook pizza!");
    }

}