import java.util.*;
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        List<Integer>[] list = new ArrayList[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < user_id.length; i++) {
            String user = user_id[i];
            for (int j = 0; j < banned_id.length; j++) {
                String ban = banned_id[j];
                if (isMatch(user, ban)) {
                    list[j].add(i);
                }
            }
        }

        Set<Set<Integer>> set = new HashSet<>();
        dfs(0, list, set, new HashSet<>());

        return set.size();
    }

    private void dfs(int depth, List<Integer>[] list, Set<Set<Integer>> set, Set<Integer> tmp) {
        if (depth == list.length) {
            set.add(new HashSet<>(tmp));
            return;
        }

        for (int user : list[depth]) {
            if (tmp.contains(user)) continue;
            tmp.add(user);
            dfs(depth + 1, list, set, tmp);
            tmp.remove(user);
        }
    }

    private boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (user.charAt(i) != ban.charAt(i) && ban.charAt(i) != '*') return false;
        }

        return true;
    }
}