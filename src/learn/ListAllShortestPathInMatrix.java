/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;
import java.util.Scanner;
/**
 *
 * @author chand
 */
public class ListAllShortestPathInMatrix {
    static int megapath[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j;
        int[][] mat = new int[n][n];
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }    
        int level = 2*n-1;
        int path[] = new int[level];
        int N=2*(n-1);
        int D=n-1;
        int N1=1;
        int D1=1;
       for(i=1;i<n;i++)
       {
            N1*=N;
            N--;
            D1*=D;
            D--;
       }
       int m=N1/D1;
//       System.out.println(m);
        megapath = new int[m][level+1];
        int c=printShortestPath(0,0,mat,n,path,0,0);
//        for(i=0;i<m;i++)
//        {
//            for(j=0;j<level;j++)
//            {
//                System.out.print(megapath[i][j] +" ");
//            }    
//            System.out.println();
//        }
        for(i=0;i<m;i++)
        {
            for(j=0;j<level;j++)
            {
                megapath[i][level] += megapath[i][j];
            }
//            System.out.println(megapath[i][level]);
        }
//          System.out.println("\n"+c);  

//To find shortest path
        int min=megapath[0][level];
        for(i=0;i<m;i++)
        {
            if(min>megapath[i][level])
                min=megapath[i][level];
        }
//        System.out.println(min);

        for(i=0;i<m;i++)
        {
            if(megapath[i][level]==min)
            {
                for(j=0;j<level+1;j++)
                {
                    System.out.print(megapath[i][j]+" ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
    static int printShortestPath(int i , int j , int[][] mat, int n,int path[],int idx,int c)
    {
         path[idx]=mat[i][j];
//         System.out.print(path[idx]+" ");
         if(i==n-1 && j==n-1)
         {
             for(int k=0;k<2*n-1;k++)
             {
                megapath[c][k]=path[k];
             }
             c++;
//             System.out.println(c);
//             for(int k=0;k<2*n-1;k++)
//             {
//                 System.out.print(path[k]+"     ");
//             }
//             System.out.println();
            return c;
         } 
         if(i<n-1)
            c = printShortestPath(i+1,j,mat,n,path,idx+1,c);
         if(j<n-1)
            c = printShortestPath(i,j+1,mat,n,path,idx+1,c);
         return c;
    }
}
