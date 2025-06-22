import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinancialForecasting {
    public static double calculateFutureValueRecursive(double pv, double r, int n) {
        if (n == 0) {
            return pv;
        }
        return calculateFutureValueRecursive(pv, r, n - 1) * (1 + r);
    }

    public static double calculateFutureValueRecursiveMemo(double pv, double r, int n, Map<Integer, Double> memo) {
        if (n == 0) {
            return pv;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        double result = calculateFutureValueRecursiveMemo(pv, r, n - 1, memo) * (1 + r);
        memo.put(n, result);
        return result;
    }

    public static BigDecimal calculateFutureValueIterativeBD(BigDecimal pv, BigDecimal r, int n) {
        BigDecimal result = pv;
        for (int i = 0; i < n; i++) {
            result = result.multiply(BigDecimal.ONE.add(r));
        }
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        double pv = 1000;
        double r = 0.05;
        int n = 5;
        double fvRecursive = calculateFutureValueRecursive(pv, r, n);
        System.out.println("Future value (recursive): " + String.format("%.2f", fvRecursive));
        double fvRecursiveMemo = calculateFutureValueRecursiveMemo(pv, r, n, new HashMap<>());
        System.out.println("Future value (recursive with memoization): " + String.format("%.2f", fvRecursiveMemo));
        BigDecimal bdPv = new BigDecimal(pv);
        BigDecimal bdR = new BigDecimal(r);
        BigDecimal fvIterativeBD = calculateFutureValueIterativeBD(bdPv, bdR, n);
        System.out.println("Future value (iterative with BigDecimal): " + fvIterativeBD);
    }
}