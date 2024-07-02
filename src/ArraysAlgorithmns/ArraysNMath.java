package ArraysAlgorithmns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ArraysNMath {
    public static void main(String[] args) {

//        System.out.println(missingNumber(new int[]{1,2,3,4,6,7,8,9}));

//        System.out.println(power(2,5,7));
//        System.out.println(lcm(105,1));
//        System.out.println(minNumber(28,32,97));

//        System.out.println(isParallelLines(0,1,3,1,0,2,3,2));
//        System.out.println(Arrays.toString(missingAndRepeatedNumber(new int[]{3,1,2,5,3})));
//        System.out.println(majorityElement(new int[]{4,6,5,3,5,6,4,4,4}));
        System.out.println(majorityElement2(new int[]{0,0,0}));
    }

    //Majority element
    private static int majorityElement(int []A)
    {
        int me = A[0];
        int count =0 ;
        for(int i=1;i<A.length;i++)
        {
            if(A[i]==me)
                count++;
            else if(count==0)
            {
                me =A[i];
            }
            else count--;

        }
        return me;
    }
    //Majority element || return number whose ocurence is greater than N/3 times;
    private static List<Integer> majorityElement2(int []A)
    {
        int candidate1 = 0 , candidate2 = 0 , count1 = 0 , count2 = 0;

        for(int i=0;i<A.length;i++)
        {
            if(candidate1 == A[i]) count1++;
            else if(candidate2 == A[i]) count2++;
            else if(count1==0)
            {
                count1++;
                candidate1 = A[i];
            }
            else if(count2 == 0)
            {
                count2++;
                candidate2 = A[i];
            }
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int c1 = 0, c2 = 0;
        for(int num : A)
        {
            if(num == candidate2) c2++;
            else if(num  == candidate1) c1++;
        }
        if(c1>A.length/3) ans.add(candidate1);
        if(c2>A.length/3) ans.add(candidate2);

        return ans;

    }
    //3 1 2 5 3
    private static int[] missingAndRepeatedNumber(int []A)
    {
        int n = A.length,i=0;

        while(i<n)
        {
            int correct=A[i]-1;
            if(A[i]!=A[correct])
            {
                int temp = A[i];
                A[i] = A[correct];
                A[correct] = temp;
            }
            else
                i++;
        }
        for(int j=0;j<n;j++)
        {
            if(A[j]!=j+1)
            {
                return new int []{A[j],j+1};
            }
        }

        return new int[]{};
    }
    //check if two lines are parallel or not
    private static boolean isParallelLines(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
    {
           int val1 = y2-y1;
           int val2 = x2-x1;

           int slope1 =val1/val2;
        System.out.println(slope1);
           int val3 = y4-y3;
           int val4 = x4-x3;


           int slope2 = val3/val4;
        System.out.println(slope2);
           return slope1==slope2;

    }
    //Missing Number
    private static int missingNumber(int []A)
    {
        int n = 0;
        for(int el : A)
            n^=el;

        for(int i=1;i<=A.length+1;i++)
        {
            n^=i;
        }
        return n;
    }
    //Calculate a^n%p
    private static int power(int a,int n,int p)
    {
        long ans = 1;
        for(int i=1;i<=n;i++)
        {
            ans = (ans * a)%p;
        }
        return (int)(ans%p);
    }

    private static int lcm(int a,int b)
    {
        int product = a*b;

        for(int i=2;i<=product;i++)
        {
            if(i%a==0 && i%b==0) return i;
        }
        return -1;

    }
    private static int minNumber(int A,int B,int C)
    {
        int ans = 0;
        if(A>=B && A>=C)
        {
            if(B>=C)
            {
                ans = ans + 10000 * C;
                ans = ans + B * 100;
                ans = ans + A;
            }
            else {
                ans = ans + 10000 * B;
                ans = ans + C * 100;
                ans = ans + A;
            }
        }
        else if(B>=A && B>=C)
        {
            if(A>=C)
            {
                ans = ans + 10000 * C;
                ans = ans + A * 100;
                ans = ans + B;
            }
            else
            {
                ans = ans + 10000 * A;
                ans = ans + C * 100;
                ans = ans + B;
            }
        }
        else {
            if(A>=B)
            {
                ans = ans + 10000 * B;
                ans = ans + A * 100;
                ans = ans + C;
            }
            else {
                ans = ans + 10000 * A;
                ans = ans + B * 100;
                ans = ans + C;
            }
        }
        return ans;
    }
}
