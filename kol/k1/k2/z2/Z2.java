import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Z2{
    public ArrayList<String> tab = new ArrayList<String>();

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

    public void solve(){
        for(int i = 0 ; i < tab.size(); ++i){
            String[] temp = tab.get(i).split("\\t");
            System.out.println(temp.length);
        }
    }

    public static void main(String[] args) throws IOException{
        Z2 a = new Z2();
        a.readFile("ksiazki");
        a.solve();

        return;
    }
}
