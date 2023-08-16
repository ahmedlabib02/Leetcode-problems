class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray())
        {
            if(c=='*')
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack)
            sb.append(c);
        return sb.toString();
    }
}