import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = new String[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = String.valueOf((char) ('a' + i));
        }

        String s = br.readLine();
        for (int i = 0; i < arr.length; i++) {
            if (s.contains(arr[i])) {
                arr[i] = String.valueOf(s.indexOf(arr[i]));
            } else {
                arr[i] = "-1";
            }
        }
        bw.write(String.join(" ", arr));
        bw.flush();
        bw.close();
        br.close();
    }
}