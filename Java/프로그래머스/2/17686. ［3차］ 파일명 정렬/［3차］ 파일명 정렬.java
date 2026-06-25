import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            fileList.add(new File(files[i], i));
        }

        Collections.sort(fileList);

        for (int i = 0; i < files.length; i++) {
            answer[i] = files[fileList.get(i).index];
        }

        return answer;
    }

    class File implements Comparable<File> {
        String name;
        String head;
        int number;
        int index;

        public File(String file, int index) {
            this.name = file;
            this.index = index;

            int min = 0;
            int max = file.length();
            for (int i = 0; i < file.length(); i++) {
                if (Character.isDigit(file.charAt(i))) {
                    min = i;
                    break;
                }
            }

            for (int i = min; i < file.length(); i++) {
                if (!Character.isDigit(file.charAt(i))) {
                    max = i;
                    break;
                }
            }

            this.head = file.substring(0, min).toLowerCase();
            this.number = Integer.parseInt(file.substring(min, max));
        }

        @Override
        public int compareTo(File o) {
            return this.head.equals(o.head) ? Integer.compare(this.number, o.number) : this.head.compareTo(o.head);
        }
    }
}