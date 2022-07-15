// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nqueens-branch-and-bound-official/ojquestion

//solution
// this branch and bound algo decreses the time complexity of nQueen problem
// we make three arrays for 
// 1. for column that have a queen  {colArray[col] = 1}
// 2. for diagonal that have a queen { here we use a fact that the sum of row and col is equal for diagonal element present at same diagonal} 
    //   diag[row+col] = 1;
// 3. for reverse diagonal that have a queen { here we use a fact that the row -col for reverse daigonal is same}
//    revDaig[row-col+sizeofArray-1] =1;
// total number of diagonal of a square matrix is = 2*length-1;




package backtracking;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int mat [][]= new int[n][n];
		int co[] = new int[n];
		int size = 2*n-1;
		int d1[] = new int[size];
		int d2 []= new int[size];
		solve(n, 0,"",co,d1,d2);
		
	}
	
	public static void solve(int n, int row,String qpsf, int co[], int d1[], int d2[]) {
		if(row==n) {
			System.out.println(qpsf+".");
			return;
		}
		
		for(int col = 0; col<n; col++) {
			if(co[col]==0 && d1[row+col]==0 &&d2[row-col+co.length-1]==0) {
				co[col]=1;
				d1[row+col]=1;
				d2[row-col+n-1]=1;
				solve(n,row+1,qpsf+row+"-"+col+",",co,d1,d2);
				co[col]=0;
				d1[row+col]=0;
				d2[row-col+n-1]=0;
			}
		}
	}
	
}
