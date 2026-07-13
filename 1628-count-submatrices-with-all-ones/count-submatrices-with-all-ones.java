class Solution {
    public int numSubmat(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] height = new int[cols];
        int answer = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0)
                    height[j] = 0;
                else
                    height[j]++;
            }

            answer += countHistogram(height);
        }

        return answer;
    }

    private int countHistogram(int[] height) {

        int n = height.length;

        int[] stack = new int[n];
        int top = -1;

        int[] sum = new int[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            while (top >= 0 && height[stack[top]] >= height[i]) {
                top--;
            }

            if (top == -1) {
                sum[i] = height[i] * (i + 1);
            } else {
                int prev = stack[top];
                sum[i] = sum[prev] + height[i] * (i - prev);
            }

            stack[++top] = i;
            ans += sum[i];
        }

        return ans;
    }
}