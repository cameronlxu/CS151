package part2;

public class Main {
    public static void main(String[] args) {        
        ChicagoStyle chicagoPizza = new ChicagoStyle();
        chicagoPizza.makeFromScratch();
        
        System.out.println("");
        
        CaliforniaStyle californiaPizza = new CaliforniaStyle();
        californiaPizza.makeFromScratch();
        
        System.out.println("");
        
        NewYorkStyle newYorkPizza = new NewYorkStyle();
        newYorkPizza.makeFromScratch();
    }
}