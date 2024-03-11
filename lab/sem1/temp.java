import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class temp{

    //czytanie z pliku
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

    //tutaj z bufferedreaderem
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

    //wpisywanie do pliku
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

    //odwracanie stringa
    public static String reverse(String s){
        String[] tab = s.split("[\\s]+");
        String res = "";
        for(int i = tab.length-1; i > -1; --i){
            res += tab[i] + " ";
        }
        return res;
    }
}
