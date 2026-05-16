import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        String target = phone_book[0];

        for (int i = 1; i < phone_book.length; i++) {
            if (target.charAt(0) == phone_book[i].charAt(0)) {
                if (phone_book[i].startsWith(target)) {
                    answer = false;
                    break;
                }
            }
            target = phone_book[i];
        }

        return answer;
    }
}