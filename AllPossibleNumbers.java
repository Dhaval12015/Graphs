import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AllPossibleNumbers {
    static int raw[] = {0,0,-1,0,1};
    static int col[] = {0,-1,0,1,0};
    
    static int findCount(char mat[][],int r,int c,int n){
        if(mat==null || n<=0) return 0;
        if(n==1) return 1;
        int totalCount = 0;
        int r1=0,c1=0;
        for(int move=0;move<5;move++){
            r1 = r + raw[move];
            c1 = c + col[move];
            if(r1>=0 && c1>=0 && r1<4 && c1<3 && mat[r1][c1] != '#' && mat[r1][c1] != '*')
            totalCount += findCount(mat,r1,c1,n-1);
        }
        return totalCount;
    }
    
    
    static int gotoEachPosition(char mat[][],int n){
        if(mat==null || n<=0) return 0;
        if(n==1) return 10;
        int totalCount = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(mat[i][j] != '#' && mat[i][j] != '*'){
                 //   System.out.println(mat[i][j]);
                totalCount += findCount(mat,i,j,n);
              //  System.out.println(totalCount);
                }
            }
        }
        return totalCount;
    }
    public static void main(String args[]){
    	
   // 	printf("%s",str);
        char mat[][] = new char[][]{
            {'1','2','3'},
            {'4','5','6'},
            {'7','8','9'},
            {'#','0','*'}
        };
        System.out.println(gotoEachPosition(mat,3));
        
    }
   
}
