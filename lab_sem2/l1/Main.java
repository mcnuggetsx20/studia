public class Main{
    public static void main(String[] args){

        String[] options = {
            "1. Utworzenie Arralist (karty mogą się powtarzać),",
            "2. Wyświetlanie wszystkich elementów Arraylist,",
            "3. Wyświetlanie liczby elementów Arraylist,",
            "4. Wyświetlanie kart o podanej wartości,",
            "5. Wyświetlanie kart o podanym kolorze,",
            "6. Usuwanie kart powtarzających się (do testów usuwania należy na początek struktury dodać trzy karty As kier).",
        };

        Menu menu = new Menu(options);
        menu.show();

        Deck deck = null;
        int arg;
        while( (arg=menu.listen()) != -1){
            switch(arg){
                case 1:
                    deck = new Deck();
                    System.out.printf("Utworzono %d kart\n", deck.getSize());
                    break;
                case 2:
                    if(deck != null){
                        deck.showCards();
                    }
                    else{
                        System.out.println("Nie stworzyles jeszcze żadnej karty!");
                    }
                    break;
                case 3:break;
                case 4:break;
                case 5:break;
                case 6:break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }
        System.out.println("Opuszczanie...");
        System.exit(0);
    }
}
