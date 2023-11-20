public class Pokoj{
    private int numer;
    private Osoba klient;
    public Pokoj(int n, Osoba os){
        numer = n;
        klient = os;
    }

    public int getNumer(){return numer;}
    public Osoba getKlient(){return klient;}

    public void setNumer(int n){numer = n;}
    public void setKlient(Osoba n){klient = n;}

    public void clear(){
        klient = null;
    }

    public boolean czyWolny(){
        return klient==null;
    }

}
