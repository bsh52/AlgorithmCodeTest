import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            if (!s.matches("[a-z]+")) {
                continue;
            }
            list1.add(s);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);
            if (!s.matches("[a-z]+")) {
                continue;
            }
            list2.add(s);
        }
        int size1 = list1.size();
        int size2 = list2.size();

        List<String> sameList = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    sameList.add(list1.get(i));
                    list2.remove(j);
                    break;
                }
            }
        }
        int all = size1 + size2 - sameList.size();
        int same = sameList.size();
        if (all == 0) {
            all = 1;
            same = 1;
        }

        answer = (int) Math.floor(((double) same / all) * 65536);

        return answer;
    }
}