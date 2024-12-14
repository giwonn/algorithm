def solution(brown, yellow):
    answer = []
    width, height = 0, 0

    for i in range(int(yellow**(1/2)), 0, -1):
        width = yellow//i + 2
        height = i + 2
        if width >= height and brown == height*2 + (width-2) * 2:
            answer = [width, height]
            break

    return answer