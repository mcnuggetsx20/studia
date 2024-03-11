//SecondSmallest
public class Z2{

    static int getSecondSmallest(int[] arr) throws NoAnswerException{
        int m1 = (int)1e9, m2 = (int)1e9;
        for(int i : arr){
            if( i < m1 ){ 
                m2 = m1;
                m1 = i;
            }
            else if( i > m1 && i < m2){
                m2 = i;
            }
        }
        if(m2 == (int)1e9){
            throw new NoAnswerException("druga najmniejsza liczba nie istnieje");
        }
        return m2;
    }

    public static void main(String[] args) throws NoAnswerException{
        int[] tab = {2, 3, 7 , 2};
        System.out.println(getSecondSmallest(tab));
        return;
    }
}

class NoAnswerException extends Exception{
    public NoAnswerException(String mess){
        super(mess);
    }
}
