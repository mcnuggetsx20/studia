import java.io.Serializable;
public abstract class Pracownik implements Serializable{
    String nazwisko = null,
           imie = null,
           stanowisko = null;

    Long pesel = null;

    Integer staz = null;

    Double stawka = null;

    public Pracownik(
            String _imie,
            String _nazwisko,
            long _pesel,
            String _stanowisko,
            int _staz,
            double _stawka
    ){
        imie = _imie;
        nazwisko = _nazwisko;
        pesel = _pesel;
        stanowisko = _stanowisko;
        staz = _staz;
        stawka = _stawka;
    }

    public void wyswietl(){
        System.out.println(this.toString());
    }

    public String toString(){
        return String.format("%20s | %20s | %15d | %20s | %3d | %6.2f", nazwisko, imie, pesel, stanowisko, staz, this.obliczPensje());
    }

    public abstract double obliczPensje();
}
