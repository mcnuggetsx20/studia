import java.util.ArrayList;
public class Student extends Osoba{

    ArrayList<Zaliczenie> zaliczenia = new ArrayList<>();

    public Student(String n, String m){
        super(n, m, "Student");
    }

    public void addZaliczenie(String zal, double oc){
        zaliczenia.add(new Zaliczenie(zal, oc));
    }

    public void rmZaliczenie(String zal){
        for(int i = 0 ; i < zaliczenia.size(); ++i){
            if(zaliczenia.get(i).getKurs().equals(zal)){zaliczenia.remove(i); return;}
        }
    }

    @Override
    public double avg(){
        double p = 0, q = 0;
        for(Zaliczenie zal: zaliczenia){
            if(zal.getOcena() == 0){continue;}
            p += zal.getOcena(); q++;
        }
        return p/q;
    }

    @Override
    public void display(String st){
        System.out.printf("%s %s %s - %s:%n", prof, imie, nazwisko, st);
    }

    @Override
    public void dispInfo(){
        for(Zaliczenie zal: zaliczenia){
            zal.display();
        }
        System.out.println();
    }
}
