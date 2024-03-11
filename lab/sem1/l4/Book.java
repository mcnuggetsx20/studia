public class Book{
    private String autor, tytul;
    private int strony;
    private boolean wypozyczona;
    
    public Book(String _autor, String _tytul, int _strony){
        autor = _autor;
        tytul = _tytul;
        strony = _strony;
    }

    public void setAutor(String n){autor = n;}
    public void setTytul(String n){tytul = n;}
    public void setStrong(int n){strony = n;}

    public String getAutor(){return autor;}
    public String getTytul(){return tytul;}
    public int getStrony(){return strony;}

    public String toString(){
        return String.format("Autor: %s\nTytuł: %s\nLiczba stron: %d\nCzy wypozyczona: %b", autor, tytul, strony, wypozyczona);
    }

    public void wyswietl(){
        System.out.println(toString());
    }

    public boolean czyDostepna(){return !wypozyczona;}

    public void wypozycz(){
        System.out.println(wypozyczona ? "ksiazka wypozyczona" : "OK");
        wypozyczona = true;
    }

    public void zwrot(){
        System.out.println("Książka zwrócona");
        wypozyczona = false;
    }

    public static void main(String args[]){
        Book lalka = new Book("Boleslaw Prus", "Lalka", 1500);
        lalka.wyswietl();
        lalka.wypozycz();
        lalka.wypozycz();
        lalka.zwrot();
    }

}
