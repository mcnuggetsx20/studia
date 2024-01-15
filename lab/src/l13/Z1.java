import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Z1{
    static ArrayList<String> tab = new ArrayList<>();

    public static void read(String name) throws IOException{
        FileReader file = new FileReader(name);
        BufferedReader reader = new BufferedReader(file);

        char[] c = new char[(int)1e6];
        reader.read(c);

        String tempString = new String(c);
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(tempString.split("\\n")));
        for(int i = 0 ; i < lines.size(); ++i){
            tab.add(lines.get(i));
        }
        return;
    }

    public static void write(String name) throws IOException{
        HashMap<String, Integer> cntrs = new HashMap<String, Integer>();
        for(int i = 1 ; i < tab.size(); ++i){
            String[] temp = tab.get(i).split("\\t");
            if(!cntrs.containsKey(temp[1])){
                cntrs.put(temp[1], 0);
            }
            cntrs.put(temp[1], cntrs.get(temp[1]) + 1);
            //cntrs.get(temp[1])++;
        }

        FileWriter file = new FileWriter(name);
        BufferedWriter bw = new BufferedWriter(file);

        bw.write(String.format("%2s%10s%10s%n", "Lp", "Kraj", "Liczba"));
        ArrayList<String> keyList = new ArrayList<>(cntrs.keySet());

        for(int i = 0; i < keyList.size(); ++i){
            bw.write(String.format("%2d%10s%10d%n", i+1, keyList.get(i), cntrs.get(keyList.get(i))));
        }
        bw.close();

    }

    public static int getByCountry(String country){
        int ans = 0;
        for(int i= 1 ; i < tab.size(); ++i){
            String[] temp = tab.get(i).split("\\t");
            if(temp[1].equals(country)){
                ++ans;
                //System.out.printf("%s %s%n", temp[2], temp[3]);
                System.out.println(temp[2]);
            }
        }
        return ans;
    }

    public static int getRank(String name){
        for(int i = 1; i < tab.size(); ++i){
            String[] temp = tab.get(i).split("\\t");
            if(name.equals(temp[2])){
                return Integer.valueOf(temp[0]);
            }
        }
        return -1;
    }

    public static double avgAge(){
        double p = 0, q = 0;
        for(int i = 1 ; i < 11; ++i){
            String[] temp = tab.get(i).split("\\t");
            p += Integer.valueOf(temp[3]);
            q++;
        }
        return p/q;

    }

    public static void displayTop50(){
        for(int i = 1; i <= 50; ++i){
            System.out.println(tab.get(i));
        }
    }
    public static void main(String[] args) throws IOException{
        read("ATP_ranking.txt");
        System.out.println("Top 50");
        displayTop50();

        System.out.println("\nWyswietlanie wzgledem kraju:");
        System.out.println(getByCountry("ITA"));

        System.out.println("\nWyswietlanie rangi podanego zawodnika");
        System.out.println(getRank("Dusan Lajovic"));

        System.out.println("\nWyswietlanie sredniej wieku");
        System.out.println(avgAge());

        write("file");

        return;
    }
}
