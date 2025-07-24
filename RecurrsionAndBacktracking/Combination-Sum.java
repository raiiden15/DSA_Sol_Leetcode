class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void helper(int[] arr, int target, List<Integer> list, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || index == arr.length) {
            return;
        }

        // take current element 
        list.add(arr[index]);
        helper(arr, target - arr[index], list, index);
        list.remove(list.size() - 1);

        // dont take current element 
        helper(arr, target, list, index + 1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, new ArrayList<>(), 0);
        return result;
    }
}