import java.util.Arrays;
public class Cyfry{
    int N;

    public Cyfry(int n){N = n;}

    public int[] count(){
        int[] tab = new int[10];
        int n = N;
        while(n!=0){
            ++tab[n%10];
            n/=10;
        }
        return tab;
    }

    public void display(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            if(arr[i]==0){continue;}
            System.out.printf("%d %d\n", i, arr[i]);
        }
    }

    public static void main(String[] args){
        Cyfry a = new Cyfry(542225);
        int[] arr = a.count();
        a.display(arr);
        return;
    }
}
