class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        int maxLength = 0;
        int len = s.length();
        // arr.length - O(1), s.length() - O(n)

        // generate the longest odd length palindromic substring for each i.
        for (int mid = 0; mid < len; mid++) {
            int i = mid - 1;
            int j = mid + 1;
            int currLength = 1;

            while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                currLength += 2;
            }
            if (currLength > maxLength) {
                answer = s.substring(i + 1, j); 
                // i _ _ _ m _ _ _ j this is the reason
                maxLength = currLength;
            }

        }

        // generate the largest even length palindromic substric for each (i, j) where i, j have to be
        // adjacent
        for (int mid = 0; mid < len - 1; mid++) {
            int i = mid;
            int j = mid + 1; 
            int currLength = 0; // since there are yet to be any found substrings for first iteration.
            while (i >= 0 && j < len && s.charAt(i) == s.charAt(j))  {
                i--;
                j++;
                currLength += 2;
            }
            if (currLength > maxLength) {
                maxLength = currLength;
                answer = s.substring(i + 1, j);
            }
        }
        return answer;
    }
}




/*
mid <- middle element using traversal
i = i - 1
j = j + 1
update you answer till (ans[i] != ans[j])
*/

//     public String longestPalindrome(String s) {
//         // generate all the substrings 
//         // for each substring check if its a palindrome
//         // if yes update the ans

//         // ====== Brute Force ====== O (n * n * n)
//         int len = s.length();
//         int max = Integer.MIN_VALUE;

//         String longestPalindrome = ""; // to store palindrome

//         // for generation of all substrings. 
//         for (int i = 0; i < len; i++) {
//             String substr = "";
//             for (int j = i; j < len; j++) {
//                 substr += s.charAt(j);
//                 // check palindrome and if its longer
//                 if (isPallindrome(substr) && substr.length() > longestPalindrome.length()) {
//                     longestPalindrome = substr; // update
//                 }
//             }
//         }

//         return longestPalindrome;
//     }

// public boolean isPallindrome(String s) {
//         /*
//             madam
//             i   j
//             start reading from i or j it will be same
//             this is a pallindrome
//         */
//         int i = 0;
//         int j = s.length() - 1;

//         while (i <= j) {
//             if (s.charAt(i) == s.charAt(j)) {
//                 i++;
//                 j--;
//             } else {
//                 return false;
//             }
//         }
//         return true;
//     }


/*
b a b a d
0 1 2 3 4

i = 0
    j = 0
    substr = b 
    YES && YES
    longestPalindrome = b

    j = 1
    substr = ba
    NO && YES
    longestPalindrome = b

    j = 2
    substr = bab
    YES && YES
    longestPalindrome = bab

    j = 3
    substr = baba
    NO && YES
    longestPalindrome = bab

    j = 4
    substr = babad
    NO && YES
    longestPalindrome = bab

    returned "bab"

b a b a d
0 1 2 3 4
i = 1
a
ab
aba
abad

i = 2
b
ba
bad

i = 3
a
ad
i = 4
d
    .... and so on for all iterations 
*/