public class Z3{
    static boolean nextPermutation(int[] arr){
        boolean res = false;
        Integer target = null, bigger = null;
        for(int i = 1; i < arr.length; ++i){
            if(arr[i] > arr[i-1]){
                target = i-1;
            }
            if(target == null){continue;}
            if(arr[i] > arr[target]){
                //wiemy ze najmniejszy element ktory jest wiekszy od targeta jest na maxa w prawo
                bigger = i;
            }
        }

        System.out.printf("%d, %d\n", target, bigger);

        if(target==null){return false;}

        //swap
        int temp = arr[target];
        arr[target] = arr[bigger];
        arr[bigger] = temp;

        //odwrocenie reszty
        for(int i = target+1; i <= target + (arr.length - target-1)/2; ++i){
            temp = arr[arr.length - i + target];
            arr[arr.length-i+target] = arr[i];
            arr[i] = temp;
        }

        return true;
    }

    public static void main(String[] args){
        int[] arr = {3, 5, 1, 2, 4};
        nextPermutation(arr);
        for(int i : arr){
            System.out.printf("%d ", i);
        }
        return;
    }
}
