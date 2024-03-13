import java.util.Iterator;

public class Fib implements Iterator<Integer>{
    int a= 1, b = 0;
    
    @Override
    public boolean hasNext(){
        return true;
    }

    @Override
    public Integer next(){
        int ans = a+b;
        a = b;
        b = ans;
        return ans;
    }

    public static void main(String[] args){
        Fib iter = new Fib();
        int temp = iter.next();
        while(temp < 50){
            System.out.println(temp);
            temp = iter.next();
        }
    }
}
