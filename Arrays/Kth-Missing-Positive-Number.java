// Linear Search Beats 100%

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        while(i < arr.length && (arr[i] - (i + 1)) < k) {
            i++;
        }
        return k + i;
    }
}

/*  
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int i = 0;
        int curr = 1;

        while (missing < k) {
            if (i < arr.length && arr[i] == curr) {
                i++;
            } else {
                missing++;
            }
            curr++;
        }

        return curr - 1;
    }
}
*/