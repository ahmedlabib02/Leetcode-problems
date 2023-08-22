class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> bus = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] arr: trips)
        {
            int passengers = arr[0];
            int curr= arr[1];
            while(!bus.isEmpty() && curr>= bus.peek()[2])
                capacity+= bus.poll()[0];
            bus.add(arr);
            capacity-=passengers;
            if(capacity<0)
                return false;
        }
        return true;
        
    }
}