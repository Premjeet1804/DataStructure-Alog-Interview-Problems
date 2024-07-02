package ArraysAlgorithmns;

import java.util.Arrays;

public class Left_Right_Max {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftMax(new int[]{3, 2, 4, 1, 2, -1, 3, 0, 1})));
        System.out.println(Arrays.toString(rightMax(new int[]{3, 2, 4, 1, 2, -1, 3, 0, 1})));

    }
    private static int [] leftMax(int []A)
    {
        int []leftMax = new int[A.length];
        leftMax[0] = A[0];
        for(int i=1;i<A.length;i++)
        {
              leftMax[i] = Math.max(A[i],leftMax[i-1]);
        }
        return leftMax;
    }
    private static int [] rightMax(int []A)
    {
        int []rightMax = new int[A.length];
        rightMax[A.length-1] = A[A.length-1];

        for(int i=A.length-2;i>=0;i--)
        {
            rightMax[i] = Math.max(A[i],rightMax[i+1]);
        }
        return rightMax;
    }
}
