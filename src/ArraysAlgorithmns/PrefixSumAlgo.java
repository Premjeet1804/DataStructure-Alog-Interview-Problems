package ArraysAlgorithmns;

import java.util.Arrays;

public class PrefixSumAlgo {
    public static void main(String[] args) {
        PrefixSum(new int[]{1,2,3,4,5,6,7,8});

    }
    private static void PrefixSum(int []A)
    {
        int sum=0;
        for(int i=0;i<A.length;i++)
        {
            sum+=A[i];
            A[i] = sum;
        }
        System.out.println(Arrays.toString(A));
    }
}
