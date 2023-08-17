class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            // System.out.println(stack);
            if(c==']')
            {
                String sb = "";
                while(!stack.isEmpty() && stack.peek()!='[')
                    sb= stack.pop()+sb;
                stack.pop();
                String num = "";      
                while(!stack.isEmpty()&& stack.peek()>='0' && stack.peek()<='9')
                    num= stack.pop()+num;
                int x = Integer.parseInt(num);
                StringBuilder temp = new StringBuilder();
                for(int i=0;i<x;i++)
                    temp.append(sb);
                for(Character cc : temp.toString().toCharArray())
                    stack.push(cc);
            }
            else
                stack.push(c);
               
        }
        for(Character c : stack)
            ans.append(c);
        return ans.toString();
    }
    
    
}