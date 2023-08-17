class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";
        
        Stack<Character> s = new Stack<>();
        
        for (Character c : num.toCharArray()) {
            while (!s.isEmpty() && k > 0 && c < s.peek()) {
                s.pop();
                k--;
            }
            s.push(c);
        }
        
        while (k > 0) {
            s.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.insert(0, s.pop());
        }
        
        
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
