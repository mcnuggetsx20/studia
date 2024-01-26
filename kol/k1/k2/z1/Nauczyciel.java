import java.util.ArrayList;
public class Nauczyciel extends Osoba{

    ArrayList<Kurs> kursy = new ArrayList<>();

    public Nauczyciel(String n, String m){
        super(n, m, "Nauczyciel");
    }

    public void addKurs(String n){
        kursy.add(new Kurs(n));
    }

    public void rmKurs(String n){
        for(int i = 0 ; i < kursy.size(); ++i){
            if(kursy.get(i).getPrzedmiot().equals(n)){kursy.remove(i);}
        }
    }
    
    @Override
    public void display(String st){
        System.out.printf("%s %s %s - %s:%n", prof, imie, nazwisko, st);
    }

    @Override
    public void dispInfo(){
        for(int i = 0; i < kursy.size(); ++i){
            kursy.get(i).display();
        }
        System.out.println();
    }
}
