def solution(users, emoticons):
    answer = [0, 0]
    selected = [0] * len(emoticons)

    def dfs(depth):
        if depth == len(emoticons):
            subscriber = 0
            total_price = 0

            for user_discount, limit in users:
                total = 0

                for discount, price in zip(selected, emoticons):
                    if (discount + 1) * 10 >= user_discount:
                        total += price * (10 - (discount + 1)) // 10

                if total >= limit:
                    subscriber += 1
                else:
                    total_price += total

            if (subscriber, total_price) > tuple(answer):
                answer[:] = [subscriber, total_price]

            return

        for i in range(4):
            selected[depth] = i
            dfs(depth + 1)

    dfs(0)

    return answer