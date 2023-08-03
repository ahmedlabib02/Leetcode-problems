class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 2) {
            return n;
        }

        int maxPoints = 1;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int duplicate = 0; // Count duplicate points

            for (int j = i + 1; j < n; j++) {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                if (deltaX == 0 && deltaY == 0) {
                    duplicate++;
                } else {
                    String line = generateLine(points[i], points[j]);
                    map.put(line, map.getOrDefault(line, 0) + 1);
                }
            }

            maxPoints = Math.max(maxPoints, duplicate + 1);
            for (int count : map.values()) {
                maxPoints = Math.max(maxPoints, count + duplicate + 1);
            }
        }

        return maxPoints;
    }

    private String generateLine(int[] p1, int[] p2) {
        int deltaX = p2[0] - p1[0];
        int deltaY = p2[1] - p1[1];

        if (deltaX == 0) {
            return "INF"; // Vertical line, infinite slope
        }

        int gcd = gcd(deltaX, deltaY);
        String slope = (deltaY / gcd) + "/" + (deltaX / gcd);
        String yIntercept = (p1[1] - (deltaY / gcd) * p1[0] / (deltaX / gcd)) + "";

        return slope + "/" + yIntercept;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
