public class Z1{
    boolean[] sieve;
    int start, stop;
    int N=1000000;

    public Z1(int a, int b){
        sieve = new boolean[N];
        sieve[0] = true; sieve[1] = true;
        for(int i = 2; i < N; ++i){
            for(int j = i; j <= N/i - 1; ++j){
                sieve[i*j] = true;
            }
        }
        start = a;
        stop = b;
    }

    public int reverse(int n){
        int ans = 0;
        int d = 1;
        int log = 1;
        while(n/log > 0){
            log*=10;
        }
        log /=10;
        int rev = 1;
        while(log != 0){
            ans += n/log * rev;
            n%=log;
            log/=10;
            rev *= 10;
        }
        return ans;
    }

    //metoda wyswietlajaca odpowiedz
    public void solve(){
        for(int i = start; i <=stop; ++i){
            int temp = reverse(i);
            if(sieve[i] || sieve[temp]){continue;}
            System.out.printf("%d %d%n", i, reverse(i));
        }
    }

    public static void main(String[] args){
        Z1 a = new Z1(11 ,1000);
        a.solve();
    }
}
