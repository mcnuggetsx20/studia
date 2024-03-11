public class PracownikEtatowy extends Pracownik{

    Double etat = null;

    public PracownikEtatowy(
            String _imie,
            String _nazwisko,
            long _pesel,
            String _stanowisko,
            int _staz,
            double _stawka,
            double _etat
    ){
        super(_imie, _nazwisko, _pesel, _stanowisko, _staz, _stawka);
        etat = _etat;
    }

    @Override
    public double obliczPensje(){
        return stawka * etat;
    }

    public String toString(){
        return super.toString() + String.format(" %3f", etat);
    }

}
