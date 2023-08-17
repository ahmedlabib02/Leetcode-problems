class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> s= new Stack<>();
        int min = nums[0];
        for(int num: nums)
        {
                if(s.isEmpty())
                {
                    s.push(new int[]{num,min});
                    continue;
                }
                
                int[] t = new int[]{num,min}; 
                while(!s.isEmpty()&& num>=s.peek()[0])
                    s.pop();
                if(!s.isEmpty() && num<s.peek()[0] && num>s.peek()[1])
                    return true;
                s.push(t);
                min =Math.min(min, num);
            
            
        }
        return false;
    }
}