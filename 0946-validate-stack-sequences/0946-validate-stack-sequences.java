class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i=0;
        int j=0;
        while(i<pushed.length || j<popped.length)
        {
            
            if(!s.isEmpty()&&s.peek()==popped[j])
            {
                s.pop();
                j++;
            }
            else if(i!=pushed.length)
            {
                s.push(pushed[i]);
                i++;
            }
            else 
                return false;
        }
        return true;
    }
}