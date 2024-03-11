public class Elko{
    public static double sin(double x, int n){
        double ans = 0;
        double mianownik = 1, pref;
        double licznik = 1/x;
        for(int i =0; i<=n; ++i){
            licznik *= x*x;
            mianownik *= ((2*i)+1) * 2*i;
            mianownik = mianownik==0 ? 1 : mianownik;
            pref = i%2==0 ? 1 : -1;
            //System.out.printf("%f %f %f%n", licznik, mianownik, pref);
            ans += pref*(licznik/mianownik);
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(sin(3.14159265358979,200));
        return;
    }
}
