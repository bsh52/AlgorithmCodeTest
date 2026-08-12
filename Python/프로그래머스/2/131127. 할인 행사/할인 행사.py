def solution(want, number, discount):
    answer = 0
    size = sum(number)
    want_dict = dict(zip(want, number))
    discount_dict = {}

    for item in discount[:size]:
        discount_dict[item] = discount_dict.get(item, 0) + 1

    if want_dict == discount_dict:
        answer += 1

    for i in range(size, len(discount)):
        new_item = discount[i]
        old_item = discount[i - size]

        discount_dict[new_item] = discount_dict.get(new_item, 0) + 1
        discount_dict[old_item] -= 1

        if discount_dict[old_item] == 0:
            del discount_dict[old_item]

        if want_dict == discount_dict:
            answer += 1

    return answer