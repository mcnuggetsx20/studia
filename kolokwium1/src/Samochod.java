public class Samochod{
    private String marka, nrRej;
    private int rokProd;
    Osoba wlasciciel;

    public Samochod(String _marka, String _nrRej, int _rok, Osoba _os){
        marka = _marka;
        nrRej = _nrRej;
        rokProd = _rok;
        wlasciciel = _os;
    }
    public String getMarka(){return marka;}
    public String getRej(){return nrRej;}
    public Osoba getWlasciciel(){return wlasciciel;}
    public int getRok(){return rokProd;}
    public boolean equals(Samochod s){return marka == s.getMarka() && nrRej == s.getRej() && wlasciciel == s.getWlasciciel() && rokProd == s.getRok();}
    public String toString(){
            return String.format("%s, %s,%d", marka, nrRej, rokProd) + wlasciciel.toString();
    }
}
