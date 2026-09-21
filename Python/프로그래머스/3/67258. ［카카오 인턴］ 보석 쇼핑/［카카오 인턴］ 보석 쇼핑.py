def solution(gems):
    answer = [0, len(gems)]
    size = len(set(gems))
    s = 0
    d = {}
    
    for e in range(len(gems)):
        gem = gems[e]
        d[gem] = d.get(gem, 0) + 1
        
        while size == len(d):
            if e - s < answer[1] - answer[0]:
                answer = [s, e]
            
            left_gem = gems[s]
            d[left_gem] -= 1
            if d[left_gem] == 0:
                del d[left_gem]
            
            s+=1
    
    return [answer[0] + 1, answer[1] + 1]