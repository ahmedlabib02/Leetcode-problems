class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens)
        {
            if(s.equals("+")|| s.equals("-")|| s.equals("/") || s.equals("*"))
            {
                int x = stack.pop();
                stack.push(   calc(x,stack.pop(), s)   );
            }
            else 
            {
                int x = Integer.parseInt(s);
                stack.push(x);
            }
        }
        return stack.pop();
    }
    public int calc(int x, int y, String op)
    {
        switch(op)
        {
            case "+": return x+y;
            case "-": return y-x;
            case  "/": return y/x;
            case "*" : return x*y;    
                
        }
        return 0;
    }
}