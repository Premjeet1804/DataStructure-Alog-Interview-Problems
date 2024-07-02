package ArraysProblems;

public class ArraysNMathProblems {
    public static void main(String[] args) {
//        System.out.println(Excel_Column_Number("BB");
//        System.out.println(missingnadDuplicateNumber(new int[]{3, 1, 2, 5, 3}));
//        System.out.println(divisibilitybyEight("160"));
//        System.out.println(findMod("143",2));
        System.out.println(onNightBulb(new int[]{0,0,1,0}));
    }

    //ExcelColumn Number

    private static int Excel_Column_Number(String s)
    {
        int ans = 0,k=0;
       for(int i=s.length()-1;i>=0;i--)
       {
           int n = s.charAt(i) -'A' + 1;

           ans = ans + n * power(26,k++);

       }
       return ans;
    }
    public static int findMod(String s, int p) {


        int ans = 1;
        int n = s.length();

        for(int i=0;i<s.length();i++)
        {
            int num = s.charAt(i)-'0';

            ans = ans + num *powermod(10,n-i-1,p);
            ans %=p;
        }
        return ans%p;


    }
    //returns a^n%p
    private static int powermod(int a,int n,int p)
    {
        int ans=1;
        for(int i=1;i<=n;i++)
        {
            ans =( (ans%p) * (a%p))%p;
        }
        return ans%p;
    }
    private static int power(int a,int n)
    {
        int ans = 1;
         for(int i=0;i<n;i++)
         {
             ans = ans*a;
         }
         return ans;
    }
    //Return missing and duplication number from an array of size n where A[i] is from 1-n
    private static int[] missingnadDuplicateNumber(int []A)
    {
      return new int[]{};
    }
    private static int divisibilitybyEight(String s)
    {
        int n = s.length();
        if(n == 1)
        {
            int num = s.charAt(0)-'0';
            if(num%8==0) return 1;
        }
        else if(n == 2)
        {
            int secondlast = s.charAt(0)-'0';
            int last = s.charAt(1)-'0';
            int num = secondlast*10+last;
            if(num%8==0) return 1;
        }
        else if(n>=3)
        {
            int thirdlast = s.charAt((n-1-2))-'0';
            int secondlast = s.charAt((n-1)-1)-'0';
            int last = s.charAt((n-1))-'0';
            int num = thirdlast * 100 + secondlast *10 + last;

            if(num%8==0) return 1;

        }

         return 0;
    }
    //Night Bulbs connected by wire
       private static int onNightBulb(int []A)
       {

           boolean flag = false;
           int count = 0;
           int n = A.length;
           for(int i=0;i<n;i++) {
               if (A[i] == 0 && !flag) {
                   flag = true;
                   count++;
               } else if(A[i] == 1 && flag){
                   flag = false;
                   count++;
               }
           }
           return count;
       }
}
