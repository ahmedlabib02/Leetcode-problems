class Solution {
    public int removeElement(int[] nums, int val) {
       PriorityQueue<Integer> q = new PriorityQueue<>();
       int count = 0; 
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]==val)
           {
               q.add(i);
               count++;
           }
               
           else if(nums[i]!=val && !q.isEmpty())
           {
               int index= q.poll();
               q.add(i);
               int temp = nums[index];
               nums[index]= nums[i];
               nums[i]= temp;
           }
       }
       for(int num: nums)
           System.out.print(num+" ");
       return nums.length-count;  
    }
}