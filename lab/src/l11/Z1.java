import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Z1{
    public ArrayList<String> tab = new ArrayList<String>();

    public int count(String target){
        int ans= 0;
        for(int i = 0; i < tab.size(); ++i){
            String[] temp = tab.get(i).split("[.,\\s]+");
            for(int j = 0; j < temp.length; ++j){
                ans += (temp[j].equals(target)) ? 1: 0;
            }
        }
        return ans;
    }

    public void readFile(String name) throws IOException{
        this.tab = new ArrayList<String>();
        FileReader file = new FileReader(name);
        BufferedReader reader = new BufferedReader(file);

        String tempString = reader.readLine();
        while(tempString != null){
            this.tab.add(tempString);
            tempString = reader.readLine();
        }

        reader.close();
        return;
    }

    public void copyFile(String name, String newName) throws IOException{
        FileWriter file = new FileWriter(newName);
        BufferedWriter bw = new BufferedWriter(file);

        readFile(name);

        //wpisujemy
        for(int i = 0; i < tab.size(); ++i){
            bw.write(tab.get(i));
            bw.newLine();
        }
        bw.close();

        return;
    }

    public void solve(){
        int liczbaWierszy = tab.size(),
            liczbaZnakow = 0,
            liczbaSlow = 0,
            maxDlugosc = 0;

        for(int i = 0; i < tab.size();++i){
            String[] temp = tab.get(i).split("[\\s]+");
            liczbaSlow += temp.length;

            temp = tab.get(i).split("[.,\\s]+");
            for(int j = 0; j < temp.length;++j){
                liczbaZnakow += temp[j].length();
                maxDlugosc = Math.max(maxDlugosc, temp[j].length());
            }
        }

        System.out.printf("Liczba wierszy: %3d\n", liczbaWierszy);
        System.out.printf("Liczba znakow: %3d\n", liczbaZnakow);
        System.out.printf("Liczba slow: %3d\n", liczbaSlow);
        System.out.printf("Max dlugosc: %3d\n", maxDlugosc);
    }

    public void printFile(){
        for(int i = 0; i < tab.size(); ++i){
            System.out.println(tab.get(i));
        }
    }

    public static void main(String[] args) throws IOException{
        Z1 a = new Z1();
        a.readFile("pliczek");
        a.printFile();
        a.solve();
        a.copyFile("pliczek", "niezly_plik");
        System.out.println(a.count("ala"));
        return;
    }
}
