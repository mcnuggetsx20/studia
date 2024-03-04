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
        menu.start();
    }
}
