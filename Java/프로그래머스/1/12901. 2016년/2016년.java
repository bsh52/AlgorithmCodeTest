import java.time.*;

class Solution {
    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        int dateValue = date.getDayOfWeek().getValue() % 7;
        String answer = switch (dateValue) {
            case 0 -> "SUN";
            case 1 -> "MON";
            case 2 -> "TUE";
            case 3 -> "WED";
            case 4 -> "THU";
            case 5 -> "FRI";
            case 6 -> "SAT";
            default -> throw new IllegalStateException("Unexpected value: " + dateValue);
        };
        return answer;
    }
}