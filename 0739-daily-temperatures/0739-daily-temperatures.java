class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans= new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int temp = arr[i];
            
            while(!stack.isEmpty() && arr[stack.peek()]<temp)
            {
                int index= stack.pop();
                ans[index]= i-index; 
            }
            stack.push(i);
            
        }
        return ans;
    }
}