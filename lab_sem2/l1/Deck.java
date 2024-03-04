import java.util.Random;
import java.util.ArrayList;

public class Deck{
    ArrayList<Card>arr = new ArrayList<>();

    public Deck(){
        //ustawiamy 52 puste miejsca w tablicy
        for(int i = 0; i < 52; ++i){arr.add(-1);}

        Random rand = new Random();

        //tu zaczynamy losowanie kart do talii
        int curr_val = rand.nextInt(13 +1),
            curr_col = rand.nextInt(3 +1),
            index;

        while(curr_val != 0){
            //newCard = new Card(curr_val, curr_col);

            //obliczamy index na ktory wstawimy nowa karte; w ten sposob beda one od razu posortowane
            index = (curr_val -1)*4 + curr_col;
            arr.add(index, new Card(curr_val, curr_col));

            //generujemy parametry dla nastepnej karty
            curr_val = rand.nextInt(13 +1); 
            curr_col = rand.nextInt(3 +1);
        }
    }

    public void addCard(int val, int col){
        int index = (curr_val -1)*4 + curr_col;
        arr.add(index, new Card(val, col));
    }
}
