class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list; // handle empty array

        int start = nums[0];

        for (int n = 1; n < nums.length; n++) {
            if (nums[n] != nums[n - 1] + 1) {
                // range ended
                if (start == nums[n - 1]) {
                    list.add(Integer.toString(start)); // single number
                } else {
                    list.add(start + "->" + nums[n - 1]);
                }
                start = nums[n]; // start new range
            }
        }

        // Add the last range
        if (start == nums[nums.length - 1]) {
            list.add(Integer.toString(start));
        } else {
            list.add(start + "->" + nums[nums.length - 1]);
        }

        return list;
    }
}
