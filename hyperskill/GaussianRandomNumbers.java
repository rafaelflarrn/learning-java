import java.util.*;

public class Main {
    public static int gausNum(int k, int n, double m) {
        double num = Double.MAX_VALUE;
        int seed = k;

        while (true) {
            Random random = new Random(seed);
            for (int i = 0; i < n; i++) {
                num = random.nextGaussian();
                if (num >= m) {
                    break;
                }
                if (i == n - 1) {
                    return seed;
                }
            }
            seed++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();

        System.out.println(gausNum(k, n, m));

    }
}

