import java.util.*;
class Solution {
    Node[] nodes;
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    public int[][] solution(int[][] nodeinfo) {
        nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        Arrays.sort(nodes);

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        pre(root);
        post(root);

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = pre.stream().mapToInt(i -> i).toArray();
        answer[1] = post.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.l == null) {
                parent.l = child;
            } else {
                insert(parent.l, child);
            }
        } else {
            if (parent.r == null) {
                parent.r = child;
            } else {
                insert(parent.r, child);
            }
        }
    }

    private void pre(Node node) {
        if (node == null) return;
        pre.add(node.val);
        pre(node.l);
        pre(node.r);
    }

    private void post(Node node) {
        if (node == null) return;
        post(node.l);
        post(node.r);
        post.add(node.val);
    }

    static class Node implements Comparable<Node> {
        int x, y, val;
        Node l, r;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
            l = r = null;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y != o.y) {
                return Integer.compare(o.y, this.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }
}