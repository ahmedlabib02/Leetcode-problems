class Solution {
    List<String> ans;
    String s;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        s=digits;
        if(s.length()==0)
            return new ArrayList<>();
        backtrack("",0);
        return ans;
    }
    public void backtrack(String s, int i){
        if(s.length()==this.s.length())
        {
            ans.add(s);
            return;
        }
        for(Character c: getNum(this.s.charAt(i)))
        {
            backtrack(s+c,i+1);
        }
    }
    public List<Character> getNum(char c){
        List<Character> arr = new ArrayList<>();
        if(c=='2')
        {
            arr.add('a');
            arr.add('b');
            arr.add('c');
        }
                if(c=='3')
        {
            arr.add('d');
            arr.add('e');
            arr.add('f');
        }
                if(c=='4')
        {
            arr.add('g');
            arr.add('h');
            arr.add('i');
        }
                if(c=='5')
        {
            arr.add('j');
            arr.add('k');
            arr.add('l');
        }
        if(c=='6')
        {
            arr.add('m');
            arr.add('n');
            arr.add('o');
        }
        if(c=='7')
        {
            arr.add('p');
            arr.add('q');
            arr.add('r');
            arr.add('s');
        }
        if(c=='8')
        {
            arr.add('t');
            arr.add('u');
            arr.add('v');
        }
        if(c=='9')
        {
            arr.add('w');
            arr.add('x');
            arr.add('y');
            arr.add('z');
        }
        return arr;
    }
}