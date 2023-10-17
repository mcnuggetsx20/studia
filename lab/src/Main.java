import java.util.Arrays;
public class Main {

    private static boolean ok (double a, double b, double c){
        double A = Math.max(a, Math.max(b, c));
        double C = Math.min(a, Math.min(b, c));
        double B = a+b+c-A-C;
        return B+C>A;
    }
    //obwod
    public static double perimeter(double a, double b, double c){
        if(!ok(a,b,c)){ return -1;}
        return a+b+c;
    }
    //pole
    public static double area (double a, double b, double c){
        if(!ok(a,b,c)){ return -1;}
        
        double p = (a+b+c)/2;
        return Math.sqrt( p*(p-a)*(p-b)*(p-c) );
        //do domu - jaki trojkat z uwagi na kat, jaki trojkat z uwagi na boki(rownoboczny czy co)
    }
    //kat
    public static String angle(double a, double b, double c){
        if(!ok(a,b,c)){ return "nie da sie zbudowac takiego trojkata!";}
        double A = Math.max(a, Math.max(b, c));
        double C = Math.min(a, Math.min(b, c));
        double B = a+b+c-A-C;
        String[] vals = {"ostrokatny", "rozwawrtokatny", "prostokatny"};

        int index = (B*B + C*C < A*A) ? 1:0;
        index += 2 * ( (index==0 && (B*B + C*C == A*A)) ? 1:0);
        return vals[index];

    }
    //bok
    public static String length(double a, double b, double c){
        if(!ok(a,b,c)){ return "nie da sie zbudowac takiego trojkata!";}
        if(a==b && b==c){
            return "rownoboczny";
        }
        else if(a==b && b!=c || a==c && c!=b || b==c && c!=a){
            return "rownoramienny";
        }
        return "taki o se zwykly";

    }

    public static void main(String[] args) {
        System.out.println(length());
    }
}
