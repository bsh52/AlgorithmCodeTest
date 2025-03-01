import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());

        if (M + time >= 60) {
            H += (M + time) / 60;
            M = (M + time) % 60;
        } else {
            M += time;
        }

        if (H >= 24) {
            H %= 24;
        }

        System.out.println(H + " " + M);
    }
}