package ArraysAlgorithmns;

public class Kadanes {
    public static void main(String[] args) {
        System.out.println(kadanes(new int[]{-163,-20}));
    }
    //For maximum sum subarray
    private static int kadanes(int []A)
    {
        int currSum = 0;
        int max = Integer.MIN_VALUE;

        for(int el : A)
        {
            currSum+=el;
            if(currSum>max)
            {
                max = currSum;
            }
            if(currSum<0)
                currSum=0;
        }
        return max;
    }
}
