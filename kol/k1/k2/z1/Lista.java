import java.util.ArrayList;
public class Lista{
    ArrayList<Osoba> osoby = new ArrayList<>();

    public void addOsoba(Osoba os){
        osoby.add(os);
    }

    public void wyswNauczycieli(){
        for(int i = 0; i < osoby.size(); ++i){
            if(!osoby.get(i).getProf().equals("Nauczyciel")){continue;}
            osoby.get(i).display("kursy");
            osoby.get(i).dispInfo();
        }
    }

    public void wyswStudentow(){
        for(int i = 0; i < osoby.size(); ++i){
            Osoba os = osoby.get(i);
            if(!os.getProf().equals("Student")){continue;}
            os.display("oceny");
            os.dispInfo();
        }
    }

    public void wyswStudSred(){
        for(int i = 0; i < osoby.size(); ++i){
            if(!osoby.get(i).getProf().equals("Student")){continue;}
            osoby.get(i).display("srednia");
            System.out.printf("%4.1f%n", osoby.get(i).avg());
        }

    }

    public void allAvg(){
        double p =0, q = 0;
        for(int i = 0; i < osoby.size(); ++i){
            Osoba os = osoby.get(i);
            if(!os.getProf().equals("Student")){continue;}
            p += os.avg();
            q++;
        }
        q = Math.max(q, 1);
        System.out.println(p/q);
    }

}
