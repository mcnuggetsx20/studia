public class PracownikGodzinowy extends Pracownik{
    Long liczba_godzin = null;

    public PracownikGodzinowy(
            String _imie,
            String _nazwisko,
            long _pesel,
            String _stanowisko,
            int _staz,
            double _stawka,
            long _liczba_godzin
    ){
        super(_imie, _nazwisko, _pesel, _stanowisko, _staz, _stawka);
        liczba_godzin = _liczba_godzin;
    }

    @Override
    public double obliczPensje(){
        return stawka * liczba_godzin;
    }

    public String toString(){
        return super.toString() + String.format(" %3d", liczba_godzin);
    }
}
