package ArraysAlgorithmns;

public class ContributionTechnique {
    public static void main(String[] args) {
        System.out.println(contributionTechnique(new int[]{3,2,1,6,-1,4}));
    }
    private static long contributionTechnique(int []A)
    {
        long left=0,right=0,N=A.length,sum=0;

        for(int i=0;i<N;i++)
        {
            left = i+1;
            right = N-i;
            sum += A[i] *left * right;
        }
        return sum;
    }
}
