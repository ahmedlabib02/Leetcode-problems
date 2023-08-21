class SeatManager {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    boolean[] arr;
    public SeatManager(int n) {
       arr= new boolean[n+1];
       for(int i =1;i<=n;i++)
           pq.add(i);
    }
    
    public int reserve() {
        int seat = pq.remove();
        arr[seat]= true;
        return seat;
    }
    
    public void unreserve(int seat) {
        arr[seat]= false;
        pq.offer(seat);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */