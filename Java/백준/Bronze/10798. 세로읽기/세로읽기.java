import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[][] arr = new String[5][];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().split("");
        }
        br.close();
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length) {
                    bw.write(arr[j][i]);
                }
            }
        }
        
        bw.flush();
        bw.close();
    }
}