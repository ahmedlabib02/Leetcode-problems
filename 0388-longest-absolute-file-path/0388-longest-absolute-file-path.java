class Solution {
    public int lengthLongestPath(String input) {
        String[] inputs = input.split("\n");
        Stack<Object[]> stack = new Stack<>();
        // stack.push(inputs[0]);
        int length =0;
        int ans=0;
        length=-1;
        for(int i=0;i<inputs.length;i++)
        {
            int tabCount = countTabs(inputs[i]);
            Object[] pair = new Object[]{inputs[i], tabCount};
            while(!stack.isEmpty() && tabCount<= (int)stack.peek()[1] )
            {
                length= length - ((String)stack.peek()[0]).length() + (int)stack.peek()[1];
                stack.pop();
                length--;
            }
            stack.push(pair);
            length++;
            // System.out.println(pair[0]);
            // printStack(stack);
            length=length+ inputs[i].length() - (int) pair[1];
            if(ans<length && inputs[i].contains(".") )
            {
                printStack(stack);
                ans = length;
            }
        }
        return ans;
        
    }
    
    public void printStack(Stack<Object[]> stack){
        for(Object[] pair: stack)
            System.out.print(pair[0]+" ");
        System.out.println();
    }
    
    public  int countTabs(String str) {
        int originalLength = str.length();
        int lengthWithoutTabs = str.replaceAll("\t", "").length();
        return originalLength - lengthWithoutTabs;
    }
}