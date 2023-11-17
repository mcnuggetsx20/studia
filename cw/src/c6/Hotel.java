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
        if(ind == -1){return 1}
        hotel[ind/100][ind%100].setKlient(os);
        return 0;
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
        return;
    }
}
