import java.util.Iterator;

public class Shuffle implements Iterator<Integer>{
    int counter = 0;
    Iterator<Integer> i1, i2;

    public Shuffle(Iterator<Integer> i1, Iterator<Integer> i2){
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public boolean hasNext(){
        return this.i2.hasNext() || this.i1.hasNext();
    }

    @Override
    public Integer next(){
        ++counter;
        if( (counter%2!=0 || !i2.hasNext()) && i1.hasNext()){
            return i1.next();
        }
        else if( (counter%2==0 || !i1.hasNext()) && i2.hasNext()){
            return i2.next();
        }
        return -1;
    }

    public static void main(String[] args){
        Integer[] a = {2, 4, 6, 8, 10};
        Integer[] b = {1, 3, 5, 7, 9};
        Iterator<Integer> iterA = new ArrayIterator<>(a);
        Iterator<Integer> iterB = new ArrayIterator<>(b);

        Shuffle sh = new Shuffle(iterB, iterA);
        while(sh.hasNext()){
            System.out.printf("%d ", sh.next());
        }
        
    }
}
