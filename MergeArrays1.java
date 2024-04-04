public class MergeArrays1 {
    public static void main(String[] args) {
        int[] X = { 0, 4, 0, 6, 0, 8, 10, 0, 0 };
        int[] Y = { 2, 5, 7, 9, 12 };

        // Merge Y[] into X[]
        rearrange(X, Y);

        // Print the merged array
        for (int num : X) {
            System.out.print(num + " ");
        }
    }

    // Function to merge `X[0…m]` and `Y[0…n]` into `X[0…m+n+1]`
    private static void merge(int[] X, int[] Y, int m, int n) {
        int k = m + n + 1;

        // Merge elements from the end
        while (m >= 0 && n >= 0) {
            if (X[m] > Y[n]) {
                X[k--] = X[m--];
            } else {
                X[k--] = Y[n--];
            }
        }

        // Copy remaining elements of `Y[]` (if any) to `X[]`
        while (n >= 0) {
            X[k--] = Y[n--];
        }
    }

    // Move non-empty elements in `X[]` to the beginning and then merge with `Y[]`
    private static void rearrange(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        // Move non-empty elements of `X[]` to the beginning
        int k = 0;
        for (int i = 0; i < m; i++) {
            if (X[i] != 0) {
                X[k++] = X[i];
            }
        }

        // Merge `X[0 … k-1]` and `Y[0 … n-1]` into `X[0 … m-1]`
        merge(X, Y, k - 1, n - 1);
    }
}
