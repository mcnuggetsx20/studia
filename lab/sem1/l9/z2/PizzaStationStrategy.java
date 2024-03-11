public class PizzaStationStrategy implements PizzaStrategy{
    String adres = "";
    String phoneNumber = "111111111";

    public PizzaStationStrategy(String _ad, String _ph){
        adres = _ad;
        phoneNumber = _ph;
    }

    @Override
    public void orderPizza(Pizza pizza){
        System.out.printf("zakupiono pizze %s z PizzaStation na adres %s. Telefon: %s", pizza.getRodzaj(), adres, phoneNumber);
    }
}

