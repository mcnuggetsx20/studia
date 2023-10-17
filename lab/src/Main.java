import java.util.Arrays;
public class Main {
    public static double compute(double x, double n, double s){ return (1/(s*Math.sqrt(2*Math.PI))); }

    public static double c1(double x, double n, double s){ return Math.exp((-((x-n)*(x-n))) / (2*s*s)); }

    public static double time(double v, double t){
        int c = 299792458;
        return t/(Math.sqrt(1-( (v*v)/(c*c) )));
    }

    public static double ns(double n){ return (n/Math.E)*(n/Math.E) * Math.sqrt(2*Math.PI*n);}

    private static boolean ok (double a, double b, double c){
        double[] tab = {a, b, c};
        Arrays.sort(tab);
        return tab[0] + tab[1] > tab[2];
    }
    public static double tri (double a, double b, double c, boolean mode){
        if(!ok(a,b,c)){ return -1;}
        
        //pole
        if (mode){
            double p = (a+b+c)/2;
            return Math.sqrt( p*(p-a)*(p-b)*(p-c) );
        }
        return a + b +c;
        //do domu - jaki trojkat z uwagi na kat, jaki trojkat z uwagi na boki(rownoboczny czy co)
    }

    public static void main(String[] args) {
        System.out.println(tri(1, 1, 5, true));
    }
}
