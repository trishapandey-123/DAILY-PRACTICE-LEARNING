public class KnapsackDemo {

    // 0/1 Knapsack using Bottom-Up Dynamic Programming (Tabulation)
    // Time Complexity: O(n * capacity), Space Complexity: O(n * capacity)
    public static int solveKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        // dp[i][w] stores maximum value achievable with first 'i' items and capacity 'w'
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int currentWeight = weights[i - 1];
            int currentValue = values[i - 1];

            for (int w = 1; w <= capacity; w++) {
                if (currentWeight <= w) {
                    // Choice 1: Include the current item
                    int includeItem = currentValue + dp[i - 1][w - currentWeight];
                    // Choice 2: Exclude the current item
                    int excludeItem = dp[i - 1][w];

                    dp[i][w] = Math.max(includeItem, excludeItem);
                } else {
                    // Item is too heavy for current capacity 'w', so exclude it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};   // हर आइटम की कीमत/वैल्यू
        int[] weights = {10, 20, 30};    // हर आइटम का वज़न
        int maxCapacity = 50;            // बैग (Knapsack) की अधिकतम क्षमता

        int maxValue = solveKnapsack(weights, values, maxCapacity);

        System.out.println("Maximum value that can be carried: " + maxValue);
    }
}
