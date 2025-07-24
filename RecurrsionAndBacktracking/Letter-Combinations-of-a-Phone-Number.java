class Solution {
    Map<Character, char[]> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public void helper(String digits, int index, String strfsf) {
        if (index == digits.length()) {
            result.add(strfsf);
        }
        else {
            char keyPressed = digits.charAt(index);
            char[] poss = map.get(keyPressed);
            for (char possChar: poss) {
                helper(digits, index + 1, strfsf + possChar);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        helper(digits, 0, "");
        return result;
    }
}