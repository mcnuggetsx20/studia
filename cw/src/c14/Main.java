public class Main{
    public static int fac(int n){
        if(n==0 || n == 1){return 1;}
        return n * fac(n-1);
    }
    
    public static int sum(int[] tab, int n){
        if(n == -1){
            return 0;
        }
        return tab[n] + sum(tab, n-1);
    }

    public static String toBin(int n){
        if(n == 0){return "0";}
        return toBin(n/2) + n%2;
    }

    public static int binsrch(int[] tab, int target, int l, int h){
        if(l > h){return -1;}
        int m = l + (h -l) / 2;
        if(tab[m] < target){
            return binsrch(tab, target, m+1, h); 
        }
        else if(tab[m] > target){
            return binsrch(tab, target, l, m-1);
        }
        else{return m;}
    }

    public static int gcd(int a, int b){
        if(a==0){return b;}
        return gcd(b%a, a);
    }

    public static void main(String[] args){
        int[] tab = {1, 4, 2, 6};
        System.out.println(sum(tab, tab.length-1));
        System.out.println(toBin(1536));
        return;
    }
}
