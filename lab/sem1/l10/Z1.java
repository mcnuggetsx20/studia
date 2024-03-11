import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Z1{
    public static int[][] gen(int n, int m){
        int[][] tab = new int[n][m];
        for(int i=0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                tab[i][j] = (int)(Math.random() * 50 + 1);
            }
        }
        return tab;
    }
    public static void writeMatrix(int[][] mat, String name) throws IOException{
        //inicjacja writerow
        FileWriter file = new FileWriter(name);
        BufferedWriter bw = new BufferedWriter(file);

        //wpisywanie
        bw.write("Macierz"); bw.newLine();
        bw.write(String.format("%d", mat.length)); bw.newLine();
        bw.write(String.format("%d", mat[0].length)); bw.newLine();

        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat[i].length; ++j){
                bw.write(String.format("%4d ", mat[i][j]));
            }
            bw.newLine();
        }
        bw.close();
        return;
    }

    public static int[][] readMatrix(String name) throws IOException{
        //inicjacja readerow
        FileReader file = new FileReader(name);
        BufferedReader reader = new BufferedReader(file);

        //niezle zmienne
        int[][] res;
        char[] c = new char[150];
        String[] stringArr;

        //operacje zczytujace i parsujace
        reader.read(c);
        String tempString = new String(c);
        stringArr = tempString.split("[\\s]+");

        int height = Integer.valueOf(stringArr[1]); 
        int width = Integer.valueOf(stringArr[2]);
        int counter = 3;
        res = new int[height][width];

        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                res[i][j] = Integer.valueOf(stringArr[counter]);
                ++counter;
            }
        }
        reader.close();
        return res;
    }

    public static double avg(int[][] tab){
        double size = tab.length * tab[0].length;
        double sum = 0;
        for(int i = 0; i < tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                sum += tab[i][j];
            }
        }
        return sum / size;
    }

    public static void display(int[][] vp){
        for(int i = 0; i < vp.length; ++i){
            for(int j = 0; j < vp[i].length; ++j){
                System.out.printf("%4d ", vp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        //int[][] a = gen(5, 4);
        //writeMatrix(a, "macierz");
        int[][] b = readMatrix("macierz");
        display(b);
        System.out.printf("%.3f\n", avg(b));
        return;
    }

}
