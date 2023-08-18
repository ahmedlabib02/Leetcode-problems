class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int ans= 0;
        for(int num: heights)
        {
            int count=0;
            while(!s.isEmpty() && num<s.peek() )
            {
                count++;
                ans= Math.max(ans,count*s.pop());
            }
            while(count!=0)
            {
                s.push(num);
                count--;
            }
            s.push(num);
        }
        int count=0;
        while(!s.isEmpty())
        {
            count++;
            ans= Math.max(ans,count*s.pop());
        }
        return  ans;
    }
}