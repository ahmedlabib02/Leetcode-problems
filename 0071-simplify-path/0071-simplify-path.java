class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr= path.split("/");
        for(String s: arr)
        {
            if(s.equals(".")|| s.equals(""))
                continue;
            else if(s.equals("..") )
            {
                if(!stack.isEmpty())
                    stack.pop();

            }
            else
            {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s: stack)
        {
            sb.append('/');
            sb.append(s);
        }
        if(sb.length() ==0)
            return "/";
        return sb.toString();    
    }
}