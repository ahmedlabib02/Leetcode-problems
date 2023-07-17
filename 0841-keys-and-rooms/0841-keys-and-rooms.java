class Solution {
    boolean[] seen;
    List<List<Integer>> temp;
    int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen = new boolean[rooms.size()];
        temp = rooms;  
            n=0;
            seen = new boolean[rooms.size()];
            seen[0]=true;
            dfs(0);
            if(n==rooms.size()-1)
                return true;
        
        return false;
    }
    public void dfs(int i){
        for(int nums: temp.get(i))
        {
            if(!seen[nums]){
                n++;
                seen[nums]=true;
                dfs(nums);
            }
        }
    }
}