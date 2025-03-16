import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                bw.write(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                bw.write("*");
            }
            bw.newLine();
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                bw.write(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                bw.write("*");
            }
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}