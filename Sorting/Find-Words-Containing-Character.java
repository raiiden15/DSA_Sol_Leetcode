class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (words[i].contains(Character.toString(x))) {
                ans.add(i);
            }
        }
        return ans;
    }
}