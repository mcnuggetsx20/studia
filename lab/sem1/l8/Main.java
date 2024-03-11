package l8;
public class Main{
    @SuppressWarnings("unchecked")
    public static <T> void p(T... args){System.out.println(args[0]);}

    public static void main(String[] args){
        Robotnik a = new Robotnik("kowal", 1.5, 10);
        Urzednik b = new Urzednik("kowalski", 1.5, 10, 0.14);
        Robotnik c = new Robotnik("Nowak", 1.0, 10);
        Firma f = new Firma(100);

        f.zwolnij(a);

        f.zatrudnij(a);
        f.zatrudnij(c);
        f.zatrudnij(b);

        f.zwolnij(a);
        p("lista zatrudnionych");
        f.printList();

        p("\nsuma plac:");
        p(f.sumaPlac());

        p("\nlista z placami");
        f.printListPlaca();
    }
}

class Firma{
    Pracownik[] tab;
    int count = 0;

    public Firma(int _size){
        tab = new Pracownik[_size];
    }

    void zatrudnij(Pracownik pr){
        ++count;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i]==null){tab[i]=pr; return;}
        }
    }

    void zwolnij(Pracownik pr){
        --count;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i]==null){continue;}
            if(tab[i].equals(pr)){tab[i]=null; return;}
        }
    }

    int liczbaPracownikow(){return count;}

    int sumaPlac(){
        int ans = 0;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i] == null){continue;}
            tab[i].obliczPlace();
            ans += tab[i].getPlaca();
        }
        return ans;
    }

    void printList(){
        int c = 1;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i] == null){continue;}
            System.out.printf("%3d %-12s%8.2f%n", c, tab[i].getNazwisko(), tab[i].getEtat());
            ++c;
        }
    }
    void printListPlaca(){
        int c = 1;
        for(int i = 0; i < tab.length; ++i){
            if(tab[i] == null){continue;}
            System.out.printf("%3d %-12s%8.2f%8.2f%n", c, tab[i].getNazwisko(), tab[i].getEtat(), tab[i].getPlaca());
            ++c;
        }
    }
}

class Pracownik{
    String nazwisko;
    double etat, limit, przepracowane = 0;
    double placa = 0, stawka = 100;

    public Pracownik(String _nazwisko, double _etat, double _przep){
        nazwisko = _nazwisko;
        etat = _etat;
        przepracowane = _przep;

        limit = etat * 8;
    }

    void obliczPlace(){placa = 0;}

    public String toString(){return nazwisko;}
    public boolean equals(Pracownik pr){return pr.getNazwisko() == nazwisko;}

    public String getNazwisko(){return nazwisko;}
    public double getEtat(){return etat;}
    public double getPlaca(){return placa;}
}

class Robotnik extends Pracownik{
    Robotnik(String _nazwisko, double _etat, double _przep){
        super(_nazwisko, _etat, _przep);
    }

    void obliczPlace(){
        placa = limit*stawka;
        if(przepracowane > limit){placa += (przepracowane-limit) * stawka * 1.5;}
    }
}


class Urzednik extends Pracownik{
    double premia = 0;
    Urzednik(String _nazwisko, double _etat, double _przep){
        super(_nazwisko, _etat, _przep);
    }

    Urzednik(String _nazwisko, double _etat, double _przep, double _premia){
        super(_nazwisko, _etat, _przep);
        premia = _premia;
    }

    void obliczPlace(){
        placa = limit*stawka * (1+premia);
    }
}


