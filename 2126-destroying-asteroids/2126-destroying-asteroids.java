class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long s = mass;
        for(int i=0;i<asteroids.length; i++)
        {
            if(asteroids[i]<=s)
                s+=asteroids[i];
            else
                return false;
        }
        return true;
    }
}