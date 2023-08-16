class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for(String op : operations)
        {
            if(op.equals("+"))
            {
                int x = s.pop();
                int temp = s.peek()+ x;
                s.push(x);
                s.push(temp);
                sum+= temp;
            }
            else if(op.equals("D"))
            {
                int x = s.peek();
                int temp = x*2;
                s.push(temp);
                sum+= temp;
            }
            else if(op.equals("C"))
            {
                sum-= s.pop();
            }
            else 
            {
                s.push(Integer.parseInt(op));
                sum+= Integer.parseInt(op);
            }
        }
        return sum;
    }
}