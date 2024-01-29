import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


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

    public static void writeFile(String filename) throws IOException{
        FileWriter file = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(file);

        readFile("punkty");

        int[] b = maxDist();
        bw.write(String.format("Najbardziej odlegly od poczatku ukladu\n"));
        bw.write(String.format("%3d%3d\n", b[0], b[1]));

        int[][] a = rect();

        bw.write(String.format("minx, maxx, miny, maxy"));
        for(int[] i: a){
            bw.write(String.format("%3d%3d\n", i[0], i[1])); 
        }

        a = maxDist2();
        bw.write(String.format("Dwa najbardziej odlegle od siebie\n"));
        for(int[] i: a){
            bw.write(String.format("%3d%3d\n", i[0], i[1])); 
        }

        bw.write(String.format("Posortowane"));
        for(Map.Entry <int[], Double> en : sort()){
            bw.write(String.format("%3d%3d%8.2f\n", en.getKey()[0], en.getKey()[1],en.getValue()));
        }

        bw.close();
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

        return ans;
    }

    public static int[][] maxDist2(){
        int[][] ans = new int[2][];
        double mx = 0, tempDist;
        for(int[] i: tab){
            for(int[] j: tab){
                tempDist = Math.sqrt( Math.pow(i[0]-j[0], 2) + Math.pow(i[1]-j[1], 2));
                if(tempDist > mx){
                    mx = tempDist;
                    ans[0] = i; ans[1] = j;
                }
            }
        }
        return ans;
    }

    public static int[][] rect(){
        int[][] res = new int[4][];
        int mx= 0, my=0, mnx = 1000000, mny = 10000000;
        for(int[] i : tab){
            if(i[0] < mnx){res[0] = i; mnx = i[0];}
            else if(i[0] > mx){res[1] = i; mx = i[0];}
            else if(i[1] < mny){res[2] = i; mny = i[1];}
            else if(i[1] > my){res[3] = i; my = i[1];}
        }

        return res;
    }

    public static List<Map.Entry<int[], Double>> sort(){
        double tempDist;
        HashMap <int[], Double> mp = new HashMap<>();
        for(int[] i : tab){
            tempDist = Math.sqrt( Math.pow(i[0], 2) + Math.pow(i[1], 2));
            mp.put(i, tempDist);
        }

        List<Map.Entry<int[], Double>> sorted = mp.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());

        for(Map.Entry <int[], Double> en : sorted){
            System.out.printf("%3d%3d%8.2f\n", en.getKey()[0], en.getKey()[1],en.getValue());
        }
        return sorted;
    }


    public static void main(String[] args) throws IOException{
        readFile("punkty");
        writeFile("odpowiedzi");

        return;
    }
}
