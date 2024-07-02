package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionProblems {
    public static void main(String[] args) {
//        System.out.println(sumOfNnaturalNumber(10));
//        System.out.println(factorialOfaNumber(7));
//        System.out.println(fibonacci(6));
//        System.out.println(isPalindrome("namanl"));
//        System.out.println(sumOfDigits(12875));
//        System.out.println(power(2,4));
//        System.out.println(enhancedPower(2,5));

//        System.out.println(reverseString("premjeet"));
//        System.out.println(isMagic(1291));
        List<String> str = grayCode(4);
        List<Integer> nummber =  binarytoDecimal(str);
        System.out.println(nummber);
    }
    public static int sumOfNnaturalNumber(int n)
    {
        if(n==1) return 1;

        return n + sumOfNnaturalNumber(n-1);
    }
    public static int factorialOfaNumber(int n)
    {
        if(n==1) return 1;
        return n * factorialOfaNumber(n-1);
    }
    public static int fibonacci(int n)
    {
        if(n==0 || n==1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static boolean isPalindrome(String s)
    {
        if(s.length()==1) return true;

        return palindrome(s,0,s.length()-1);
    }

    private static boolean palindrome(String str, int s, int e) {
        if(s>=e) return true;
        if(str.charAt(s) != str.charAt(e)) return false;

        return palindrome(str,s+1,e-1);
    }
    public static int sumOfDigits(int n)
    {
        if(n==0) return 0;
        return n%10 + sumOfDigits(n/10);
    }
    public static int power(int a,int n)
    {
        if(n==0) return 1;

        return a * power(a,n-1);
    }
    public static int enhancedPower(int a,int n)
    {
        if(n==0) return 1;
        if((n&1) == 1)
        {
            int x = enhancedPower(a,(n-1)/2);
            return a * x * x;
        }
        else
        {
            int x = enhancedPower(a,n/2);
            return x*x;
        }
    }

    public static String reverseString(String s)
    {
        char []A = s.toCharArray();
        reverse(A,0,A.length-1);
        StringBuilder str = new StringBuilder();
        for(char c : A) str.append(String.valueOf(c));

        return str.toString();

    }
    private static void reverse(char []A,int s,int e)
    {
        if(s>=e) return;
        char temp = A[s];
        A[s] = A[e];
        A[e] = temp;

        reverse(A,s+1,e-1);

        return;
    }
    public static int powerWithMod(int a,int n,int m)
    {
        if(n==0) return 1;
       if((n&1)==1)
       {
           int x = powerWithMod(a,n/2,m);
           return (a * (x%m) * (x%m))%m;

       }
       else {
           int x = powerWithMod(a,n/2,m);
           return ((x%m) * (x%m))%m;
       }
    }

    public static int isMagic(int n)
    {
        while(n>0)
        {
            int x = sumOfDigits(n);
            if(x<10) {
                if(x==1) return 1;
                else return 0;
            }
            else n=x;
        }
        return 0;
    }
    public static List<String> grayCode(int n)
    {
        if(n==1)
        {
            List<String> bres = new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }
        List<String> res = grayCode(n-1);
        List<String> mres = new ArrayList<>();
        for(int i=0;i<res.size();i++)
        {
             mres.add("0"+res.get(i));
        }
        for(int i=res.size()-1;i>=0;i--)
        {
            mres.add("1"+res.get(i));
        }
        return mres;

    }
    public static List<Integer> binarytoDecimal(List<String> str)
    {
        List<Integer> ans = new ArrayList<>();
        for(String s : str)
        {
            int i = s.length()-1,num=0,p=0;
            while(i>=0)
            {
                int n = s.charAt(i) - '0';
                num+= (n*(int)Math.pow(2,p++));
                i--;
            }
            ans.add(num);
        }
        return ans;
    }




}
