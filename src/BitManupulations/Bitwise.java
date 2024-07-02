package BitManupulations;

public class Bitwise {
    public static void main(String[] args) {
//        System.out.println(countBit(7));
//        System.out.println(singleNumber(new int[]{1,1,2,3,2,3,4}));
//        System.out.println(addBinary("101","1111"));
     //   System.out.println(singlenumber2(new int[]{1,1,2,3,5,2}));
      //  System.out.println(reverseBit(3));
//        System.out.println(minimizeXOR(3,3));
        System.out.println(singleNumber3(new int[]{1,1,1,3}));

    }
    public static int singleNumber3(int[] nums) {
           int res=0;
           for(int i=0;i<32;i++)
           {
               int sum=0;
               for (int num : nums) {
                   if (((num >> i) & 1) == 1) sum++;
               }
               if(sum%3==1) res|=1<<i;
           }
           return res;
    }

    private static int minimizeXOR(int A,int B)
    {
         int res=0;
         for(int i=30;i>=0;i--)
         {
             if((((A>>i) & 1) ==1) && B>0)
             {
                res|= 1<<i;
                B--;
             }
         }
         for(int i=0;i<31;i++)
         {
             if(B>0 && (A>>i & 1)==0)
             {
                 res|=1<<i;
                 B--;
             }
         }
         return res;
    }
    private static long reverseBit(long n)
    {
        long ans=0;
        for(int i=0;i<32;i++)
        {
            long lsb  = (n>>i) & 1;
            long reverselsb = lsb<<31-i;
            ans|=reverselsb;

        }
        return ans;
    }
    private static int[] singlenumber2(int []A)
    {
        int num = singleNumber(A);
        System.out.println(num);
        int pos = firstSetBit(num);
        int num1 = 0,num2 = 0;
        for(int el:A)
        {
            if(((1<<pos) & el) == 0)
            {
                num1^=el;
            }
            else
                num2^=el;
        }
        System.out.println(num1+" | "+num2);
        return new int[]{num1,num2};
    }
    private boolean checkBit(int val,int i)
    {
        if(((1<<i) & val) ==1) return true;
        else return false;
    }
    private static int firstSetBit(int n)
    {
        int pos=-1;
        for(int i=0;i<=30;i++)
        {
            if((n&1)==1)
            {
                pos=i;
                return pos;
            }
            n>>=1;
        }
        return pos;
    }
    private static String addBinary(String a,String b)
    {
        int i=a.length()-1,j=b.length()-1,sum=0,carry=0;
        StringBuilder str = new StringBuilder();
        while(i>=0 || j>=0 || carry>0)
        {
            sum = 0;
            int x=0;
            if(i>=0) x = a.charAt(i) - '0';
            int y=0;
            if(j>=0) y = b.charAt(j) - '0';

            sum = x+y+carry;
            carry = sum/2;

            str.append(sum%2 + "");
            i--;j--;
        }
        return str.reverse().toString();
    }
    private static  int singleNumber(int []A)
    {
        int num = 0;
        for(int el:A) num^=el;
        return num;
    }
    private static int countBit(int n)
    {
        int count=0;
        while(n>0)
        {
            if((n&1)==1) count++;
            n>>=1;
        }
        return count;
    }
}
