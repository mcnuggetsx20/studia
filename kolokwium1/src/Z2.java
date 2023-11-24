import java.util.Random;
public class Z2{
    private double[][] tab;
    private double RAND = Math.random();
    private int maxRow = 0;

    public Z2(int n){
        tab = new double[n][];

        for(int i = 0; i < tab.length; ++i){
            Random rand = new Random();
            int temp = rand.nextInt(5) + 1;
            tab[i] = new double[temp];
            maxRow = Math.max(maxRow, temp);
        }
    }

    public void randomize(int z){
        for(int i = 0; i < tab.length; ++i){
            for(int j = 0; j <tab[i].length; ++j){
                tab[i][j] = Math.random()*z;
            }
        }
    }

    //zwraca srednia w n-tym wierszu
    public double avg(int n){
        double m = 0;
        for(int i =0; i < tab[n].length; ++i){
            m+= tab[n][i];
        }
        return m/tab[n].length;
    }

    public void display(){
        for(int i = 0 ; i< tab.length; ++i){
            for(int j = 0; j < tab[i].length; ++j){
                System.out.printf("%8.3f ", tab[i][j]);
            }
            System.out.println();
        }
    }

    public double[][] toRect(){
        double[][] rect = new double[tab.length][maxRow];
        for(int i = 0; i < tab.length; ++i){
            for(int j = 0; j < maxRow; ++j){
                if(j >= tab[i].length){rect[i][j] = -1.0;}
                else{rect[i][j] = tab[i][j];}
            }
        }
        return rect;
    }

    public void display_avgs(){
        for(int i = 0; i < tab.length; ++i){
            double temp = avg(i);
            System.out.printf("srednia wiersza %d: %8.3f%n", i, temp);
        }
    }
    
    //0 - wyswietlanie wierszami
    //1 - wyswietlanie kolumnami
    public void displayRect(int M, double rect[][]){
        boolean mode = M==0?false:true;
        for(int i = 0; i < (mode?rect[0].length:rect.length); ++i){
            for(int j = 0; j < (mode?rect.length:rect[i].length); ++j){
                System.out.printf("%8.3f ", rect[mode?j:i][mode?i:j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Z2 a = new Z2(5);
        a.randomize(50);
        System.out.println("Bazowa tablica:");
        a.display();
        a.display_avgs();

        System.out.println("\nProstokatna wersja tablicy:");
        double[][] rect = a.toRect();
        a.displayRect(0,rect);
        System.out.println("\nProstokatna wersja tablicy wyswietlona kolumnami:");
        a.displayRect(1,rect);
    }
}
