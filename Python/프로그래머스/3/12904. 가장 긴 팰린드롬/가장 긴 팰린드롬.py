def solution(s):
    def is_palindrome(sub):
        reverse = sub[::-1]
        return sub == reverse

    answer = 0

    for i in range(len(s), 0, -1):
        j = 0
        while j + i <= len(s):
            sub = s[j : j + i]
            if is_palindrome(sub):
                return len(sub)
            j += 1

    return answer