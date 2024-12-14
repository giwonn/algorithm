function solution(numbers, target) {
    return numbers
        .reduce((arr, num) => arr.flatMap((n) => ([n+num, n-num])), [0])
        .filter((number) => number === target)
        .length
}