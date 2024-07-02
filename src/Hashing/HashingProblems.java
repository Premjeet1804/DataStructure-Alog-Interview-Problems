package Hashing;

import java.sql.Array;
import java.util.*;

public class HashingProblems {
    public static void main(String[] args) {
//        System.out.println(firstRepeatingNumber(new int[]{10, 5, 3, 4, 3, 5, 6}));
//        System.out.println(Arrays.toString(twoSum(new int[]{3,3},6)));

//        System.out.println(commonElemets(new int[]{1, 2, 2, 1},new int[]{2, 3, 1, 2}));
//        System.out.println(Largest_Continuous_Sequence_Zero_Sum(new int[]{-8,8,-1,-16,-28,-27,15,-14,14,-27,-5,-6,-25,-11,28,29,-3,-25,17,-25,4,-20,2,1,-17,-10,-25}));
//        System.out.println(Sub_array_with_0_sum(new int[]{ 4,-1,1 }));
//        System.out.println(special_element_minimum_distance(new int[]{7, 1, 3, 4, 1, 7}));
//        System.out.println(K_Occurrences(6,2,new int[]{1000000000,1000000000,999999999,999999999,999999998,1}));

//        System.out.println(isPalindromeII("abbaeect"));
//        System.out.println(isColorful(23));
//        System.out.println(Diffk_II(new int[]{0},0));
//        System.out.println(Arrays.toString(Distinct_Numbers_in_Window(new int[]{1, 2, 1, 3, 4, 3},3)));
//        System.out.println(Arrays.toString(twoSumII(new int[]{4,7,-4,2,2,2,3,-5,-3,9,-4,9,-7,7,
//                -1,9,9,4,1,-4,-2,3,-3,-5,4,-7,7,9,-4,4,-8},-3)));
//        System.out.println(Arrays.toString(subArray_with_given_sum(new int[]{5,10,20,100,105},110)));
//        System.out.println(Pairs_With_Given_Xor(new int[]{3, 6, 8, 10, 15, 50},5));
        System.out.println(isDictionary(new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));

    }
    public static int[] twoSum(int []A,int k)
    {
        int []ans = new int[2];
        int n = A.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : A)
        {
            map.put(el,map.getOrDefault(el,0)+1);
        }
        for(int i=0;i<n;i++)
        {
            int x = k - A[i];
            if(map.containsKey(x))
            {
                int count = map.get(A[i]);
                if(A[i]==x) {
                    if (count > 1) {
                        ans[0] = i;
                        break;
                    }
                    else continue;
                }
                else {
                    ans[0]=i;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(A[ans[0]] + A[i] == k) {ans[1] = i; break;}
        }
        return ans;

    }
    public static int[] twoSumII(int []A,int k)
    {
        int []ans = new int[2];
        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<n;i++)
      {
          int x = k - A[i];
         if(map.containsKey(x))
         {
             ans[0] = map.get(x)+1;
             ans[1] = i+1;
             return ans;
         }
         else
         {
             if(!map.containsKey(A[i])) map.put(A[i],i);
         }
      }

      return ans;


    }

    public static boolean isDictionary(String []words,String order)
    {
        int []arr = new int[26];
        int seq = 0;
        for(char c : order.toCharArray())
            arr[c-'a'] = seq++;

        int n = words.length;
        for(int i=0;i<n-1;i++)
        {
            String curr = words[i];
            String next = words[i+1];
            int len = Math.min(curr.length(),next.length());

            for(int j=0;j<len;j++)
            {
                if(arr[curr.charAt(j)-'a'] > arr[next.charAt(j)-'a']) return false;

                if(arr[curr.charAt(j)-'a'] < arr[next.charAt(j)-'a']) break;

            }

        }
        return true;

    }
    public static int  Pairs_With_Given_Xor(int []A,int B)
    {
        int n = A.length;
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<n;i++)
        {
            int x = B^A[i];
            if(map.containsKey(x))
            {
                count++;

            }
            else {
                map.put(A[i],i);
            }
        }
        return count;
    }
    public static int[] subArray_with_given_sum(int []A,int B)
    {
        int n = A.length,s=-1,e=-1;
        Map<Integer,Integer> map = new HashMap<>();
        boolean flag = false;
        int []prefix = new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=A[i];
            prefix[i] = sum;
        }
        map.put(0,-1);
        for(int i=0;i<n;i++)
        {
            int x =prefix[i]-B;
            if(map.containsKey(x))
            {
                s = map.get(x)+1;
                e=i;
                flag = true;
                break;
            }
            else map.put(prefix[i],i);
        }
        if(!flag) return new int[0];
        int []ans = new int[e-s+1];
        int k=0;
        for(int i=s;i<=e;i++)
        {
           ans[k++] = A[i];
        }
        return ans;
    }
    public static List<Integer> commonElemets(int []A, int []B)
    {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : A)
            map.put(el,map.getOrDefault(el,0)+1);
        for(int el : B)
        {
            if(map.containsKey(el))
            {
                ans.add(el);
                map.put(el,map.get(el)-1);
                if(map.get(el)==0)
                    map.remove(el);
            }
        }
        return ans;
    }
    public static int firstRepeatingNumber(int []A)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : A)
            map.put(el,map.getOrDefault(el,0)+1);

       for(int el : A)
           if(map.get(el)>1) return el;

        return -1;

    }
    public static List<Integer> Largest_Continuous_Sequence_Zero_Sum(int []A)
    {

       int n = A.length;
       int sum = 0;
       int len = 0;
       int l=-1,r=-1;

       int []prefix = new int[n];
       for(int i=0;i<n;i++)
       {
           sum+=A[i];
           prefix[i] = sum;
       }
       HashMap<Integer,Integer> map = new HashMap<>();
       map.put(0,-1);
       for(int i=0;i<n;i++)
        {
            if(!(map.containsKey(prefix[i])))
            {
                map.put(prefix[i],i);
            }
            else {
                if(i- map.get(prefix[i]) > len)
                {
                    l = map.get(prefix[i]) + 1;
                    r=i;
                    len = r-l+1;
                }
            }
        }
       List<Integer> list = new ArrayList<>();
       if(l>=0 && r>=0) {
           for (int i = l; i <= r; i++)
               list.add(A[i]);
       }

       return list;
    }
    public static int Sub_array_with_0_sum(int []A)
    {
        int n = A.length;
        long []prefix = new long[n];
        long sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=A[i];
            prefix[i] = sum;
        }
        Set<Long> set = new HashSet<>();
        set.add((long)0);
        for(int i=0;i<n;i++)
        {
            if(set.contains(prefix[i]))
                return 1;
            else set.add(prefix[i]);
        }


        return 0;
    }
    public static int special_element_minimum_distance(int []A)
    {
        int ans = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++)
        {
            if(!map.containsKey(A[i]))
            {
                map.put(A[i],i);
            }
            else {
               int j = map.get(A[i]);
               if(i-j<ans)
               {
                   ans = i-j;
                   continue;
               }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static int K_Occurrences(int N,int B,int []A)
    {
        int ans = 0;
        boolean flag = false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++)
        {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        for(int el : map.keySet()){

            if(map.get(el)==B){
                ans+=el;
                ans%=1000000007;
                flag = true;
            }
        }
        System.out.println(Integer.MAX_VALUE);
        return flag==false?-1:ans;
    }
    public static int isPalindromeII(String A)
    {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:A.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        int odd = 0;
        for(char c : map.keySet())
        {
            int val = map.get(c);
            if(val%2==1) odd++;
        }
     if(odd==1) return 1;
     else if(odd>1) return 0;
     else return 1;
    }
    public static int isColorful(int num)
    {
        String s = num+"";
        char []A = s.toCharArray();
        int n=A.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            int prod = 1;
            for(int j=i;j<n;j++) {
                prod *= A[j]-'0';
                if (!set.contains(prod))
                    set.add(prod);
                else return 0;
            }
        }
        return 1;
    }
    //A[i]-A[j]=k;
    //A[i]-k = A[j]
    public static int Diffk_II(int []A,int k)
    {
        int n = A.length;
        Map<Integer,Integer> map =  new HashMap();
        for(int el : A)
            map.put(el,map.getOrDefault(el,0)+1);

        for(int i=0;i<n;i++)
        {
            int x = A[i]-k;
            if(map.containsKey(x))
            {
                int count = map.get(x);
                if(A[i]==x)
                {
                    if(count>1) return 1;
                    else continue;
                }
                return 1;
            }
            else continue;

        }
        return 0;

    }
    public static int[] Distinct_Numbers_in_Window(int []A,int k)
    {
        int n = A.length;
        int ans[] = new int[n-k+1];
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<k;i++)
        {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        ans[0]= map.size();
        int idx=1;
        for(int i=k;i<n;i++)
        {
            int j=i-k;
            map.put(A[j],map.get(A[j])-1);
            if(map.get(A[j])==0) map.remove(A[j]);

            map.put(A[i],map.getOrDefault(A[i],0)+1);
            ans[idx++] = map.size();
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

}
