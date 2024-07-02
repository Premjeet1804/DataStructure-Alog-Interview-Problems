package ArraysProblems;

public class PatternPrinting {
    public static void main(String[] args) {
        pattern01(3);

    }
    //0 0 1
    //0 1 2
    //1 2 3
    private static void pattern01(int n)
    {
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {

                if(i>=(n-1-j))
                    System.out.print(n-j);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
