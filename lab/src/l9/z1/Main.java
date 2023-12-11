import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Osoba a = new Osoba("jan", "pietrzak");
        Osoba b = new Osoba("dominik", "misztal");
        Osoba c = new Osoba("borys", "nowak");

        Dom n1 = new Dom("grabiszynska", 500, 120, 2500);
        Mieszkanie n2 = new Mieszkanie("wykladnicza", 100, 50, 1000);
        Dom n3 = new Dom("Narciarska", 500, 120, 2500);

        Firma f = new Firma(100000);
        f.dodajNier(n1);
        f.dodajNier(n2);
        f.wypiszWolne();
        f.dodajNier(n3);
        return;
    }
}

class Firma{
    ArrayList<Nieruchomosc> tab = new ArrayList<Nieruchomosc>();
    int budzet;
    public Firma(int _b){
        budzet = _b;
    }

    void dodajNier(Nieruchomosc n){tab.add(n);}

    void wynajmijNier(Osoba os){
        for(int i = 0; i < tab.size(); ++i){
            if(tab.get(i).free()){
                tab.get(i).wynajmij(os);
                budzet += tab.get(i).getKosztW();
                return;
            }
        }
    }

    void zwolnijNierAdres(String adres){
        for(int i = 0; i < tab.size(); ++i){
            if(tab.get(i).getAdres() == adres){
                tab.get(i).zwolnij();
                budzet -= tab.get(i).getKosztS();
                tab.get(i).posprzataj();
                return;
            }
        }
    }
    void zwolnijNierOs(Osoba os){
        for(int i = 0; i < tab.size(); ++i){
            if(tab.get(i).getMieszkaniec().equals(os)){
                tab.get(i).zwolnij();
                budzet -= tab.get(i).getKosztS();
                tab.get(i).posprzataj();
                return;
            }
        }
    }

    void wypiszWolne(){
        for(int i = 0; i < tab.size(); ++i){
            if(tab.get(i).free()){
                System.out.println(tab.get(i).getAdres());
            }
        }
    }
}

class Mieszkanie extends Nieruchomosc{
    public Mieszkanie(String _adres, int _area, int _kosztS, int _kosztW){
        super(_adres, _area, _kosztS, _kosztW);
    }
}

class Dom extends Nieruchomosc{
    public Dom(String _adres, int _area, int _kosztS, int _kosztW){
        super(_adres, _area, _kosztS, _kosztW);
    }
}

class Nieruchomosc{
    String adres;
    int area, kosztSprzatania, kosztWynajmu;
    boolean czyCzysta = true;
    public Osoba mieszkaniec = null;

    public Nieruchomosc(String _adres, int _area, int _kosztS, int _kosztW){
        adres = _adres;
        area = _area;
        kosztSprzatania = _kosztS;
        kosztWynajmu = _kosztW;
    }

    int getKosztW(){return kosztWynajmu;}
    int getKosztS(){return kosztSprzatania;}
    String getAdres(){return adres;}
    Osoba getMieszkaniec(){return mieszkaniec;}

    void setMieszkaniec(Osoba os){mieszkaniec = os;}
    boolean czysta(){return czyCzysta;}
    boolean free(){return mieszkaniec == null;}

    void wynajmij(Osoba os){setMieszkaniec(os);}

    void zwolnij(){
        czyCzysta = false;
        mieszkaniec = null;
    }

    void posprzataj(){czyCzysta = true;}

}
