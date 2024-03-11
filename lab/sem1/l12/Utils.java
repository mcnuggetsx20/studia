public class Utils{
    public String sliceText(String n, int max){
        if(n==null){n="...";}
        String res = n.substring(0, Math.min(n.length(), max));
        if(n.length() > max){res += "...";}
        return res;
    }
}
