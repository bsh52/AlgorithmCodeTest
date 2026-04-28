import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int overTime = fees[2];
        int overFee = fees[3];
        Map<String, Integer> parkMap = new HashMap<>();
        Map<String, Integer> feeMap = new TreeMap<>();

        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String[] timeSplit = recordSplit[0].split(":");
            int time = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            String number = recordSplit[1];
            String type = recordSplit[2];

            if (type.equals("IN")) {
                parkMap.put(number, time);
            } else {
                if (!feeMap.containsKey(number)) {
                    feeMap.put(number, time - parkMap.get(number));
                } else {
                    feeMap.put(number, feeMap.get(number) + time - parkMap.get(number));
                }
                parkMap.remove(number);
            }
        }

        if (!parkMap.isEmpty()) {
            for (String number : parkMap.keySet()) {
                feeMap.put(number, feeMap.getOrDefault(number, 0) + (23 * 60 + 59) - parkMap.get(number));
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : feeMap.entrySet()) {
            if (entry.getValue() <= baseTime) {
                answer.add(baseFee);
            } else {
                answer.add(baseFee + (int) Math.ceil(((double) (entry.getValue() - baseTime) / overTime)) * overFee);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}