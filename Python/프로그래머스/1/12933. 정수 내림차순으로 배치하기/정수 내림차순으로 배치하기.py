def solution(n):
    answer = ""
    n_list = list(str(n))
    n_list.sort(reverse=True)
    for i in n_list:
        answer += i
    return int(answer)