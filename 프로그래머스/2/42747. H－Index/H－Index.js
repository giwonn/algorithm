function solution(citations) {
    let i = 0;
    // citations.sort((a,b) => b - a).filter(i => .reduce((num, i) => i + num, 0)
    citations.sort((a,b) => b - a)
    while (i+1 <= citations[i]) {
        i++;
    }
    return i;
}