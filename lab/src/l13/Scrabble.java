import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Scrabble{
    public static List<String> p1 = Arrays.asList( "A", "E", "I", "N", "O", "R", "S", "W", "Z",  "a", "e", "i", "n", "o", "r", "s", "w", "z");
    public static List<String> p2 = Arrays.asList("C", "D", "K", "L", "M", "P", "T", "Y", "c", "d", "k", "l", "m", "p", "t", "y");
    public static List<String> p3 = Arrays.asList("B", "G", "H", "J", "Ł", "U", "b", "g", "h", "j", "ł", "u");
    public static List<String> p5 = Arrays.asList("Ą", "Ę", "F", "Ó", "Ś", "Ż", "ą", "ę", "f", "ó", "ś", "ż");
    public static List<String> p6 = Arrays.asList("Ć", "ć");
    public static List<String> p7 = Arrays.asList("Ń", "ń");
    public static List<String> p9 = Arrays.asList("Ź", "ź");

    public static int ptsTotal = 0;

    public static HashMap<String, Integer> mp = new HashMap<String, Integer>();

    public static int calculatePoints(String word){
        int ans = 0;
        for(int i = 0 ; i < word.length(); ++i){
            String temp = String.valueOf(word.charAt(i));
            ans += 
                (p1.contains(temp) ? 1: 0) +
                (p2.contains(temp) ? 2: 0) +
                (p3.contains(temp) ? 3: 0) +
                (p5.contains(temp) ? 5: 0) +
                (p6.contains(temp) ? 6: 0) +
                (p7.contains(temp) ? 7: 0) +
                (p9.contains(temp) ? 9: 0);
        }
        ptsTotal += ans;

        if(!mp.containsKey(word)){
            mp.put(word, 0);
        }
        mp.put(word, mp.get(word) + ans);

        return ans;
    }

    public static void displayScore(){
        System.out.printf("Laczna liczba punktow: %d%n", ptsTotal);

        List<Map.Entry<String, Integer>> sorted = mp.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());

        for(Map.Entry <String, Integer> en : sorted){
            System.out.printf("%10s%5d\n", en.getKey(), en.getValue());
        }
    }

    public static void main(String[] args){
        System.out.println("start");
        while(true){
            Scanner scanner = new Scanner(System.in);
            String temp = scanner.nextLine();
            if(temp.equals("end")){displayScore(); scanner.close(); return;}
            System.out.printf("Punkty za to slowo: %4d\n", calculatePoints(temp));
        }
    }
}
