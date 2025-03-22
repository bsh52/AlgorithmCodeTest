import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        br.close();

        int max = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] > max) {
                    max = Math.max(max, arr[i][j]);
                    a = i;
                    b = j;
                }
            }
        }
        bw.write(max + "\n");
        bw.write((a + 1) + " " + (b + 1));
        bw.flush();
        bw.close();
    }
}