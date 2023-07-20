

class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] seen = new boolean[arr.length];
        seen[start]=true;
            
        while(!q.isEmpty())
        {
            int index = q.remove();
            if(arr[index]==0)
                return true;
            int next= arr[index]+index;
            int prev = index-arr[index];
            // System.out.println(index+" "+next+" "+prev);
            if(next<arr.length && !seen[next])
            {
                seen[next]=true;
                q.add(next);
            }
                
            if(prev>=0 && !seen[prev]) 
            {
                seen[prev]=true;
                q.add(prev);
            }
        }
        return false;
    }
}