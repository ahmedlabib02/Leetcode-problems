class Solution {
    int[] arr;
    public boolean mergeTriplets(int[][] triplets, int[] target) {
    arr= target;
    boolean x = false;
    boolean y = false;
    boolean z = false;
    for(int[] arr: triplets)
    {
        if(arr[0]<=target[0] && arr[1]<=target[1] && arr[2]<=target[2])
        {
            if(arr[0]==target[0])
                x=true;
            if(arr[1]==target[1])
                y=true;
            if(arr[2]==target[2])
                z=true;
        }
    }
        if(x&&y&&z)
            return true;
        return false;
    
    }
    
}