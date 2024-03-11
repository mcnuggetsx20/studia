public class Trojkatna{
    double[][] tab;
    private double RAND = Math.random();

    public Trojkatna(int n){
        tab = new double[n][];
        for(int i = 0; i<n; ++i){tab[i] = new double[i+1];}
    }

    public void randomize(int n, int m){
        for(int i = 0; i < tab.length; ++i){
            for(int j = 0; j <tab[i].length; ++j){
                RAND = Math.random();
                tab[i][j] = (RAND*(m-n))+n;
            }
        }
    }

    public void display(){
        for(int i = 0 ; i< tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                System.out.printf("%8.3f ", tab[i][j]);
            }
            System.out.println();
        }
    }

    public void average(){
        double l = 0;
        for(int i = 0; i < tab.length; ++i){
            l = 0;
            for(int j = 0; j < tab[i].length; ++j){
                l += tab[i][j];
            }
            System.out.printf("%.3f\n", l/tab[i].length);
        }
    }

    public static void main(String[] args){
        Trojkatna a = new Trojkatna(5);
        a.randomize(1, 74);
        a.display();
        System.out.println();
        a.average();
        return;
    }
}
