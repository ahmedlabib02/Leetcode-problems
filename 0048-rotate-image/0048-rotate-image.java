class Solution {
    public void rotate(int[][] arr) {
        
        for(int k=0;k<arr.length/2;k++)
        {
            int[] w = new int[arr.length-k-k];
            for(int i=k;i<arr.length-k;i++)
                w[i-k] = arr[i][k];
            
            int[] z = new int[arr.length-k-k];
            for(int i=k;i<arr.length-k;i++)
                z[i-k]=  arr[arr.length-k-1][i];
            
            int[] y =new int[arr.length-k-k];
            for(int i=k;i<arr.length-k;i++)
                y[i-k]= arr[i][arr.length-1-k];
            
            int[] x= new int[arr.length-k-k];
            for(int i=k;i<arr.length-k;i++)
                x[i-k]=  arr[k][i];
            
            for(int i=k;i<arr.length-k;i++)
                arr[i][k] = z[i-k];
            
            int index=y.length-1;
            for(int i=k;i<arr.length-k;i++)
                arr[arr.length-k-1][i]=  y[index--];
            
            for(int i=k;i<arr.length-k;i++)
                arr[i][arr.length-1-k]= x[i-k];
            
            index= w.length-1;
            for(int i=k;i<arr.length-k;i++)
                arr[k][i]=  w[index--];
            
        
        
        }
        
    }
    public void print(int[] arr){
        for(int num:arr)
            System.out.print(num+" ");
        System.out.println();
    }
    public void print(int[][] arr){
        for(int[] x: arr)
        {
            for(int num:x)
            System.out.print(num+" ");
        System.out.println();
        }
        
    }
}