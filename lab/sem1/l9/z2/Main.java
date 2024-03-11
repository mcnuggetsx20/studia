public class Main {
    public void pay(PizzaStrategy strat){
        strat.pay("pepperoni");
    }
    public static void main(String[] args){
        pay(new PizzaHutStrategy(10, 11, "wyspianskiego"));
        return;
    }
}
