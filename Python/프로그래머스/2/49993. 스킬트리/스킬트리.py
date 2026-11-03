import re


def solution(skill, skill_trees):
    answer = 0
    for sk in skill_trees:
        s = re.sub("[^" + skill + "]", "", sk)
        if skill.startswith(s):
            answer += 1
    return answer