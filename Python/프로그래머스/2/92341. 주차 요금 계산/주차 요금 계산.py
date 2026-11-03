import math


def solution(fees, records):
    base_time, base_fee, over_time, over_fee = fees
    park_d = {}
    fee_d = {}

    for record in records:
        record_split = record.split(" ")
        time_split = record_split[0].split(":")
        time = int(time_split[0]) * 60 + int(time_split[1])
        number = record_split[1]
        type = record_split[2]

        if type == "IN":
            park_d[number] = time
        else:
            if number not in fee_d:
                fee_d[number] = time - park_d[number]
            else:
                fee_d[number] = fee_d.get(number) + time - park_d.get(number)
            del park_d[number]

    if park_d:
        for number in park_d:
            fee_d[number] = fee_d.get(number, 0) + (23 * 60 + 59) - park_d[number]

    answer = []

    for key, val in sorted(fee_d.items()):
        if val <= base_time:
            answer.append(base_fee)
        else:
            answer.append(
                base_fee + math.ceil((val - base_time) / over_time) * over_fee
            )

    return answer