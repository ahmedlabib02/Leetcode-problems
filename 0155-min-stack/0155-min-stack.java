class MinStack {
    Stack<Integer> s;
    PriorityQueue<Integer> pq;
    public MinStack() {
        pq = new PriorityQueue<>();
        s = new Stack<>();
    }
    
    public void push(int val) {
        pq.add(val);
        s.push(val);
    }
    
    public void pop() {
        int val = s.pop();
        Queue<Integer> q= new LinkedList<>();
        int size = pq.size();
        for(int i=0;i<size;i++)
        {
            if(pq.peek()==val)
            {
                pq.poll();
                break;
            }
                
            else 
                q.add(pq.poll());
        }
         for(int num:q)
             pq.add(num);
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */