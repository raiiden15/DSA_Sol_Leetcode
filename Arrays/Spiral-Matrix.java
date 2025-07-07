class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        int dir = 0;
        int count = 0;
        
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    answer.add(matrix[top][i]);
                    // count++;
                }
                top++;
            }
            if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    answer.add(matrix[i][right]);
                    // count++;
                }
                right--;
            }
            if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                    // count++;
                }
                bottom--;
            }
            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                    // count++;
                }
                left++;
            }
            dir++;
            if (dir == 4) {
                dir = 0;
            }
        }
        return answer;
    }
}