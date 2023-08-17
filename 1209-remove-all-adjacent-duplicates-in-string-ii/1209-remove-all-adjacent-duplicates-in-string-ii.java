class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> stack = new Stack<>();
        for(Character c : s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek().getKey()==c && stack.peek().getValue()==k-1)
            {
                while(!stack.isEmpty() && stack.peek().getKey()==c)
                    stack.pop();
                
            }
            else if(!stack.isEmpty() && stack.peek().getKey()==c)
            {
                stack.push(new Pair<>(c,stack.peek().getValue() +1));
            }
            else 
            {
                stack.push(new Pair<>(c,1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair p : stack)
            sb.append(p.getKey());
        return sb.toString();
    }
}