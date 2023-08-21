class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> min= new PriorityQueue<>();
        int maxVal = Integer.MIN_VALUE;
        for(int num:nums)
        {
            min.add(num);
            maxVal= Math.max(maxVal,num);
        }
        int ans = Integer.MAX_VALUE;
        while(min.peek()%2!=0)
        {
            int num = min.poll();
            ans= Math.min(ans,maxVal-num);
            min.add(num*2);
            if(num*2>maxVal)
                maxVal=num*2;
        }
        ans= Math.min(ans,maxVal-min.peek());
        int minVal = min.peek();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        while(!min.isEmpty())
            max.add(min.poll());
        while(max.peek()%2!=1)
        {
            int num=max.poll();
            ans=Math.min(ans,num-minVal);
            max.add(num/2);
            if(num/2<minVal)
                minVal=num/2;
        }
        ans= Math.min(ans, max.peek()-minVal);
        
        return ans;
    }
}