import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max = (int) arr[n - 1];

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * 100 / max;
        }
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        bw.write(String.valueOf(sum / n));
        bw.flush();
        bw.close();
        br.close();
    }
}