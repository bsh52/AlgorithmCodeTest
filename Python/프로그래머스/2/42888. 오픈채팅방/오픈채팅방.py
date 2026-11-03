def solution(record):
    answer = []
    d = {}

    for s in record:
        action, id, *name = s.split(" ")

        if action != "Leave":
            d[id] = name[0]

    for s in record:
        action, id, *name = s.split(" ")

        if action == "Enter":
            answer.append(f"{d[id]}님이 들어왔습니다.")
        elif action == "Leave":
            answer.append(f"{d[id]}님이 나갔습니다.")

    return answer