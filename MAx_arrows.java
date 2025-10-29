import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        // Step 1: Sort by end point
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Step 2: Initialize
        int arrows = 1;
        int lastEnd = points[0][1];
        
        // Step 3: Iterate
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                arrows++;                // Need a new arrow
                lastEnd = points[i][1];  // Update the arrow position
            }
            // else -> balloon is already burst by current arrow
        }
        
        return arrows;
    }
}
