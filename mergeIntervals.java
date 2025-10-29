import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> merged = new ArrayList<>();
        
        // Step 2: iterate through intervals
        for (int[] interval : intervals) {
            // if merged list is empty or no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // overlapping → merge by updating the end
                merged.get(merged.size() - 1)[1] = 
                    Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        // Step 3: convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}
