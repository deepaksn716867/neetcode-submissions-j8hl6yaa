class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //nlogn
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                if((nums[i] + nums[left] + nums[right]) > 0) {
                    right--;
                } else if((nums[i] + nums[left] + nums[right]) < 0) {
                    left++;
                } else if((nums[i] + nums[left] + nums[right]) == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
