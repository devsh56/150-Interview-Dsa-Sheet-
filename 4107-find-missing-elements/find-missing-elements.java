class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();
        int start = nums[0];
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == start) {
                start++;
                i++;
            } else if (nums[i] > start) {
                ans.add(start);
                start++;
            } else {
                // Handles duplicate elements
                i++;
            }
        }

        return ans;
    }
}