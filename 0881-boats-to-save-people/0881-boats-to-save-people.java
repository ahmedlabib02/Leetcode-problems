class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat =0;
        int i =0;
        int j= people.length-1;
        while(i<=j){
            if(people[i]==-1)
                i++;
            if(people[i]+people[j]<=limit){
                boat++;
                people[j]=-1;
                people[i]=-1;
                i++;
                j--;
            }
            else if(people[i]+people[j]>limit){
                j--;
            }
                
        }
        for(int x=0;x<people.length;x++)
            if(people[x]!=-1)
                boat++;
        
        return boat;
        
    }
}