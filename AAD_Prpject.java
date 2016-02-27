package aad_prpject;
public class AAD_Prpject {
    
    public static void find(int[] A, int currSum, int index, int sum,int[] solution) {
		if (currSum == sum) {
			System.out.println("The subset is :");
			for (int i = 0; i < solution.length; i++) {
				if (solution[i] == 1) {
					System.out.print("  " + A[i]);
				}
			}
                        System.out.println();

		} else if (index == A.length) {
			return;
		} else {
                        if(A[index]<=sum)
                        {
                            solution[index] = 1;
                            currSum += A[index];
                            find(A, currSum, index + 1, sum, solution);
                            currSum -= A[index];	
                            solution[index] = 0;
                        }
			find(A, currSum, index + 1, sum, solution);
		}
		return;
	}
    
    public static boolean subSetDP(int[] A, int sum) {
		boolean[][] solution = new boolean[A.length + 1][sum + 1];
		for(int i=1;i<=sum;i++){
			solution[0][i]=false;
		}
				for(int i=0;i<=A.length;i++){
					solution[i][0]=true;
				}
		for(int i=1;i<=A.length;i++){
			for(int j=1;j<=sum;j++){
				solution[i][j] = solution[i-1][j];
				if(solution[i][j]==false && j>=A[i-1])
					solution[i][j] = solution[i-1][j] || solution[i-1][j-A[i-1]];				
			}
		}	
                findPathRec(solution,A.length,sum,A);
		return solution[A.length][sum];
	}
    
    static void print (boolean [][] A,int W , int H){
        for(int i=0;i<=H;i++)
        {
            for(int j=0;j<=W;j++)
            {
                System.out.print(A[i][j]+"    ");
            }
            System.out.println();
         }
    }
    
     static void findPathRec(boolean [][] A,int H , int W,int [] Solution){
            if(H==0|| W==0)
                return;
            
            if(A[H][W])
            {
                if(!A[H-1][W]){
                    findPathRec(A, H, W-Solution[H-1], Solution);
                }
                else 
                    findPathRec(A, H-1, W, Solution);
            }
        
    }
        
    public static void main(String[] args) {
        System.out.println("Recursively :");
        int[] A = { 7, 5, 2, 1,3,1,1,9};
        int[] B = new int [A.length] ;
        find(A, 0, 0, 5, B );
        int[] C = { 3, 2, 7, 1};
        System.out.println("Dynamic programming :");
        int sumDP = 6;
	System.out.printf("Thier is a subset that has a sum equal to : %d , %b \n" ,sumDP, subSetDP(C, sumDP) );
    }
    
}
