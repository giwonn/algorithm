function solution(arr) {
    return arr.filter((item, i) => item !== arr[i+1])
}