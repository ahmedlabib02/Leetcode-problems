class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j =(matrix[0].length *matrix.length) -1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            int row = mid/matrix[0].length;
            int col= mid%matrix[0].length;
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                j=mid-1;
            else i=mid+1;
        }
        return false;
    }
}