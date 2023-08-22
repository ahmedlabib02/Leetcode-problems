class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        boolean[] arr= new boolean[(int)Math.pow(2,n)+1];
        for(String num: nums)
            arr[Integer.parseInt(num, 2)]=true;
        for(int i=0;i<arr.length;i++)
            if(!arr[i])
            {
                String xx= Integer.toBinaryString(i);
                while(xx.length()<n)
                    xx= '0'+xx;
                return xx;
            }
                
        return "";
    }
}