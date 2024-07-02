package ArraysProblems;

import Utils.Helpers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subArrayProblems {
    public static void main(String[] args) {
//        reverseSubarray(new int[]{1,2,3,4,5,6,7,8,9},2,6);
//       List<List<Integer>> list =  printIndexes(new int []{3,4,2,-1,6,7,8,9,3,2,-1,4},6);
//       for(List<Integer> item : list)
//           System.out.println(item);
//        System.out.println(subarraySumSizeK(new int []{-3,4,-2,5,3,-2,8,2,-1,4},5));
//        System.out.println(allSubArraySum(new int []{3,-1,0,2}));
//        System.out.println(subArrayRanges(new int[]{1,2,3}));
        System.out.println(cyclic_slidingwindow(new int[]{5,-2,3,1,2},3));

    }
    //Given an array reverse a specific part fo subarray
    private static void reverseSubarray(int []A,int s,int e)
    {

        Helpers.Reverse(A,s,e);
        System.out.println(Arrays.toString(A));

    }
    //Print start and end index of aall subarray of len = k
    private static List<List<Integer>> printIndexes(int []A,int k)
    {
        List<List<Integer>> list = new ArrayList();
        int N = A.length,j;
        for(int i=0;i<=N-k;i++)
        {
            j = k-1+i;
            list.add(new ArrayList<>(Arrays.asList(i,j)));
        }
        return list;
    }
    //find the maximum subarray sum of size k
    private static int subarraySumSizeK(int []A,int k)
    {
        int sum = 0;
        int N = A.length;
        for(int i=0;i<k;i++)
            sum+=A[i];
        int max = sum;
        for(int i=1;i<=N-k;i++)
        {
            int j = i+k-1;
            sum = sum - A[i-1] + A[j];
            System.out.println(sum);
            if(sum>max)
            {
                max = sum;
            }
        }
        return max;
    }
    private static List<Integer> allSubArraySum(int []A)
    {
        List<Integer> list = new ArrayList();

        for(int i=0;i<A.length;i++)
        {
            int sum=0;
            for(int j=i;j<A.length;j++)
            {
                sum+=A[j];
                list.add(sum);
            }
        }
        return list;
    }
//    You are given an integer array nums. The range of a subarray of nums
//    is the difference between the largest and smallest element in the subarray.
//    Return the sum of all subarray ranges of nums.
//    A subarray is a contiguous non-empty sequence of elements within an array.
    public static long subArrayRanges(int[] nums) {
        long ans = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = i; j < N; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }

        }
        return ans;
    }

    public static int cyclic_slidingwindow(int []A,int b)
    {
        int sum = 0;
        for(int i=0;i<b;i++)
        {
            sum+=A[i];
        }
        int k=1,max = sum;
        for(int i=A.length-1;i>=A.length-b;i--)
        {
           sum = sum -  A[b-k++];
           sum = sum + A[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
