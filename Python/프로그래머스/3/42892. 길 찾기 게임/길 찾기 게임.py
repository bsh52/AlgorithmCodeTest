import sys

sys.setrecursionlimit(10**6)


def solution(nodeinfo):
    nodeinfo = [[i + 1] + node for i, node in enumerate(nodeinfo)]
    nodeinfo.sort(key=lambda x: (-x[2], x[1]))

    answer = [[], []]
    node_sort(nodeinfo[0], nodeinfo, answer[0], answer[1])
    return answer


def node_sort(node, subtree, answer1, answer2):
    answer1.append(node[0])

    left_tree = [
        _node for _node in subtree if _node[1] < node[1] and _node[2] < node[2]
    ]
    right_tree = [
        _node for _node in subtree if _node[1] > node[1] and _node[2] < node[2]
    ]

    if left_tree != []:
        node_sort(left_tree[0], left_tree, answer1, answer2)
    if right_tree != []:
        node_sort(right_tree[0], right_tree, answer1, answer2)

    answer2.append(node[0])