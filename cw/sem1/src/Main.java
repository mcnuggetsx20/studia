public class Main {
    public static int reverse(int n){
        int ans;
        for(ans = 0; n >0; ans*=10){
            ans += n%10;
            n/=10;
        }
        return ans/10;
    }
    public static void main(String[] args) {
        System.out.println(reverse(1276));
    }
}
