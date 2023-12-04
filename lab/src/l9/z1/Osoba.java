public class Osoba{
    String imie, nazwisko;
    int stan_konta = 0;

    public Osoba(String _imie, String _nazwisko){
        imie = _imie;
        nazwisko = _nazwisko;
    }

    void setImie(String _imie){imie = _imie;}
    void setNazwisko(String _nazwisko){nazwisko = _nazwisko;}
    void setStanKonta(int n){stan_konta = n;}

    String getImie(){return imie;}
    String getNazwisko(){return nazwisko;}
    int getStanKonta(){return stan_konta;}

    void dodajDoKonta(int n){stan_konta += n;}

    boolean equals(Osoba os){return os.getImie() == imie && os.getNazwisko() == nazwisko;}
}
