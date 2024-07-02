package ArraysAlgorithmns;

public class SubArrays {
    public static void main(String[] args) {
            generateAllSubarray(new int[]{1,2,3,4});
    }
    //total number of subarrays = n * (n+1)/2;

    private static void generateAllSubarray(int []A)
    {
        for(int i=0;i<A.length;i++)
        {
            for(int j=i;j<A.length;j++)
            {
                System.out.print("[");
                for(int k=i;k<=j;k++)
                {
                    System.out.print(A[k]);
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }
}
