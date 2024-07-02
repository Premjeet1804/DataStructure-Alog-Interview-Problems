package Strings;

import java.sql.SQLOutput;
import java.util.Arrays;

public class StringProblems {
    public static void main(String[] args) {
//        reverseString("sky is blue");
//        System.out.println(solve(new char[]{'S','c','a','l','e','r','A','c','a','d','e','m','y','2','0','2','0'}));
//        System.out.println(longestPalindromicSubstring("aaabbaaa"));
//        System.out.println(changeCharacter("umeaylnlfd",1));
//        System.out.println(stringOperations("aeiOUz"));
        String ans = longestCommonPrefix(new String[]{"abcd","abcd","aefgh"});

        System.out.println(ans);
    }


    private static String longestCommonPrefix(String []A) {

        String s = A[0];
        for(String st : A)
            if(st.length()<s.length())
                s=st;
        StringBuilder str = new StringBuilder();
        boolean flag = false;
        for(char c : s.toCharArray())
        {
            str.append(String.valueOf(c));
            if(!isPrefixSum(A,str.toString(),s.length()))
            {
                flag  = true;
                break;
            }
        }

        if(flag) return str.toString().substring(0,str.length()-1);

        return str.toString();


    }
    public static boolean isPrefixSum(String []A,String str,int len)
    {
        for(String s : A)
        {
            if(s.length() >= len && s.substring(0,str.length()).equals(str) )
            {

            }
            else return false;

        }
        return true;

    }

    public static String stringOperations(String str)
     {
         //concatenation
         String s = str + str;
         System.out.println(s);
         StringBuilder mod = new StringBuilder();
         for(char c : s.toCharArray())
         {
              if(!isUpper(c))
              {
                 mod.append(String.valueOf(c));
              }
         }
         StringBuilder ans = new StringBuilder();
         for(char c : mod.toString().toCharArray())
         {
             if(isVowel(c))
             {
                 ans.append(String.valueOf('#'));
             }
             else ans.append(String.valueOf(c));
         }
         return ans.toString();
     }
     public static boolean isVowel(char c)
     {
         if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
         else return false;
     }
     public static boolean isUpper(char c)
     {
         if(c>=65 && c<=90) return true;
         else return false;
     }
    public static int changeCharacter(String s, int B) {

        int []A = new int[26];
        int count = 0;
        for(char c : s.toCharArray())
        {
            A[c-'a']++;
        }
        Arrays.sort(A);
        int k=0;
        for(int i=0;i<A.length;i++)
        {
                while( A[i]>0 && B>0)
                {
                    A[i]--;
                    B--;
                }
        }
        for(int el:A)
            if(el>0) count++;

        return count;
    }

    public static String longestPalindromicSubstring(String s)
    {
        char A[] = s.toCharArray();
        String max1 = "";
        String max2 = "";
        int n = A.length;

            for(int i=0;i<n-1;i++)
            {
                  String temp = palindromeLength(A,i,i+1);
                  if(temp.length()>max1.length())
                  {
                      max1 = temp;
                  }
                  String temp2 = palindromeLength(A,i,i);
                  if(temp2.length()>max2.length())
                  {
                        max2 = temp2;
                  }

            }
        System.out.println(max1 +" | "+max2);

        return max1.length() > max2.length() ? max1 : max2;

    }
    private static String palindromeLength(char []A, int i,int j)
    {
        int n = A.length;
        while(i>=0 && j<=n-1)
        {
            if(A[i]==A[j])
            {
               i--;j++;
            }
            else break;
        }
        StringBuilder str = new StringBuilder();
        for(int k=i+1;k<j;k++)
        {
            str.append(A[k]);
        }
        return str.toString();

    }
    public static int solve(char[] A) {

        for(char c : A)
        {
            boolean letter = isLetter(c);
            boolean digit = isDigit(c);
            if(!letter && !digit) {
                System.out.println(c);
                return 0;
            }

        }
        return 1;
    }
    private static boolean isLetter(char c)
    {
        if(c>=65 && c<=90 || c>=97 && c<=122) return true;
        else return false;

    }
    private static boolean isDigit(char c)
    {
        if(c>=48 && c<=57) return true;
        else return false;

    }
    private static void reverseString(String s)
    {
        char []A = s.toCharArray();
        int n = A.length;
        reverse(A,0,n-1);
        System.out.println(Arrays.toString(A));
        int r=0,l=0;
        for(int i=0;i<n;i++)
        {
            if(A[i]==' ')
            {
                r = i-1;
                reverse(A,l,r);
                l=i+1;
            }
        }
        reverse(A,l,n-1);
        StringBuilder str = new StringBuilder();
        for(char c : A) str.append(c);

            System.out.println(str.toString());


    }
    private static void reverse(char []A,int i,int j)
    {
        while(i<j)
        {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;j--;
        }
    }

}
