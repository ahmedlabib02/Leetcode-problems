class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(Integer num: nums ){
            if(map.get(num)== null){
                map.put(num,0);
            }
            else{
                map.put(num,map.get(num)+1);
            }      
        }
        int[] mostfreq = new int[k];
        ArrayList<Integer> set = new ArrayList<Integer>(map.keySet()) ;
        for(int i=0;i<k;i++){
            int max = set.get(i);
            int indexMax = i;
            for(int j=i+1;j<set.size();j++){
                if(map.get(set.get(j)) > map.get(max)){
                   max=set.get(j);
                   indexMax = j; 
                }       
            }
            int temp = set.get(i);
            set.set(i,max);
            set.set(indexMax,temp);
        }
        System.out.println(set);
        for(int w=0;w<k;w++)
            mostfreq[w] = set.get(w);
        
        return mostfreq;
        
    }
}