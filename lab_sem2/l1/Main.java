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

        String deckException = "Nie stworzyles jeszcze żadnej karty!",
               bonus;

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
                    if(deck == null){System.out.println(deckException);break;}
                    deck.showCards();
                    break;

                case 3:
                    if(deck == null){System.out.println(deckException);break;}
                    System.out.printf("Rozmiar talii: %d%n", deck.getSize());
                    break;

                case 4:
                    if(deck == null){System.out.println(deckException);break;}
                    bonus = menu.listenArgument();
                    deck.cardsBy(bonus);
                    break;

                case 5:
                    if(deck == null){System.out.println(deckException);break;}
                    bonus = menu.listenArgument();
                    deck.cardsBy(bonus);
                    break;

                case 6:
                    if(deck == null){System.out.println(deckException);break;}
                    int removed = deck.removeDuplicates();
                    System.out.printf("Usunięto %d kart\n", removed);
                    break;

                case -2:
                    menu.show();
                    break;

                case 7: 
                    if(deck == null){System.out.println(deckException);break;}
                    deck.addCard(1, 0);
                    deck.addCard(1, 0);
                    deck.addCard(1, 0);
                    break;

                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }
        System.out.println("Opuszczanie...");
        System.exit(0);
    }
}
