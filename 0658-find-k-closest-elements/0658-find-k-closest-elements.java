class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length <= k)
            return Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
        int j=k;
        int i=0;
        while(j<arr.length){
            if(Math.abs(arr[i]-x)>Math.abs(arr[j]-x)){
                j++;
                i++;
            }
            else if(Math.abs(arr[i]-x)==Math.abs(arr[j]-x)&& arr[j]<=arr[i]){
                   j++;
                   i++;  
            }
            else break;
    
        }
        List<Integer> list = new ArrayList<>();
        for(int start=i;start<j;start++)
            list.add(arr[start]);
        return list;
    }
}