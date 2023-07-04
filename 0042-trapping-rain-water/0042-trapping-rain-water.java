class Solution {
    public int trap(int[] height) {
        if(height.length==1)
            return 0;
        int i = 0;
       while(height[i]==0)
           i++;
        
        int j=i+1;
        int res = 0;
        
        while(j<height.length-1){
            int index= j;
            System.out.print(i+" ");
            while(j<height.length){
                if(height[j]>=height[index])
                    index=j;
                if(height[j]>height[i])
                    break;
                j++;
            }
                
            
                
                System.out.print(index);
                int temp = Math.min(height[i++],height[index]);
                System.out.println(" -->"+temp);
                
                while(i<index)
                    res+= temp-height[i++];
                i=index;
                j=i+1;
            

            
        }
        return res;
    }
}