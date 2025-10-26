class Solution {
    public int maximumSwap(int num) {
        int counter =0;
        int temp =num;
        while(temp!=0)
        {
            temp/=10;
            counter++;
        }
        ArrayList<Integer> arr= new ArrayList<>();
        int i=0;
        while(num!=0)
        {
            arr.addFirst(num%10);
            num/=10;
        }

        ArrayList<Integer> arr2 =new ArrayList<>(arr);
        arr2.sort(Comparator.reverseOrder());
        System.out.println(arr +" "+ arr2 );
        for(int j=0;j<arr.size();j++)
        {
            if(arr2.get(j) != arr.get(j))
            {
                int k=j;
                int lastIndex=-1;
                while(k<arr.size())
                {
                    if(arr.get(k) == arr2.get(j))
                        lastIndex =k;
                    k++;
                }
                int t = arr.get(lastIndex);
                arr.set(lastIndex, arr.get(j));
                arr.set(j, t);
                break;
            }
        }

        int ans =0;
        for(int j=0;j<arr.size();j++)
        {
            ans+= arr.get(j);
            ans*=10;
        }
        ans/=10;

        return ans;
    }
}