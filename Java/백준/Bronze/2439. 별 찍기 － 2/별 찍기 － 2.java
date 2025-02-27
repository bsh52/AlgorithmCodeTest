import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int j = n - 1;
        for (int i = 1; i <= n; i++) {
            System.out.println(" ".repeat(j) + "*".repeat(i));
            j--;
        }
    }
}