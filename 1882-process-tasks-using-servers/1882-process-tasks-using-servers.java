class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b)
            {   
                if(a[1]==b[1])return a[2]-b[2];
                return a[1]-b[1];
            }
                
        });
        PriorityQueue<int[]> busy = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b){
                if(a[0]==b[0])
                   {
                     if(a[1]==b[1])return a[2]-b[2];
                    return a[1]-b[1];  
                   }
                return a[0]-b[0];}});
        
        int counter =0;
        for(int server : servers)
        {
            int[] temp =new int[3];
            temp[0]= 0;
            temp[1]=server;
            temp[2]=counter++;
            pq.add(temp);
        }
        int[] ans = new int[tasks.length];
        
        for(int i=0;i<tasks.length;i++)
        {
            
            while(!busy.isEmpty() && i>=busy.peek()[0])
                pq.add(busy.poll());
            if(!pq.isEmpty())
            {
                int[] temp = pq.poll();
                ans[i]=temp[2];
                temp[0]= i+tasks[i];
                busy.add(temp);
            }
            else
            {
                int[] temp = busy.poll();
                ans[i]= temp[2];
                temp[0]= temp[0]+tasks[i];
                busy.add(temp);
            }
            
        }
        return ans;
    }
}