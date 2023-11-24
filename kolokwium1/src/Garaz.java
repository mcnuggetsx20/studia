public class Garaz{
    Samochod[] tab = new Samochod[5];
    private int curr = 0;

    public boolean czyMoznaWstawic(){
        if(curr==tab.length){return false;}
        return true;
    }

    public void wstaw(Samochod _sam){
        if(!czyMoznaWstawic()){return;}
        tab[curr] = _sam;
        ++curr;
    }
    public Samochod[] findMarka(String marka){
        Samochod[] res = new Samochod[tab.length];
        int c = 0;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i]==null){continue;}
            if(tab[i].getMarka() == marka){
                res[c] = tab[i];
                c++;
            }
        }
        return res;
    }

    public Samochod[] findWlas(Osoba os){
        Samochod[] res = new Samochod[100];
        int c = 0;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i]==null){continue;}
            if(tab[i].getWlasciciel().equals(os)){
                res[c] = tab[i];
                c++;
            }
        }
        return res;

    }

    public Samochod[] findStare(int rok ){
        Samochod[] res = new Samochod[100];
        int c = 0;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i]==null){continue;}
            if(tab[i].getRok() == rok){
                res[c] = tab[i];
                c++;
            }
        }
        return res;

    }

    public void displayCar(Samochod[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.printf("%s, %s,%d", arr[i].getMarka(), arr[i].getRej(), arr[i].gerRok());
            arr[i].getWlasciciel().toString();
        }
    }

    public static void main(String[] args){
        return;
    }
}
