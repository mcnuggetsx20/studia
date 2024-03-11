public class Hotel{
    Pokoj[][] hotel;
    int[] pokNaPi;

    public Hotel(int n, int[] m){
        hotel = new Pokoj[n][];

        hotel[0] = new Pokoj[0];

        for(int i= 1; i < hotel.length; ++i){
            hotel[i] = new Pokoj[m[i]];
            for(int j = 0; j < hotel[i].length; ++j){
                hotel[i][j] = new Pokoj(i * 100 + j, null);
            }
        }
    }

    public int ileWolnych(){
        int ans = 0;
        for(int i = 1; i < hotel.length;++i){
            for(int j = 0; j < hotel[i].length; ++j){
                ans += hotel[i][j].czyWolny() ? 1: 0;
            }
        }
        return ans;
    }

    public int znajdzWolny(){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j < hotel[i].length; ++j){
                if(hotel[i][j].czyWolny()){
                    return hotel[i][j].getNumer();
                }
            }
        }
        return -1;
    }

    int wynajmij(Osoba os){
        int ind = znajdzWolny();
        if(ind == -1){return 1;}
        hotel[ind/100][ind%100].setKlient(os);
        return 0;
    }

    boolean czyWolny(int n){return hotel[n/100][n%100].czyWolny();}

    public int czyOsobaWynajmuje(Osoba os){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j < hotel[i].length; ++j){
                if(hotel[i][j].equals(os)){
                    return i*100 + j;
                }
            }
        }
        return -1;
    }

    public int zwolnijZajetePrzez(Osoba os){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j < hotel[i].length; ++j){
                if(hotel[i][j].equals(os)){
                    hotel[i][j].clear();
                    return 0;
                }
            }
        }
        return 1;
    }

    public void listaWolnych(){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j < hotel[i].length; ++j){
                if(hotel[i][j].czyWolny()){
                    System.out.printf("%4d, ", i*100 + j);
                }
            }
        }
        return;
    }

    public void listaGosci(){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j < hotel[i].length; ++j){
                if(!hotel[i][j].czyWolny()){
                    System.out.println(hotel[i][j].getKlient().toString());
                }
            }
        }
        return;
    }

    public void display(){
        for(int i = hotel.length-1; i > -1; --i){
            for(int j = 0; j < hotel[i].length; ++j){
                System.out.printf("%4d, ", hotel[i][j].getNumer());
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[] pok = {0,3,6,2,4};
        Hotel h = new Hotel(5, pok);
        System.out.println(h.ileWolnych());
        h.display();
        System.out.println(h.znajdzWolny());
        Osoba parowa = new Osoba("michal", "strugarek");
        h.wynajmij(parowa);
        h.listaGosci();
        h.listaWolnych();
        return;
    }
}
