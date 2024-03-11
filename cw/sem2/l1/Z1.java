//NextPascalLine
public class Z1{

    public static int[] nextPascalLine(int[] prev){
        int[] ans = new int[prev.length+1];
        ans[0] =1; ans[ans.length-1] = 1;

        for(int i = 0; i < prev.length-1; ++i){
            ans[i+1] = prev[i] + prev[i+1];
        }
        return ans;
    }

    public static void main(String[] args){
        int[] tab = {1, 1};
        for(int i : nextPascalLine(tab)){System.out.printf("%3d", i);}
        System.out.println();
        return;
    }
}
