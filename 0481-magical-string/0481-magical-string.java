class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;               // "122" → ones = 1 for n=1..3

        int[] s = new int[n + 2];           // primitive array, no boxing
        s[0] = 1; s[1] = 2; s[2] = 2;

        int ones = 1;                        // count of '1' in first n
        int head = 2;                        // reads how many to write (1 or 2)
        int tail = 3;                        // next write position
        int num  = 1;                        // next number to write (1 then 2 then 1 ...)

        // stream-generate until we have n elements
        while (tail < n) {
            int cnt = s[head++];             // write 'cnt' copies of 'num'
            for (int k = 0; k < cnt && tail < n; k++) {
                s[tail++] = num;
                if (num == 1) ones++;        // count only within first n
            }
            num = 3 - num;                   // toggle 1 <-> 2
        }
        return ones;
    }
}