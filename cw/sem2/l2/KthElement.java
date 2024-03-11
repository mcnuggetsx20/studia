import java.util.Iterator;
public class KthElement<T> implements Iterator<T> {
    public Iterator<T> base;
    public int k, pos;

    public KthElement(Iterator<T> iter, int k){
        base = iter;
        this.k = k;
    }

    @Override
    public boolean hasNext(){
        return base.hasNext();
    }

    @Override
    public T next(){
        T res = base.next();
        for(int i = 0; i < k-1; ++i){
            if(!base.hasNext()){break;}
            base.next();
        }
        return res;
    }

    public static void main(String[] args){
        Integer[] arr = {1, 5, 2, 15, 6, 11, 10};
        Iterator<Integer> iter = new ArrayIterator<>(arr);
        for(KthElement<Integer> kth = new KthElement<>(iter, 3); kth.hasNext();){
            System.out.printf("%d ", kth.next());
        } 
        System.out.println();
    }
}
