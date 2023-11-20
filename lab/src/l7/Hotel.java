public class Hotel{
    Pokoj[][] hotel;
    int[] pokNaPi;
    public Hotel(int n, int[] m){
        hotel = new Pokoj[n+1][];

        hotel[0] = new Pokoj[0];

        for(int i= 1; i < hotel.length; ++i){
            hotel[i] = new Pokoj[m[i-1]];
            for(int j = 0; j < hotel[i].length; ++j){
                hotel[i][j] = new Pokoj(100*i+j, null);
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
    int czyWynajmuje(Osoba os){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j < hotel[i].length; ++j){
                if(hotel[i][j].getKlient().equals(os)){
                    return hotel[i][j].getNumer();
                }
            }
        }
        return -1;
    }

    int zwolnijZajete(Osoba os){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j< hotel[i].length;++j){
                if(hotel[i][j].getKlient().equals(os)){
                    hotel[i][j].clear();
                    return 0;
                }

            }
        }
        return -1;
    }

    void listaWolnych(){
        for(int i = 1; i < hotel.length; ++i){
            for(int j = 0; j< hotel[i].length;++j){
                if(hotel[i][j].czyWolny()){
                    System.out.printf("%4d, ", hotel[i][j].getNumer());
                }
            }
            System.out.println();
        }
        return;
    }

    void listaGosci(){
        for(int i = hotel.length-1; i > 0; --i){
            for(int j = 0; j < hotel[i].length; ++j){
                if(hotel[i][j].getKlient()==null){continue;}
                System.out.printf("%12s: %4d%n", hotel[i][j].getKlient().toString(), hotel[i][j].getNumer());
            }
        }
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
        int[] pok = {2,3,6,2,4};
        Hotel h = new Hotel(5, pok);
        
        Osoba o1 = new Osoba("Jan", "Kowalski");
        Osoba o2 = new Osoba("Robert", "Maj");
        Osoba o3 = new Osoba("Borys", "Nowak");
        h.wynajmij(o1);
        h.wynajmij(o2);
        h.wynajmij(o3);

        System.out.println(h.ileWolnych());
        h.display();
        System.out.println(h.znajdzWolny());
        h.listaWolnych();
        h.listaGosci();
        return;
    }
}
