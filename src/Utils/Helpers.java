package Utils;

public class Helpers {
    public static int Max(int []A)
    {
        int max = Integer.MIN_VALUE;
        for(int el : A)
        {
            max = Math.max(max,el);
        }
        return max;
    }
    public static void Reverse(int []A,int i,int j)
    {
        while(i<j)
        {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;j--;
        }
    }
    public static void PrintArray(int []A)
    {
        for(int el: A)
        {
            System.out.print(el+" ");
        }
    }
}
