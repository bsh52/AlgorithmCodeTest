import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double sum = 0;
        double all = 0;
        for (int i = 0; i < 20; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            double point = Double.parseDouble(arr[1]);
            String grade = arr[2];

            if (grade.equals("P")) {
                continue;
            }

            double gradePoint = getGradePoint(grade);
            sum += point * gradePoint;
            all += point;
        }
        br.close();
        bw.write(String.format("%.6f", sum / all));
        bw.flush();
        bw.close();
    }

    static double getGradePoint(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }
}