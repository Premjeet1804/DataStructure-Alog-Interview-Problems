package Utils;

import java.util.*;

public class IBM {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));


    }
    public static List<String> commonChars(String[] words) {

     int []freq = new int[26];

     for(char c : words[0].toCharArray())
         freq[c-'a']++;

     for(int i=1;i<words.length;i++)
     {
         int []temp = new int[26];
         for(char c : words[i].toCharArray()) temp[c-'a']++;

         for(int j=0;j<26;j++)
         {
             freq[j] = Math.min(freq[j],temp[j]);
         }

     }
     StringBuilder ans = new StringBuilder();
     for(int i=0;i<26;i++)
     {
         if(freq[i]>0)
         {
             int val = freq[i];
             for(int j=0;j<val;j++)
             {
                 ans.append(String.valueOf((char)('a'+i)));
             }
         }
     }
     List<String> list = new ArrayList<>();

     for(char c : ans.toString().toCharArray())
      list.add(c+"");

     return list;
    }






}
