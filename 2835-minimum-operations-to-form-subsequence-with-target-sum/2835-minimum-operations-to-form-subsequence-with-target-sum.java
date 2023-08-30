class Solution {
    public int minOperations(List<Integer> nums, int target)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        long sum =0;
        for(int num: nums)
        {
            sum+= num;
            pq.add(num);
        }
        if(sum<target)
            return -1;
        if(sum==target)
            return 0;
        long ans=0;
        while(!pq.isEmpty())
        {
            
            int num = pq.poll();
            sum-= num;
            if(num<=target)
            {
                target-= num;
            }
            else if(sum<target && num>target)
            {
                pq.add(num/2);
                pq.add(num/2);
                sum+= num;
                ans++;
            }
        }
        return (int)ans;
        
      
    }
    
        
    
}