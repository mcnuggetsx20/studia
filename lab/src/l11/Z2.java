import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Z2{
    public ArrayList<String> tab = new ArrayList<String>();
    public int height = 0, width =0;
    public int[][] mat;

    public void userInput(){
        Scanner scanner = new Scanner(System.in);

         height = scanner.nextInt();
         width = scanner.nextInt();

         mat = new int[height][width];

         for(int i = 0; i < height+1; ++i){
             tab.add(scanner.nextLine());
         }

         scanner.close();
    }

    public void readFile(String name){
        Scanner scanner = new Scanner(new File(name));

        height = scanner.nextInt();
        width = scanner.nextInt();
        mat = new int[height][width];

        int c = 0;
        while(scanner.hasNextLine()){
            tab.add(scanner.nextLine());
        }

        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                res[i][j] = Integer.valueOf(stringArr[counter]);
                ++counter;
            }
        }

        scanner.close();
    }

    public static void main(String[] args){
        Z2 a = new Z2();
        a.userInput();
        return;
    }
}
