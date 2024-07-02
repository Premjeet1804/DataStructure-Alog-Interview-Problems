package Sorting;

import Utils.Helpers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class SortingProblem {
    public static void main(String[] args) {
//       sortByColors(new int[]{0,1,2,0,1,2});
//        System.out.println(nobleInteger(new int[]{3,2,1,3}));
          bubblrSort(new int[]{5,4,3,2,1});

    }
    //Noble Integers CSEI
    private static int nobleInteger(int []A)
    {
        int noble = 0;
        Arrays.sort(A);
        Helpers.Reverse(A,0,A.length-1);
        for(int i=0;i<A.length;i++)
        {
            if(A[i] == i) return 1;
        }
        System.out.println(Arrays.toString(A));
        return noble;
    }
    //sort by colors red = 0 , white = 1, blue  = 2

    private static void sortByColors(int []A)
    {

       int zero  = 0 , one = 0 , two = A.length-1;

        while(one<=two)
        {
            if(A[one]==0)
            {
                swap(A,one,zero);
                one++;zero++;
            }else if(A[one]==2)
                swap(A,one,two--);
            else one++;
        }

        System.out.println(Arrays.toString(A));
    }
    private static void bubblrSort(int []A)
    {
       int n = A.length;

       for(int i=0;i<n-1;i++)
       {
           for(int j=0;j<n-i-1;j++)
           {
               if(A[j]>A[j+1])
               {
                   swap(A,j,j+1);
               }
           }
       }
        System.out.println(Arrays.toString(A));
    }
    private static void swap(int []A,int i,int j)
    {
        int temp  = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
