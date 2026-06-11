import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node cur = init(n, k);
        Deque<Node> stack = new ArrayDeque<>();
        for (String s : cmd) {
            String[] split = s.split(" ");
            String action = split[0];

            switch (action) {
                case "D" -> {
                    int num = Integer.parseInt(split[1]);
                    cur = down(cur, num);
                }
                case "U" -> {
                    int num = Integer.parseInt(split[1]);
                    cur = up(cur, num);
                }
                case "C" -> {
                    stack.push(cur);
                    cur = delete(cur);
                }
                case "Z" -> {
                    Node restore = stack.pop();
                    restore(restore);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.repeat("O", n);
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop().value, 'X');
        }
        return sb.toString();
    }

    class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    Node init(int count, int cursor) {
        Node first = new Node(0);
        Node prev = first;
        for (int i = 1; i < count - 1; i++) {
            Node node = new Node(i);
            prev.next = node;
            node.prev = prev;
            prev = node;
        }
        Node last = new Node(count - 1);
        prev.next = last;
        last.prev = prev;

        Node cur = first;
        for (int i = 0; i < cursor; i++) {
            cur = cur.next;
        }
        return cur;
    }

    Node up(Node node, int count) {
        for (int i = 0; i < count; i++) {
            node = node.prev;
        }
        return node;
    }

    Node down(Node node, int count) {
        for (int i = 0; i < count; i++) {
            node = node.next;
        }
        return node;
    }

    Node delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.next == null ? node.prev : node.next;
    }

    void restore(Node node) {
        if (node.prev != null) {
            node.prev.next = node;
        }
        if (node.next != null) {
            node.next.prev = node;
        }
    }
}