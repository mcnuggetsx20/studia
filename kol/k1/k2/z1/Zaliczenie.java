public class Zaliczenie{
    public double ocena;
    public String kurs;

    public Zaliczenie(String k, double o){
        ocena =o;
        kurs = k;
    }

    public double getOcena(){return ocena;}
    public String getKurs(){return kurs;}

    public void setOcena(double o){ocena = o;}
    public void setKurs(String o){kurs = o;}

    public void display(){
        System.out.printf("%10s %4.1f%n", kurs, ocena);
    }
}
