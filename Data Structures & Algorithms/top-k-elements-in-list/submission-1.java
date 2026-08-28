class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer> freq = new HashMap<>(nums.length);
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num,0)+1);
    }

    List<List<Integer>> counts = new ArrayList<>(nums.length +1);
    for (int i = 0; i <nums.length+1; i++) {
        counts.add(new ArrayList<>());
    }
    for (int key : freq.keySet()) {
        int count = freq.get(key);
        counts.get(count).add(key);
    }
    int[] res = new int[k];
    int j = 0;
    for (int i = nums.length; i>0;i--) {
        if (counts.get(i) != null) {

            for (int x :counts.get(i)) {
                if (j == k) {
                    return res;
                }
                res[j] = x;
                j++;
            }
        }
    }
    return res;
    }
}