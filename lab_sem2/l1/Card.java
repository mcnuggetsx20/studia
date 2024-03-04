public class Card{
    int value=0, 
        color=0;

    public Card(int val, int col){
        value = val;
        color = col;
    }

    public int getValue(){return value;}
    public int getColor(){return color;}

    public boolean equals(Card card){return value == card.getValue() && color == card.getColor();}
}
