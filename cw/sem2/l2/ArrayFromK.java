import java.util.Iterator;
public class ArrayFromK<T> implements Iterator<T>{
    int k = 0;
    public ArrayFromK(int k){
        this.k = k;
    }

    @Override
    public boolean hasNext(){
        return true;
    }

    @Override
    public T next(){
        return ++k;
    }

    public static void main(String[] args){
        ArrayFromK<Integer> iter = new ArrayFromK<>(5);
        while(iter.next != 100){
            System.out.println(iter.next());
        }
        return;
    }
}
