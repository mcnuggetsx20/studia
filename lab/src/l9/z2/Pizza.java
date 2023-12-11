public class Pizza {
    String rodzaj = "";
    String rozmiar = "";

    public Pizza(String _kind, String _size){
        rodzaj = _kind;
        rozmiar = _size;
    }

    public String toString(){return String.format("%s %s", rodzaj, rozmiar);}

}

