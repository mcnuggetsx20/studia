public class L3{
    //zadanie 1
    public static void mult(){
    System.out.printf("     ");
        for(int i = 1; i <=10; ++i){
            System.out.printf("%4d", i);
        }
        System.out.println("\n     ----------------------------------------");
        for(int i = 1; i <=10; ++i){
            System.out.printf("%4d|", i);
            for(int j =1; j<=10; ++j){
                System.out.printf("%4d", i*j);
            }
            System.out.println();
        }
    }

    //zadanie 2
    public static void mat(double start, double stop, double step){
        System.out.printf("%8s%8s%8s%8s%8s%8s%8s%n", "x", "x^1/2", "x^2", "x^3", "e^x", "ln(x)", "log(x)");
        for(double i = start; i<=stop+step; i+=step){
            System.out.printf("%8.3f%8.3f%8.3f%8.3f%8.3f%8.3f%8.4f%n", i, Math.sqrt(i), i*i, i*i*i, Math.pow(Math.E, i), Math.log(i), Math.log10(i));
        }
    }

    //zadanie 3
    public static boolean[] sieve(int a, int n){
        boolean[] tab = new boolean[n+1];
        tab[0] = true; tab[1] = true;
        for(int i = 2; i< n+1; ++i){
            for(int j = i; j<=n/i ;++j){
                tab[i*j] = true;
            }
        }

        //liczba -1245 jest kodem ktory blokuje wypisywanie
        if(a!=-1245){
            for(int i = a; i<n+1; ++i){
                if(tab[i]){continue;}
                System.out.printf("%d%n", i);
            }
        }

        return tab;
    }

    public static void isPrime(int n){
        System.out.printf("liczba %d jest ", n);
        System.out.println(sieve(-1245, n)[n] ? "niepierwsza" : "pierwsza");
    }

    //zadanie 4
    //podejscie z reszta
    public static int nwd_reszta(int n, int m){
        if(n==0){return m;}
        return nwd_reszta(m%n, n);
    }

    //podejscie z odejmowaniem
    public static int nwd_odejmowanie(int n, int m){
        if(n!=m){
            return nwd_odejmowanie(n>m?n-m:n, n>m?m:m-n);
        }
        return n;
    }

    public static void main(String[] args){
        //1
        mult();
        System.out.println();
        
        //2
        mat(1, 2, 0.1);
        System.out.println();
        
        //3
        sieve(5, 20);
        isPrime(7);
        System.out.println();
        
        //4
        System.out.println(nwd_reszta(40, 40));
        System.out.println(nwd_odejmowanie(40, 40));
        return;
    }
}
