package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiDimensionalArraysProblems {

    public static void main(String[] args) {
        int [][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//          int [][]matrix = new int[][]{{1,3}};
        int [][]mat = new int[][]{{0,0,0,0,0,1,1,1,1},{0,0,0,0,0,1,1,1,1},
                {0,0,0,0,0,1,1,1,1},{0,0,0,0,0,0,1,1,1},{0,0,0,0,0,0,1,1,1}
                ,{0,0,0,1,1,1,1,1,1},{0,0,0,0,1,1,1,1,1},{0,0,0,1,1,1,1,1,1},{0,0,0,1,1,1,1,1,1}};
//        int [][]ans = printDiagonalR_L(matrix);

//        for(int []item : ans) System.out.println(Arrays.toString(item));

        //System.out.println(Arrays.toString(columnWiseSum(matrix)));
//        transpose(matrix);

//        diagonalSum(matrix);
//        rotateby90(matrix);
//        printBoundaryofaMatrix(matrix);
//          spiralMtrix(matrix);
//        System.out.println(searchMatrix(matrix,3));
//        printBoundary(matrix);
       // System.out.println(searchInZeroOneMatrix(mat));
        createSpiralMatrix(5);
    }
    //Search in a 2d matrix
    public static int searchInZeroOneMatrix(int [][]A)
    {
        int N = A.length;
        int M = A[0].length;
        int i=0,j = N-1;
        int index = -1;

        while(i<N && j>=0)
        {
            if(A[i][j]==1)
            {
                index = Math.max(index,i);
                j--;
            }
            else if(A[i][j]==0)
                i++;
        }
        return index;

    }
    public static void printBoundary(int [][]mat)
    {
        int N = mat.length;
        int M =mat[0].length;
        List<Integer> list = new ArrayList<>();
        int i=0,j=0;

            while(N>1 && M>1) {
                //L-->R
                for (int l = 1; l < M; l++) {
                    list.add(mat[i][j]);
                    j++;
                }
                //T-->B
                for (int l = 1; l < N; l++) {
                    list.add(mat[i][j]);
                    i++;
                }
                //R-->L
                for (int l = 1; l < M; l++) {
                    list.add(mat[i][j]);
                    j--;
                }
                //B-->T
                for (int l = 1; l < N; l++) {
                    list.add(mat[i][j]);
                    i--;
                }
                N-=2;
                M-=2;
                i+=1;
                j+=1;
            }
        if(N==1 && M==1) list.add(mat[i][j]);
        else if(N==1)
        {
            for(int l=1;l<=M;l++)
            {
                list.add(mat[i][j++]);
            }
        }
        else if(M==1)
        {
            for(int l=1;l<=N;l++)
            {
                list.add(mat[i++][j]);
            }
        }


        System.out.println(list);
    }
    public static void createSpiralMatrix(int n)
    {
        int N = n;
        int [][]ans = new int[n][n];
        int i=0,j=0,k=1;
        while(N>1)
        {
            for(int l=1;l<N;l++)
            {
                ans[i][j] = k++;
                j++;
            }
            for(int l=1;l<N;l++)
            {
                ans[i][j] = k++;
                i++;
            }
            for(int l=1;l<N;l++)
            {
                ans[i][j] = k++;
                j--;
            }
            for(int l=1;l<N;l++)
            {
                ans[i][j] = k++;
                i--;
            }
            N-=2;i+=1;j+=1;
        }
        if(N==1) ans[i][j]=k;
        for(int []arr : ans)
        {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        int i=0,j=matrix[0].length-1;

        while(i<matrix.length && j>=0)
        {
            if(matrix[i][j]>target) j--;

            else if(matrix[i][j]<target) i++;

            else if(matrix[i][j]==target) return true;
        }
        return false;
    }

    //Minor and Major diagonal Sum
    public static  void diagonalSum(int [][]A)
    {
        int M = A.length;
        int N = A[0].length;

        //Major digonal sum
        int majorSum = 0;
        for(int i=0;i<M;i++)
        {
            majorSum+=A[i][i];
        }
        int minorSum=0,j=M-1;
        for(int i=0;i<M;i++)
        {
            minorSum += A[i][j--];
        }

        System.out.println("Major sum is - "+majorSum+"Minor sum is - "+minorSum);
    }
    //Transpose of a Matrix of size N * N (Inplace) O (1)
    public static  int[][] transpose(int [][]A)
    {
        int M = A.length;
        int N = A[0].length;
        if(M==N) {
            for (int i = 0; i < M - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int temp = A[i][j];
                    A[i][j] = A[j][i];
                    A[j][i] = temp;
                }
            }

            for (int[] item : A)
                System.out.println(Arrays.toString(item));
            return A;
        }
        else
        {
            int [][]mat = new int[N][M];
            for(int i=0;i<M;i++)
            {
                for(int j=0;j<N;j++)
                {
                    mat[j][i] = A[i][j];
                }
            }
            for(int []item : mat)
            {
                System.out.println(Arrays.toString(item));
            }
            return mat;
        }
    }
    public static void rotateby90(int [][]A)
    {
       int [][]mat = transpose(A);

       for(int []arr : mat)
       {
           reverse(arr);
       }

       for(int []item : mat)
       {
           System.out.println(Arrays.toString(item));
       }
    }
    private static void reverse(int []A)
    {
        int i=0,j=A.length-1;
        while(i<j)
        {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;j--;
        }
    }

    //Print column wise sum of 2d matrix
    public static int[] columnWiseSum(int [][]A)
    {
        int M = A.length;
        int N = A[0].length;
        int []ans = new int[N];

        for(int j=0;j<N;j++)
        {
            int sum=0;
            for(int i=0;i<M;i++)
            {
              sum+=A[i][j];
            }
            ans[j] = sum;
        }
        return ans;
    }

    //Add 2 matrix and return its sum
    public static int[][] solve(int[][] A, int[][] B) {

        int M = A.length;
        int N = A[0].length;
        int [][]ans = new int[M][N];

        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                ans[i][j] = A[i][j] + B[i][j];
            }
        }

        return ans;
    }
    //Print Diagonal from R--L
    public static int[][] printDiagonalR_L(int [][]A)
    {
        int M = A.length;
        int N = A[0].length;
        int [][]ans = new int[M+N-1][N];
        int x=0,y=0;
        for(int k=0;k<N;k++)
        {
            int j=k,i=0;
            y=0;
            while(j>=0 && i<N)
            {
                ans[x][y++] = A[i][j];
                i++;j--;
            }
            x++;
        }

        for(int k=1;k<N;k++)
        {
            int i=k,j=M-1;
            y=0;
            while(i<N && j>=0)
            {
                ans[x][y++] = A[i][j];
                i++;j--;
            }
            x++;
        }


        return ans;
    }

    public static void printBoundaryofaMatrix(int [][]A)
    {
        int M = A.length;
        int N = A[0].length;

        for(int i=0;i<N;i++)
            System.out.print(A[0][i]);

        System.out.println();

        for(int i=1;i<N;i++)
            System.out.print(A[i][N-1]);

        System.out.println();

        for(int i=N-2;i>=0;i--)
            System.out.print(A[N-1][i]);

        System.out.println();

        for(int i=N-2;i>0;i--)
            System.out.print(A[i][0]);

    }
    public static void spiralMtrix(int [][]A)
    {
        int left=0;
        int right = A[0].length-1;
        int top = 0;
        int bottom = A.length-1;
        int M = A.length;
        int N = A[0].length;
        List<Integer> list = new ArrayList<>();

        while(list.size()<(M*N))
        {
            for(int i=left;i<=right;i++)
            {
                list.add(A[top][i]);
            }
            left++;
            for(int i=top+1;i<=bottom;i++)
            {
                list.add(A[i][bottom]);
            }
            top++;
            for(int i=right;i>=left;i--)
            {
                list.add(A[right][i]);
            }
            right--;
            for(int i=bottom-1;i>=top;i--)
            {
                list.add(A[top][i]);
            }
            bottom--;
        }
        System.out.println(list);
    }
}
