class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(a.charAt(0)==b.charAt(0)&&a.length()!=b.length()){
                String x = a+b;
                String y = b+a;
                return x.compareTo(y);
                // int min = Math.min(a.length(),b.length());
                // boolean equal = true;
                // for(int i=0;i<min;i++){
                //     if(a.charAt(i)<b.charAt(i)) return 1;
                //     if(a.charAt(i)>b.charAt(i)) equal = false;
                // }
                // if(equal) return 1;
                // return -1;
            }else{
                return a.compareTo(b);
            }
        });
        // Arrays.sort(numbers);
        for(int i=0;i<nums.length;i++)
            pq.add(nums[i]+""); 
        String res = "";
        while(!pq.isEmpty()){
            res=pq.poll()+res;
        }
        if(res.charAt(0)=='0') return "0";
        return res;
    }
}