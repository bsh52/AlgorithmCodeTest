import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            arr.add(i);
        }
        for (int i = 0; i < 28; i++) {
            arr.remove(arr.indexOf(Integer.parseInt(br.readLine())));
        }
        for (int i = 0; i < 2; i++) {
            bw.write(arr.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}