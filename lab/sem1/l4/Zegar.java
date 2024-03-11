public class Zegar{
    private int h = 12, m = 30 , s=0;
    static int ile;

    public Zegar(){++ile;}
    public Zegar(int _h){h = _h; ++ile;}
    public Zegar(int _h, int _m){h = _h; m = _m; ++ile;}
    public Zegar(int _h, int _m, int _s){h = _h; m = _m; s = _s; ++ile;}

    public void setHour(int n){h = n;}
    public void setMinute(int n){m = n;}
    public void setSecond(int n){s = n;}

    public int getHour(){return h;}
    public int getMinute(){return m;}
    public int getSecond(){return s;}
    public int getIle(){return ile;}

    public void plusGodz(){h += 1; parse();}
    public void plusSek(int n){s += n; parse();}
    public void minusGodz(){h-=1; parse();}

    private void parse(){
        if(h<0){h=23; return;}
        m += (s>=60 ? 1: 0);
        s%=60;
        h += (m>=60 ? 1: 0);
        m%=60;
        h %= 24;

    }

    public String toString(){
        String H, M, S;
        H = (h>=10 ? "": "0") + h + ":";
        M = (m>=10 ? "": "0") + m + ":";
        S = (s>=10 ? "": "0") + s;
        return H+M+S;
    }

    public int compare(int H, int M, int S){
        int score1 = s + m*60 + h*3600;
        int score2 = H*3600 + M*60 + S;
        return score1==score2 ? 0: (score1-score2)/Math.abs(score1-score2);
    }

    public boolean equals(int H, int M, int S){
        return h==H && m==M && s==S;
    }

    public void wyswietl(){System.out.println(toString());}

    public static void main(String args[]){
        Zegar clock = new Zegar();
        clock.wyswietl();
        System.out.println(clock.equals(15,0,0));
        clock.plusGodz();
        clock.wyswietl();

        Zegar clock1 = new Zegar(0, 30, 15);
        clock1.minusGodz();
        clock1.wyswietl();

        Zegar clock2 = new Zegar(13, 14, 59);
        clock2.plusSek(1);
        clock2.wyswietl();

        Zegar clock3 = new Zegar(19, 59, 50);
        clock3.plusSek(16);
        clock3.wyswietl();

        Zegar clock4 = new Zegar(19, 18, 42);
        System.out.println(clock4.compare(19, 18, 42));
        System.out.println(clock4.getIle());

        return;
    }


}
