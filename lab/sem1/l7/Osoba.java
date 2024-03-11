public class Osoba{
    String nazwisko, imie;
    public Osoba(String n, String m){
        imie = n;
        nazwisko = m;
    }
    
    public String getImie(){return imie;}
    public String getNazwisko(){return nazwisko;}

    public void setImie(String n){imie = n;}
    public void setNazwisko(String n){nazwisko = n;}

    public String toString(){return imie + " " + nazwisko;}

    public boolean equals(Osoba comp){return imie == comp.imie && nazwisko == comp.nazwisko;}
}
