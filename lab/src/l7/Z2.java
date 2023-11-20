public class Z2{
    int[][] tab;
    public Z2(int m){
        tab = new int[m][];
        int h = 50, l = 2, max_col = 10;
        for(int i = 0; i < m; ++i){
            int n = (int)(Math.random() * max_col ) + 1;
            tab[i] = new int[n];
            for(int j =0; j < tab[i].length; ++j){
                tab[i][j] = (int)(Math.random() * (h-l)) + l;
            }
        }
    }

    public void display(){
        for(int i = 0; i < tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                System.out.printf("%3d, ", tab[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args){
        Z2 a = new Z2(5);
        a.display();
        return;
    }
}
