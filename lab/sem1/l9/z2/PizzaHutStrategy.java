public class PizzaHutStrategy implements PizzaStrategy{
    private int hutId = 153;
    private int hutVerification = 12000;
    String adres = "";

    public PizzaHutStrategy(int _id, int _ver, String _ad){
        hutId = _id;
        hutVerification = _ver;
        adres = _ad;
    }

    @Override
    public void orderPizza(Pizza pizza){
        System.out.printf("zakupiono pizze %s z PizzaHut na adres %s.", pizza.getRodzaj(), adres);
    }
}
