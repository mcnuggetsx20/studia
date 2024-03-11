import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Z1A{
    public static int[] gen(){
        Random rand = new Random();
        int[] res = new int[2];
        res[0] = rand.nextInt(0, 10);
        res[1] = rand.nextInt(0, 10);
        return res;
    }

    public static void writeFile(String filename, int n) throws IOException{
        FileWriter file = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(file);

        bw.write(String.format("Liczba punktow: %2d\n%3s%3s\n",n, "x", "y"));
        int[] a;
        for(int i = 0; i < n; ++i){
            a = gen();
            bw.write(String.format("%3d%3d%s", a[0], a[1], (i==n-1) ? "" : "\n"));
        }

        bw.close();
        return;
    }

    public static void main(String[] args) throws IOException{
        writeFile("punkty", 10);
        return;
    }
}


