package Subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateSubsets {
    public static void main(String[] args) {
//        generateSubsets(new int[]{5,1,6});
        List<List<Integer>> ans = uniqueSubsets(new int[]{1,2,3});

    }
    private static void generateSubsets(int []A)
    {
        int limit = (int)Math.pow(2,A.length);
        int sum  = 0;
        for(int i=0;i<limit;i++)
        {
            int temp = i;
            int num = 0;

            for(int j=A.length-1;j>=0;j--)
            {
                int r = temp%2;
                temp = temp/2;

                if(r==0)
                   num = num^0;
                else
                    num = A[j] ^ num;
            }
            sum+=num;
        }
        System.out.println(sum);
    }
    public static List<List<Integer>> uniqueSubsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();

        Set<List<Integer>> set = new HashSet();

        int n = nums.length;

        int limit = (int)Math.pow(2,n);

        for(int i=0;i<limit;i++)
        {
            int temp = i;
            List<Integer> l = new ArrayList<>();

            for(int j=n-1;j>=0;j--)
            {
                  int r = temp%2;
                  temp = temp/2;

                  if(r==1) l.add(nums[j]);
            }
            if(!set.contains(l)) list.add(l);
        }

        for(List<Integer> l : list) System.out.println(l);

        return list;

    }
}
