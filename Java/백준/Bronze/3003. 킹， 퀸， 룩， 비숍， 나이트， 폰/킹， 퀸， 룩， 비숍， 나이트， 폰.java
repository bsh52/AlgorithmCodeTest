import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        String[] pieces = {"1", "1", "2", "2", "2", "8"};
        br.close();
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            int piece = Integer.parseInt(pieces[i]);
            int result = piece - num;
            bw.write(result + " ");
        }
        bw.flush();
        bw.close();
    }
}