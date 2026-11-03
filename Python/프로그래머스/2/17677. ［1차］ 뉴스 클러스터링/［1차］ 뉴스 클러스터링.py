import re


def solution(str1, str2):
    str1_sub = []
    str2_sub = []

    for i in range(len(str1) - 1):
        sub = str1.lower()[i : i + 2]
        if re.fullmatch("[a-z]+", sub):
            str1_sub.append(sub)

    for i in range(len(str2) - 1):
        sub = str2.lower()[i : i + 2]
        if re.fullmatch("[a-z]+", sub):
            str2_sub.append(sub)

    intersection = []

    for string in str1_sub:
        if string in str2_sub:
            intersection.append(string)
            str2_sub.remove(string)

    inter_size = len(intersection)
    union_size = len(str1_sub) + len(str2_sub)

    if inter_size == 0 and union_size == 0:
        return 65536

    return int(inter_size / union_size * 65536)