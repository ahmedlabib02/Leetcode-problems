class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        while(m>=1 || n>=1){
            if(m>=1&& n>=1){
                if(nums1[m-1]<nums2[n-1]){
                   nums1[m+n-1]=nums2[n-1];
                    n--;
               }
                else {
                     nums1[n+m-1]=nums1[m-1];
                     m--;
                }
            }
            else if(m>=1){
                nums1[n+m-1]= nums1[m-1];
                m--;
            }
            else if(n>=1){
                nums1[n+m-1]=nums2[n-1];
                n--;
            }
                
            
        }
    }
}