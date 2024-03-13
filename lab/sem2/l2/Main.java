import java.io.*;
import java.util.Iterator;

public class Main{
    static Pracownik[] arr;
    static Integer size = 0;

    public static void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Dane.ser"))) {
            oos.writeObject((Integer)arr.length);
            for(int i = 0 ; i < arr.length; ++i){
                oos.writeObject(arr[i]);
                System.out.println("1");
            }
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
    }

    public static void read(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dane.ser"))) {
            size = (Integer)ois.readObject();
            arr = new Pracownik[size];
            for(int i =0; i < size; ++i){
                arr[i] = (Pracownik)ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println("i zas");
        }
    }

    public static void display(){
        System.out.println(
        "----------------------------------------------------------------------------------------------------------\n"+
        String.format("%-20s | %-20s | %-15s | %-20s | %-3s | %-6s\n", "Imie", "Nazwisko", "Pesel", "Stanowisko", "Staz", "Pensja")+
        "----------------------------------------------------------------------------------------------------------");

        for(Iterator<Pracownik> iter = new ArrayIterator<>(arr); iter.hasNext();){
            iter.next().wyswietl();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args){
        arr = new Pracownik[7];
        arr[0] = new PracownikGodzinowy("Katarzyna", "Lewandowska", 4567890123L, "Kelnerka", 2, 22, 100);
        arr[1] = new PracownikEtatowy("Anna", "Kowalska", 1234567890L, "Kierownik", 5, 2000, 0.8);
        arr[2] = new PracownikEtatowy("Jan", "Nowak", 2345678901L, "Specjalista", 3, 1800, 1);
        arr[3] = new PracownikGodzinowy("Adam", "Nowak", 1234567890L, "Kasjer", 2, 20.5, 120);
        arr[4] = new PracownikEtatowy("Maria", "Wiśniewska", 3456789012L, "Asystentka", 1, 1500, 0.75);
        arr[5] = new PracownikGodzinowy("Tomasz", "Wiśniewski", 3456789012L, "Magazynier", 3, 18, 160);
        arr[6] = new PracownikEtatowy("Piotr", "Lewandowski", 4567890123L, "Programista", 7, 2500, 0.9);

        read();
        display();
        //write();
        return;
    }
}
