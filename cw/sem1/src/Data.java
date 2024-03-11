public class Data{
    private int day, month, year;
    public Data(int _day, int _month, int _year){
        day = _day;
        month = _month;
        year = _year;
    }
    public void setDay(int _day){day=_day;}
    public void setMonth(int _month){month=_month;}
    public void setYear(int _year){year=_year;}

    public int getDay(){return day;}
    public int getMonth(){return month;}
    public int getYear(){return year;}

    public boolean czyRokPrzestepny(){
        return year%4==0 && year%100!=0 || year%400==0;
    }
    public void setDate(int _day, int _month, int _year){
        day = _day;
        month = _month;
        year = _year;

    }
    public String toString(){return String.format("%d.%d.%d", day, month, year);}

    public int ileDniMiesiac(){
        if(czyRokPrzestepny() && month == 2){return 29;}
        if(month==2){return 28;}
        return (month%2!=0 || month==8)? 31:30;
    }

    public boolean czyDataPoprawna(){
        if(!czyRokPrzestepny() && month==2 && day==29){return false;}
        return day<=ileDniMiesiac() || month<=12 || year>=0;
    }
    public int compareDate(Data comp){
        int score1 = day + month*100 + year*10000;
        int score2 = comp.getDay() + comp.getMonth()*100 + comp.getYear()*10000;
        return score1==score2 ? 0: (score1-score2)/Math.abs(score1-score2);
    }
}
