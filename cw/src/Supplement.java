public class Supplement {

    public static void quad(double a, double b, double c){
        if(a==0){
            if(b==0){
                if(c==0){
                    System.out.println("rownanie tozsamosciowe");
                    return;
                }
                System.out.println("rownanie sprzeczne");
                return;
            }
            System.out.printf("Jedno rozwiazanie: x=%f\n", -c/b);
            return;
        }
        double delta = b*b - 4*a*c;
        if(delta < 0){System.out.println("rownanie nie ma rozwiazan");return;}
        else if(delta==0){System.out.printf("rownanie ma jedno rozwiazanie: x=%f\n", -b/(2*a)); return;}
        System.out.printf("rownanie ma dwa rozwiazania: \nx1=%f\nx2=%f\n", (-b+Math.sqrt(delta))/(2*a), (-b-Math.sqrt(delta))/(2*a));
    }

    public static int len(int n){
        int ans = 1;
        n/=10;
        while(n>0){
            n/=10;
            ++ans;
        }
        return ans;
    }

    public static int gcd(int a, int b){
        if(a==0){return b;}
        return gcd(b%a, a);
    }

    public static double ex(int x, int eps){
        double ans = 0;
        double div = 1, t = 1;
        int i = 1;
        
        while(t/div > eps){
            ans += t/div;

            div *= i;
            t *= x;
            ++i;

        }
    }
}
