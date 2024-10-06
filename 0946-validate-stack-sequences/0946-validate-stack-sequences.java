class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // HashSet<Integer> set= new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int j=0;
        int i=1;
        stack.push(pushed[0]);
        // set.add(pushed[0]);
        while(!stack.isEmpty())
        {
            if(i>=pushed.length && popped[j]!=stack.peek())
                break;
            //popped[j]== peek then we need to pop now before pushing anything else
            while(!stack.isEmpty() && popped[j]==stack.peek())
            {
                stack.pop();
                j++;
            }
            if(i<pushed.length)
                stack.push(pushed[i]);
            
                
            // System.out.println(stack);
            i++;

        }
        return (j==popped.length);
    }
}