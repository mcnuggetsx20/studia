public class Main {
    public static void main(String[] args) {
        int mx = 0, mn = 10;
        int n = 2023;
        for(int i =n; i>0; i/=10){
             mx = Math.max(mx, i%10);
             mn = Math.min(mn, i%10);
        }
        mn = Math.min(mn, n/10);
        System.out.println(String.format("%d %d",mx, mn));
    } 
}
