package ArraysProblems;

import java.util.Arrays;



public class PrefixSumProblems {
    public static void main(String[] args) {

//        System.out.println(Arrays.toString(continuousSumQuery(10,new int[][]{{1,3,10},{6,9,2},{3,5,3},{2,8,4},{6,7,5}})));

//        System.out.println(closetMinMax(new int[]{48,774,281,796,786,411}));
//        System.out.println(equilibriumIndex(new int[]{1,2,3,-3}));
//        int [][]ans = xorQueries(new int []{1,0,0,0,1}, new int[][]{{1,3},{0,4},{2,4}});
//        for(int []item : ans)
//        {
//            System.out.println(Arrays.toString(item));
//        }
//        System.out.println(adjacentDiff(new int[]{5,17,100,11}));
//        System.out.println(specialIndex(new int[]{2,1,6,4}));
//        System.out.println(LongestCensecutive_Ones("11101110"));
    }

//    There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
//    When the devotees come to the temple, they donate some amount of coins to these beggars.
//    Each devotee gives a fixed amount of
//    coin(according to their faith and ability) to some K beggars sitting next to each other.
//    Given the amount P donated by each devotee to the beggars ranging from L to R index,
//    where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day,
//    provided they don't fill their pots by any other means.
//    For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
//
//
//    Problem Constraints
//      1 <= A <= 2 * 105
//      1 <= L <= R <= A
//      1 <= P <= 103
//      0 <= len(B) <= 105
//
//
//    Input Format
//    The first argument is a single integer A.
//    The second argument is a 2D integer array B.
//
//
//            Output Format
//    Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
//
//
//    Example Input
//    Input 1:-
//    A = 5
//    B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
    public static int[] continuousSumQuery(int A, int[][] B) {

        int []ans = new int[A];

        for(int []item : B)
        {
            int s = item[0]-1;
            int e = item[1]-1;
            int amt = item[2];

           ans[s] +=amt;
            if(e+1 <= A)
                ans[e+1] -= amt;
        }
        int sum=0;
        for(int i=0;i<A;i++)
        {
            sum+=ans[i];
            ans[i] = sum;
        }
     return ans;
    }
    private static int closetMinMax(int []A)
    {
        int N = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<A.length;i++)
        {
            min = Math.min(min,A[i]);
            max = Math.max(max,A[i]);
        }
        int minPtr = -1;
        int maxPtr = -1;
        int size = Integer.MAX_VALUE;
        for(int i=0;i<N;i++)
        {
            if(A[i]==min) minPtr = i;
            if(A[i]==max) maxPtr = i;

            if(minPtr!=-1 && maxPtr!=-1)
                size = Math.min(size,Math.abs(maxPtr-minPtr)+1);
        }
        return size;

    }

    private static int equilibriumIndex(int []A)
    {
        int index = -1;
        int N = A.length;

        //prefixSum
        int sum=0;
        for(int i=0;i<N;i++)
        {
            sum+=A[i];
            A[i] = sum;
        }
        int left = 0;
        int right = 0;
        for(int i=0;i<N;i++)
        {
            if(i==0) left = 0;
            else
                left = A[i-1];

            right = A[N-1] - A[i];

            if(left == right) return i;
        }




        return index;

    }

//    You are given an array A (containing only 0 and 1) as element of N length.
//    Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive)
//    and number of unset bits (0's) in the given range of the array.
    private static int[][] xorQueries(int []A,int [][]Q)
    {
        int [][]ans = new int[Q.length][2];
        int []prefixXor = new int[A.length];
        int []prefixZero = new int[A.length];
        int i=0,zeros=0;
        //prefixZeroCount
        for(int el : A)
        {
            if(el==0) zeros++;
            prefixZero[i++] = zeros;
        }
        System.out.println(Arrays.toString(prefixZero));

        //prefixXor
        int xor = 0;
        i = 0;
        for(int el : A)
        {
                 xor^=el;
                 prefixXor[i++] =xor;
        }
        System.out.println(Arrays.toString(prefixXor));

         i=0;
        for(int []query : Q)
        {
            int s = query[0];
            int e = query[1];
            if(s>0)
            ans[i][0] = prefixXor[e] ^ prefixXor[s-1];
            else ans[i][0] = prefixXor[e];

            if(s>0)
                ans[i][1] = prefixZero[e] - prefixZero[s-1];
            else ans[i][1] = prefixZero[e];

            i++;
        }

        return ans;
    }
    private static int adjacentDiff(int []A)
    {
        Arrays.sort(A);
        int j=0,diff = Integer.MAX_VALUE;
        for(int i=0;i<A.length-1;i++)
        {
            j=i+1;

            diff = Math.min(diff,A[j]-A[i]);
        }
        return diff;
    }

    private static int specialIndex(int []A)
    {
      int ans=0,N=A.length,sum=0;
      int []prefixEven = new int[N];
      int []prefixOdd = new int[N];

      //prefixEven
       for(int i=0;i<N;i++)
       {
           if(i%2==0)
           {
               sum+=A[i];
               prefixEven[i] = sum;
           }
           else
               prefixEven[i] = sum;
       }
        System.out.println(Arrays.toString(prefixEven));
       //prefixOdd
        sum=0;
        for(int i=0;i<N;i++)
        {
            if(i%2==1)
            {
                sum+=A[i];
                prefixOdd[i] = sum;
            }
            else
                prefixOdd[i] = sum;
        }
        System.out.println(Arrays.toString(prefixOdd));

        int Evensum = prefixOdd[N-1];
        int Oddsum = prefixEven[N-1]-A[0];
        if(Evensum==Oddsum){
            ans++;
        }

        for(int i=1;i<N;i++)
        {


//            int sumOdd =0, sumEven=0;
//            sumOdd =prefixOdd[i-1] + prefixEven[N-1]-prefixEven[i];
//            sumEven = prefixEven[i-1]+ prefixOdd[N-1]-prefixOdd[i];

            int sumOdd = 0,sumEven = 0;
            sumOdd = prefixOdd[i-1]+prefixEven[N-1] - prefixEven[i];
            sumEven = prefixEven[i-1] + prefixOdd[N-1] - prefixOdd[i];

            if(sumOdd == sumEven) ans++;

        }


      return ans;
    }

    //find length of longest consecutive ones and u can atmost swap one element to 0 to 1 if 0 present in the string
    private static int LongestCensecutive_Ones(String s)
    {
        int N = s.length();
        int one_cnt=0;
        for(int i=0;i<N;i++) if(s.charAt(i)=='1') one_cnt++;
        int []left = new int[N];
        int []right = new int[N];

        if(s.charAt(0)=='1')
            left[0] = 1;
        else
            left[0] = 0;
        int count=0;
        for(int i=1;i<N;i++)
        {
            if(s.charAt(i)=='1')
            {
                left[i] = left[i-1]+1;
            }
            else {
                left[i]  =0;
            }
        }
        if(s.charAt(N-1)=='1')
            right[N-1] = 1;
        else
            right[N-1] = 0;
        for(int i=N-1;i>=0;i--)
        {
            if(s.charAt(i) == '1')
                right[i] = right[i+1]+1;
            else
                right[i] = 0;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString((right)));
        int max_cnt = 0,cnt=0;
        for(int i=0;i<N;i++)
        {
             max_cnt = Math.max(max_cnt,Math.max(left[i],right[i]));
        }

        for(int i=1;i<N-1;i++)
        {
            if(s.charAt(i) == '0')
            {
                int sum = left[i-1]+right[i+1];
                if(sum<one_cnt)
                {
                    cnt = sum=1;
                }
                else cnt=sum;
                max_cnt = Math.max(max_cnt,cnt);
                cnt=0;
            }
        }
        return max_cnt;
    }
}

