import java.util.Collections;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class Tablica{
    public int[] tab;
    private boolean roznowartosciowa = true;
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

    private double RAND = Math.random();

    public Tablica(int n){
        tab = new int[n];
    }
    public Tablica(int[] arr){
        tab = arr.clone();
    }

    public void randomize(int n, int m){
        for(int i = 0; i < tab.length; ++i){
            RAND = Math.random();
            tab[i] = (int)(RAND*(m-n))+n;
        }

        for(int i = tab.length-1; i> -1; --i){
            roznowartosciowa = roznowartosciowa &&  (mp.get(tab[i]) == null);
            mp.put(tab[i], i);
        }
    }
    
    public void display(){
        System.out.printf("{");
        for(int i = 0; i<tab.length; ++i){
            System.out.printf("%d", tab[i]);
            if(i!=tab.length-1){System.out.printf(", ");}
        }
        System.out.println("}");
    }

    public void reverse(){
        for(int i = 0; i < tab.length/2; ++i){
            int temp = tab[i];
            tab[i] = tab[tab.length-i-1];
            tab[tab.length-i-1] = temp;
        }
    }

    public int find(int target){
        int[] copy = tab.clone();
        Arrays.sort(copy);

        int l = 0, r = copy.length-1, m;
        while(l <=r){
            m = (l+r)/2;
            if(copy[m] == target){return mp.get(target);}
            else if(copy[m] < target){l = m+1;}
            else{r = m-1;}
        }
        return -1;
    }

    public void max(){
        int ans = 0;
        for(int i = 0; i<tab.length; ++i){
            ans = Math.max(ans, tab[i]);
        }
        System.out.printf("%d ", ans);
        System.out.println(mp.get(ans));

    }

    public void min(){
        int ans = tab[0];
        for(int i = 0; i<tab.length; ++i){
            ans = Math.min(ans, tab[i]);
        }
        System.out.printf("%d ", ans);
        System.out.println(mp.get(ans));
    }


    public int[] transform(){
        if(roznowartosciowa){return tab;}
        int[] res = new int[mp.size()];
        int ind = 0;
        for(int i = 0;i <tab.length;++i){
            if(mp.get(tab[i])==i){
                res[ind]=tab[i];
                ++ind;
            }
        }
        return res;
    }

    public int[] getTab(){return tab;}
    public boolean czyRoznowartosciowa(){return roznowartosciowa;}

    public static void main(String args[]){
        Tablica a = new Tablica(6);
        a.randomize(1, 10);
        a.display();

        Tablica b = new Tablica(a.transform());
        b.display();

        a.reverse();
        a.display();
        System.out.println(a.find(3));
        a.max();
        a.min();
        System.out.println(a.czyRoznowartosciowa());
    }
}
