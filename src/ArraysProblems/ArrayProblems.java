package ArraysProblems;
import java.util.*;
import Utils.Helpers;

public class ArrayProblems {
    public static void main(String[] args) {
//        System.out.println(goodPair(new int[]{1,1,2,3,2,4},4));
//        System.out.println(minValue(new int[]{2,4,1,3,2}));
//        System.out.println( Arrays.toString(rotateArray(new int[]{1,2,3,4},2)));
//        System.out.println(isLeader(new int[]{1,25,3,5,4}));
//        System.out.println(maximuSum(new int[]{-2,3,1,14,-3,56,2,-1}));
//        List<int []> ans = rotateBtime(new int[]{1,2,3,4,5},new int[]{2,3});
//        for(int [] a:ans)
//        {
//            for(int i=0;i<a.length;i++) System.out.print(a[i]+" ,");
//            System.out.println();
//        }
//        System.out.println(solve(new ArrayList(Arrays.asList(1,1,3,3))));
        System.out.println(leastAverageSubarray(new int[]{15,7,11,7,9,8,18,1,16,18, 6,1,1,4,18},6));

    }
//    Given an array A and an integer B.
//    A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B).
//    Check if any good pair exist or not.
    private static boolean goodPair(int []A,int k)
    {
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                if(A[i]+A[j]==k && i!=j)
                    return true;
            }
        }
        return false;
    }

//    Given an integer array A of size N. In one second, you can increase the value of one element by 1.
    private static int minValue(int []A)
    {
       int max = Helpers.Max(A);
       int sum = 0;
       for(int el:A) sum+=max-el;
       return sum;
    }

//    Given an integer array A of size N and an integer B,
//    you have to print the same array after rotating it B times towards the right.
    private static int[] rotateArray(int []A,int k)
    {

       Helpers.Reverse(A,0,A.length-1);
       Helpers.Reverse(A,0,k-1);
       Helpers.Reverse(A,k,A.length-1);
       return A;
    }

//    Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader
//    if it is strictly greater than all the elements to its right side.
    private static List<Integer> isLeader(int A[])
    {
        int max = Integer.MIN_VALUE;
        List<Integer>  list = new ArrayList<>();
        for(int i=A.length-1;i>=0;i--)
       {
           if(A[i]>max)
           {
               max = A[i];
               list.add(A[i]);
           }
       }
        return list;
    }
//Maximum sum subarray 'Kadane's Algorithmn
    private static  int maximuSum(int []A)
    {
        int sum=0;
        int maxSum = Integer.MIN_VALUE;
        for(int el : A)
        {
            sum+=el;
            if(sum>maxSum)
            {
                maxSum = sum;
            }
            if(sum<0) sum=0;
        }

        return maxSum;
    }

    //Problem Description
    //Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
    //
    //Find the rotated array for each value and return the result in the from of a matrix
    // where ith row represents the rotated array for the ith value in B.
    private static List<int[]> rotateBtime(int []A,int []B)
    {
        List<int[]> list = new ArrayList();
        for(int el : B)
        {
            int []temp = Arrays.copyOf(A,A.length);
            Helpers.Reverse(temp,0,temp.length-1);

            Helpers.Reverse(temp,0,temp.length-1 - el);
            Helpers.Reverse(temp,temp.length-el,temp.length-1);
            list.add(temp);

        }
        return list;


    }
    public static int solve(ArrayList<Integer> A) {

        for(int i=0;i<A.size();i++)
        {
            int n = greater(A,A.get(i));
            System.out.print(n+"?");
            if(A.get(i) == n)
                return i;
        }
        return -1;

    }
    private static int greater(ArrayList<Integer> A,int el)
    {
        int count=0;
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i)>el) count++;
        }
        return count;
    }
//    Given an array A of size N, find the subarray of size B with the least average.

    private static int leastAverageSubarray(int []A,int b)
    {
        int N = A.length;
        double avg = 0.0;
        double sum = 0.0;
        int index=0;

        for(int i=0;i<b;i++)
        {
            sum+=A[i];
        }
        avg = sum/b;
        for(int i=1;i<N-b;i++)
        {
            sum += A[i-1]+A[b+i-1];
            System.out.println(sum +" | " + sum/b);
            if(sum/b>avg)
            {
                avg = sum/b;
                index=i;
            }
        }
        return index;
    }

}
