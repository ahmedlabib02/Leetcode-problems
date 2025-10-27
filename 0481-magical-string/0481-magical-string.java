class Solution {
    public int magicalString(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        int ans =1;
        int pointer =2;
        while(arr.size()<n)
        {
            if(arr.get(pointer)==1 && arr.getLast()==1 )
            {
                arr.add(2);
                pointer++;
            }
            else if(arr.get(pointer)==1 && arr.getLast()==2)
            {
                ans++;
                pointer++;
                arr.add(1);
            }
            else if(arr.get(pointer)==2 && arr.getLast()==1)
            {
                arr.add(2);
                arr.add(2);
                pointer++;

            }
            else
            {

                arr.add(1);
                ans++;
                if(arr.size()>=n)
                    break;
                arr.add(1);
                ans++;
                pointer++;
            }
        }
    //    System.out.println(arr);
        return ans;
    }
}