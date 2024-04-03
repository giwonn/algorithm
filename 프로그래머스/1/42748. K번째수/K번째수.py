def solution(array, commands):
    answer = []
    
    for cmd in commands:
        i = cmd[0] - 1  # i=2일 때 필요한 인덱스는 1
        j = cmd[1]      # j=5일 때 필요한 인덱스는 5
        k = cmd[2] - 1  # k=3일 때 필요한 인덱스는 2
        tmp = sorted(array[i:j])  # array[1:5] (인덱스 1부터 인덱스 4까지)
        answer.append(tmp[k])
    
    return answer