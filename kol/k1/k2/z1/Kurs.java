public class Kurs{
    public String przedmiot;

    public Kurs(String p){
        przedmiot = p;
    }
    
    public boolean equals(Kurs k){
        return przedmiot.equals(k.getPrzedmiot()) ? true: false;
    }
    public String getPrzedmiot(){return przedmiot;}
    public void display(){
        System.out.println(przedmiot);
    }
}
