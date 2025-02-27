import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        if (M < 45) {
            H = (H == 0) ? 23 : H - 1;
            M = 60 - (45 - M);
        } else {
            M -= 45;
        }

        System.out.println(H + " " + M);
    }
}