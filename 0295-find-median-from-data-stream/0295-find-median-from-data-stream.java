class MedianFinder {
    PriorityQueue<Integer> first;
    PriorityQueue<Integer> second;
    public MedianFinder() {
        first= new PriorityQueue<>(Collections.reverseOrder());
        second = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(first.isEmpty() && second.isEmpty())
            first.add(num);
        else if(first.size()==second.size())
        {
            if(num>second.peek())
                second.offer(num);
            else 
                first.offer(num);
        }
        else if(first.size()-1==second.size())
        {
            if(num>=first.peek())
                second.offer(num);
            else
            {
                second.offer(first.poll());
                first.offer(num);
            }
        }
        else
        {
            if(num>second.peek())
            {
                first.offer(second.poll());
                second.offer(num);
            }
            else
                first.offer(num);
        }
        
    }
    
    public double findMedian() {
        if(first.size()==second.size())
        {
            double res = ((double)first.peek()+second.peek())/2;
            return res;
        }
        else if(first.size()>second.size())
            return first.peek();
        else
            return second.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */