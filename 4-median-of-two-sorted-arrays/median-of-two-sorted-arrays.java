class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = (n + m + 1) / 2;
        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = (start + end) / 2;
            int mid_1 = total - mid;

            // ✅ FIX 1: correct boundary initialization
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid - 1 >= 0) l1 = nums1[mid - 1];
            if (mid < n) r1 = nums1[mid];
            if (mid_1 - 1 >= 0) l2 = nums2[mid_1 - 1];
            if (mid_1 < m) r2 = nums2[mid_1];

            if (l1 <= r2 && l2 <= r1) {
                // ✅ FIX 2: avoid overflow
                if ((n + m) % 2 == 0) {
                    return ((double)Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double)Math.max(l1, l2);
                }
            }
            // ✅ FIX 3: correct comparison (no indexing)
            else if (l1 > r2) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0.0;
    }
}