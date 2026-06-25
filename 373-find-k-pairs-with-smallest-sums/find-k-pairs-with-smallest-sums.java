class Solution {
 class Pair {
        int sum;
        int co;
        int co_1;

        public Pair(int sum, int co, int co_1) {
            this.sum = sum;
            this.co = co;
            this.co_1 = co_1;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> ll = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        HashSet<String> visited = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        ll.add(new Pair(nums1[0] + nums2[0], 0, 0));
        visited.add(0 + "," + 0);

        while (k > 0 && !ll.isEmpty()) {
            Pair p = ll.poll();
            int i = p.co;
            int j = p.co_1;

            ans.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Add the next pair from nums1 and nums2
            if (i + 1 < nums1.length && !visited.contains((i + 1) + "," + j)) {
                ll.add(new Pair(nums1[i + 1] + nums2[j], i + 1, j));
                visited.add((i + 1) + "," + j);
            }
            if (j + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                ll.add(new Pair(nums1[i] + nums2[j + 1], i, j + 1));
                visited.add(i + "," + (j + 1));
            }
        }
        return ans;
    }
}