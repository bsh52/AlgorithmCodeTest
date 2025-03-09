import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            bw.write(s.charAt(0) + "" + s.charAt(s.length() - 1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}