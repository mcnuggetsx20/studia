public class Tablica2{
    private int[][] tab;
    private double RAND = Math.random();

    public Tablica2(int n, int m){
        tab = new int[n][m];
    }

    public Tablica2(int n, int m, int l, int h){
        tab = new int[n][m];

        for(int i = 0; i < tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                RAND = Math.random();
                tab[i][j] = (int)(RAND * (h-l))+l;
            }
        }
    }

    //0 - wyswietlanie wierszami
    //1 - wyswietlanie kolumnami
    public void display(int M){
        boolean mode = M==0?false:true;
        for(int i = 0; i < (mode?tab[0].length:tab.length); ++i){
            for(int j = 0; j < (mode?tab.length:tab[i].length); ++j){
                System.out.printf("%5d ", tab[mode?j:i][mode?i:j]);
            }
            System.out.println();
        }
    }

    public int accumulate(){
        int ans =  0;
        for(int i= 0; i< tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                ans += tab[i][j];
            }
        }
        return ans;
    }

    public int[] max(){
        int res[] = new int[3];
        for(int i= 0; i< tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                if(res[0] < tab[i][j]){
                    res[0] = tab[i][j];
                    res[1]=i; res[2] = j;
                }
            }
        }
        return res;
    }

    public void find(int target){
        boolean ok = false;
        for(int i = 0 ; i< tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                if(tab[i][j] == target){
                    ok = true;
                    System.out.printf("%3d %3d\n", i, j);
                }
            }
        }
        if(!ok){System.out.println("-1 -1");}
    }

    public int[] column_sum(){
        int[] sum = new int[tab[0].length];
        for(int i = 0 ; i < tab[0].length; ++i){
            for(int j = 0; j < tab.length; ++j){
                sum[i] += tab[j][i];
            }
        }
        return sum;
    }

    public int[] max_column(){
        int[] sum = column_sum();
        int[] ans = new int[2];
        for(int i = 0 ; i < sum.length; ++i){
            if(ans[0] < sum[i]){
                ans[0] = sum[i]; ans[1] = i;
            }
        }
        return ans;
    }

    public void shrink(){
        int[] ind = max();
        for(int i = 0; i < tab.length; ++i){
            if(i==ind[1]){continue;}
            for(int j = 0; j< tab[i].length; ++j){
                if(j == ind[2]){continue;}
                System.out.printf("%3d", tab[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Tablica2 a = new Tablica2(5,3, 1, 50);
        System.out.println("Bazowa tablica:");
        a.display(0);
        System.out.printf("Suma calej tablicy: %d%n", a.accumulate());

        System.out.printf("Maximum i jego indeksy: ");
        int[] mx = a.max();
        for(int i = 0 ; i < 3; ++i){
            System.out.printf("%3d ", mx[i]);
        }
        System.out.println();

        System.out.printf("Znalezienie elementu: ");
        a.find(48);

        System.out.printf("Wypisanie sum w kolumnach: ");
        int[] sum = a.column_sum();
        for(int i =0; i < sum.length; ++i){
            System.out.printf("%d ", sum[i]);
        }
        System.out.println();
        
        System.out.println("Wartosc maksymalnej kolumny i jej indeks: ");
        int[] max_column = a.max_column();
        for(int i = 0 ; i< max_column.length; ++i){
            System.out.printf("%d ", max_column[i]);
        }
        System.out.println("\n");

        System.out.println("Usuniecie wiersza i kolumny:");
        a.shrink();

        return;
    }
}
