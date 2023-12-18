import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.PrintWriter;


public class Z2{
    public ArrayList<String> tab = new ArrayList<String>();
    public int height = 0, width =0;
    public int[][] mat;

    public <T> void readMatrix(String name, boolean mode) throws FileNotFoundException{
        Scanner scanner = mode? new Scanner(new File(name)) : new Scanner(System.in);

        height = scanner.nextInt();
        width = scanner.nextInt();
        scanner.nextLine();

         for(int i = 0; i < height; ++i){
            String temp = scanner.nextLine();
            if(temp.equals("")){continue;}
            tab.add(temp);
        }

        scanner.close();
    }
    public void writeMatrix(String name)throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(name);

        pw.write("Macierz"); pw.println();
        pw.write(String.format("%d", height)); pw.println();
        pw.write(String.format("%d", width)); pw.println();

        for(int i = 0; i < height; ++i){
            pw.print(tab.get(i));
            pw.println();
        }
        pw.close();
        return;
    }

    public void convert(){
        mat = new int[height][width];
        for(int i =0; i < tab.size(); ++i){
            String[] temp = tab.get(i).split("[\\s]+");
            for(int j =0; j < temp.length; ++j){
                mat[i][j] = Integer.valueOf(temp[j]);
            }
        }
    }

    public void display(){
        for(int i = 0 ; i < tab.size();++i){
            System.out.println(tab.get(i));
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        Z2 a = new Z2();
        //a.userInput();
        a.readMatrix("z2", true);
        a.convert();
        a.writeMatrix("zapisano");
        a.display();
        return;
    }
}
