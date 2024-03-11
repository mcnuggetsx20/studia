package l10;
import java.util.Scanner;

public class Z2{
    public static String reverse(String s){
        String[] tab = s.split("[\\s]+");
        String res = "";
        for(int i = tab.length-1; i > -1; --i){
            res += tab[i] + " ";
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Podaj tekst do odwrocenia: ");
        String text = scanner.nextLine();
        scanner.close();

        text = reverse(text);
        System.out.printf("Odwrocona wersja twojego tekstu: %s\n", text);
    }
}
