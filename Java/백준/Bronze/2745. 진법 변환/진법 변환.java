import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        br.close();

        int result = 0;
        int temp = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            char c = N.charAt(i);
            if ('A' <= c && c <= 'Z') {
                result += (c - 'A' + 10) * Math.pow(B, temp);
            } else {
                result += (c - '0') * Math.pow(B, temp);
            }
            temp++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}