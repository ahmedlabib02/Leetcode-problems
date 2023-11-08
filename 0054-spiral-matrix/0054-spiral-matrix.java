class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int inc = 0;
        int elements  = matrix.length * matrix[0].length;
        while(ans.size()<elements)
        {
           for(int i =inc;i<matrix[inc].length-inc;i++)
           {
               ans.add(matrix[inc][i]);
           }
            
           for(int i=inc+1;i<matrix.length-inc ;i++)
           {
               ans.add(matrix[i][matrix[i].length-1-inc]);
           }
           for(int i=matrix[0].length-inc-2;i>=inc && ans.size()<elements;i--) 
           {
               ans.add(matrix[matrix.length-1-inc][i]);
           }
           for(int i=matrix.length-inc-2;i>inc && ans.size()<elements;i--)
           {
               ans.add(matrix[i][inc]);
           }
            
           inc++;
            
        }
        
        return ans;
        
    }
    
    
}