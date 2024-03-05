import java.util.Random;
import java.util.ArrayList;

public class Deck{
    ArrayList <ArrayList<Card>>arr = new ArrayList<>();
    //int size;

    public Deck(){
        //size = 0;
        //ustawiamy 52 puste miejsca w tablicy
        for(int i = 0; i < 52; ++i){arr.add(new ArrayList<>());}
            //System.out.printf("%s %d", arr.get(i).toString(), i);

        Random rand = new Random();

        //tu zaczynamy losowanie kart do talii
        int curr_val = rand.nextInt(13 +1),
            curr_col = rand.nextInt(3 +1),
            index;

        while(curr_val != 0){
            //newCard = new Card(curr_val, curr_col);

            //obliczamy index na ktory wstawimy nowa karte; w ten sposob beda one od razu posortowane
            index = (curr_val -1)*4 + curr_col;
            //arr.set(index, new Card(curr_val, curr_col));
            arr.get(index).add(new Card(curr_val, curr_col));
            //++size;

            //generujemy parametry dla nastepnej karty
            curr_val = rand.nextInt(13 +1); 
            curr_col = rand.nextInt(3 +1);
        }
    }

    public void addCard(int val, int col){
        int index = (val -1)*4 + col;
        arr.get(index).add(new Card(val, col));
    }

    public void showCards(){
        for(ArrayList<Card> cardBox : arr){
            for(Card card : cardBox){
                System.out.printf("%s", card.toString());
            }
        }
    }

    public void cardsBy(String s){
        for(ArrayList<Card> cardBox : arr){
            for(Card card : cardBox){
                if( card.valueIs(s) || card.colorIs(s) ){
                    System.out.printf("%s", card.toString());
                }
            }
        }
    }

    public int removeDuplicates(){
        int counter = 0;
        for(int i = 0; i < arr.size(); ++i){
            if(arr.get(i).size() > 1){
                counter += arr.get(i).size() - 1;
                arr.get(i).subList(1, arr.get(i).size()).clear();
            }
        }
        //size -= counter;
        return counter;
    }

    public int getSize(){
        int ans = 0;
        for(ArrayList cardBox: arr){
            ans += cardBox.size();
        }
        return ans;
    }
}
