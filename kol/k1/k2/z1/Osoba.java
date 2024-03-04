public class Osoba{
    String nazwisko, imie, prof;
    public Osoba(String n, String m, String p){
        imie = n;
        nazwisko = m;
        prof = p;
    }
    
    public String getImie(){return imie;}
    public String getNazwisko(){return nazwisko;}
    public String getProf(){return prof;}

    public void setImie(String n){imie = n;}
    public void setNazwisko(String n){nazwisko = n;}

    public String toString(){return imie + " " + nazwisko;}

    public boolean equals(Osoba comp){return imie == comp.imie && nazwisko == comp.nazwisko;}

    public void display(String a){
        return;
    }

    public void dispInfo(){
        return;
    }
    public double avg(){return 0.0;}
}
