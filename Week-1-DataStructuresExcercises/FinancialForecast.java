public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double initial, double rate, int years) {
        if (years == 0) return initial;
        return (1 + rate) * futureValue(initial, rate, years - 1);
    }

    // Optimized using memoization (optional)
    public static double futureValueMemo(double initial, double rate, int years, double[] memo) {
        if (years == 0) return initial;
        if (memo[years] != 0) return memo[years];
        return memo[years] = (1 + rate) * futureValueMemo(initial, rate, years - 1, memo);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000;
        double growthRate = 0.08; // 8% annual growth
        int years = 5;

        double future = futureValue(initialInvestment, growthRate, years);
        System.out.println("Recursive Future Value after " + years + " years: " + future);

        double[] memo = new double[years + 1];
        double optimizedFuture = futureValueMemo(initialInvestment, growthRate, years, memo);
        System.out.println("Memoized Future Value after " + years + " years: " + optimizedFuture);

        System.out.println("\nAnalysis:");
        System.out.println("Recursive Time Complexity: O(n)");
        System.out.println("Memoized Time Complexity: O(n), but avoids redundant calls.");
    }
}
