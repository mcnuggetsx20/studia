public class Test{
    public static void main(String[] args){
        Student s1 = new Student("borys", "nowak");
        Student s2 = new Student("michal", "kosiacki");

        Nauczyciel n1 = new Nauczyciel("Pawel", "Gielgier");
        Nauczyciel n2 = new Nauczyciel("Paulina", "Stajno");

        Lista l = new Lista();

        n1.addKurs("matematyka");
        n2.addKurs("geometria");
        n2.addKurs("fizyka");

        s1.addZaliczenie("fizyka", 5);
        s2.addZaliczenie("programowanie", 3.3);

        l.addOsoba(s1);
        l.addOsoba(s2);
        l.addOsoba(n1);
        l.addOsoba(n2);

        System.out.println("Wyswietlanie Studentow:");
        l.wyswStudentow();

        System.out.println("Wyswietlanie Nauczycieli:");
        l.wyswNauczycieli();

        System.out.println("Wyswietlanie Studentow ze srednimi");
        l.wyswStudSred();

        System.out.println("Srednia wszystkich uczniow");
        l.allAvg();

    }
}
