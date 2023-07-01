class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
       HashMap<Double,Long> map = new HashMap<>();
       long res =0;
        for(int i=0;i<rectangles.length;i++){
            double ratio = (double)rectangles[i][0]/rectangles[i][1];
            if(map.get(ratio)==null)
                map.put(ratio,1L);
            else{
                res+= map.get(ratio);
                map.put(ratio,(long)(map.get(ratio)+1));
            }
                                
        }
        return res;
    }
}