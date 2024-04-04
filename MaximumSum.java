public class MaximumSum {
    public static void main(String[] args) {
        int[] X = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int[] Y = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };

        int maxSum = findMaxSum(X, Y);
        System.out.println("The maximum sum path is: " + maxSum);
    }

    private static int findMaxSum(int[] X, int[] Y) {
        int sum = 0;
        int sum_x = 0, sum_y = 0;
        int i = 0, j = 0;

        while (i < X.length && j < Y.length) {
            while (i < X.length - 1 && X[i] == X[i + 1]) {
                sum_x += X[i++];
            }
            while (j < Y.length - 1 && Y[j] == Y[j + 1]) {
                sum_y += Y[j++];
            }

            if (Y[j] < X[i]) {
                sum_y += Y[j++];
            } else if (X[i] < Y[j]) {
                sum_x += X[i++];
            } else {
                sum += Math.max(sum_x, sum_y) + X[i];
                i++;
                j++;
                sum_x = 0;
                sum_y = 0;
            }
        }

        while (i < X.length) {
            sum_x += X[i++];
        }
        while (j < Y.length) {
            sum_y += Y[j++];
        }

        sum += Math.max(sum_x, sum_y);
        return sum;
    }
}
