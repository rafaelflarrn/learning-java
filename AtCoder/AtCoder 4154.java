import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a > 8 || b > 8) {
            System.out.println(":(");
        } else {
            System.out.println("Yay!");
        }
    }
}
