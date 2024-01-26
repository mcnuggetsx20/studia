import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Z1B{

    static int[][] tab;

    public static void readFile(String filename) throws IOException{
        FileReader file = new FileReader(filename);
        BufferedReader br = new BufferedReader(file);

        ArrayList<String> fileString = new ArrayList<>();
        String line;
        while( (line = br.readLine()) != null){
            fileString.add(line);
        }
        int N  = Integer.valueOf(fileString.get(0).split(": ")[1]);
        tab = new int[N][2];

        for(int i = 2 ; i < fileString.size(); ++i){
            String[] temp = fileString.get(i).split("[\\s]+");
            tab[i-2][0] = Integer.valueOf(temp[1]);
            tab[i-2][1] = Integer.valueOf(temp[2]);
            
        }
        br.close();
        return;

    }

    public static int[] maxDist(){
        double mx = 0, tempDist;
        int[] ans = new int[2];
        for(int i =0; i < tab.length; ++i){
            tempDist = Math.sqrt( Math.pow(tab[i][0], 2) + Math.pow(tab[i][1], 2));
            if(tempDist > mx){
                mx = tempDist;
                ans = tab[i];
            }
        }

        return tab;
    }

    public static void main(String[] args) throws IOException{
        readFile("punkty");
        for(int i =0; i < tab.length; ++i){
            System.out.printf("%3d%3d\n", tab[i][0], tab[i][1]);
        }
        return;
    }
}
