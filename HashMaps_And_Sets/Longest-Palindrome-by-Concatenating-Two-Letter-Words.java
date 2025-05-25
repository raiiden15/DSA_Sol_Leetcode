class Solution {
    public int longestPalindrome(String[] words) {
        int length = 0;
        Map<String, Integer> map = new HashMap<>();

        for(String word : words) {
            String rev = new StringBuilder(word).reverse().toString();

            if(map.getOrDefault(rev, 0) > 0) {
                length += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if(word.charAt(0) == word.charAt(1) && count > 0) {
                length += 2;
                break;
            } 
        }
        return length;
    }
}

// ab - ba - I
// aa - append in between of I
// eg : 
/*
["lc","cl","gg"]
lc - gg - cl OR cl - gg - lc 
therefore, we can use same letter string to put it in between while forming palindrome, can be used only once in the palindrome string. 

We can use set, but there can be other instances of the same element, therefore we cannot use set. 
Instead we use an map. 

If we don't have reverse of our current string in words array, put it in map

*/