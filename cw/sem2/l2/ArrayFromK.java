import java.util.Iterator;
public class ArrayFromK implements Iterator<Integer>{
    int k;
    public ArrayFromK(int k){
        this.k = k;
    }

    @Override
    public boolean hasNext(){
        return true;
    }

    @Override
    public Integer next(){
        ++k;
        //System.out.printf("teraz k wynosi: %d\n", k-1);
        return k-1;
    }

    public static void main(String[] args){
        ArrayFromK iter = new ArrayFromK(5);
        int temp = iter.next();
        while(temp < 50){
            System.out.println(temp);
            temp = iter.next();
        }
        return;
    }
}
