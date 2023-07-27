class Solution {
    int memo[][];
    char[][] arr;
    public int maximalSquare(char[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        for(int[] x: memo)
            Arrays.fill(x,-1);
        int max=0;
        arr= matrix;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
            {
                if(memo[i][j]==-1 && arr[i][j]!='0')
                    max = Math.max(max, dp(i,j) );
                else
                    max= Math.max(max,memo[i][j]);
            }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
                System.out.print(memo[i][j]+"   ");
            System.out.println();
        }
            
        return max;
    }
    public int dp(int i, int j ){
        // System.out.println(i+" "+j);
        if(memo[i][j]!=-1)
            return memo[i][j];
        int down= 1;
        if(i!=arr.length-1 )
        {
            if(arr[i+1][j]=='0')
            {
                memo[i][j]=1;
                return memo[i][j];
            }   
            else
                down = dp(i+1,j);
        }
        else 
        {
            memo[i][j]=1;
            return 1;
        }
        int right = 0;
        if(j!=arr[i].length-1)
        {
            if(arr[i][j+1]=='0')
            {
                memo[i][j]=1;
                return memo[i][j]; 
            }
                
            else
                right= dp(i,j+1);   
        }
        else
        {
            memo[i][j]=1;
            return 1;
        }
        int dia = 0;
        if(j!=arr[i].length-1 && i!=arr.length-1)
        {
            if(arr[i+1][j+1]=='0' )
            {
                memo[i][j]=1;
                return memo[i][j]; 
            }
                
            else
                dia = dp(i+1,j+1); 
        }
        else 
        {
            memo[i][j]=1;
            return 1;
        }
        
        int temp = Math.min(down,Math.min(dia,right));
        temp = (int)Math.sqrt(temp);
        temp++;
        memo[i][j]= temp*temp;
        return memo[i][j];

    }
}