function solution(number, k) {
    var answer = "";
    let tmp_n = 0;
    let tmp_idx = 0;
    k = number.length - k;

    for (let idx=0; idx<number.length; idx++) {
        // 
        if (k == 0)  {
            break;
        }

        // 현재 인덱스가 저장한값보다 클 때
        if (number[idx] > tmp_n) {
            tmp_n = number[idx];
            tmp_idx = idx;
        }

        // 숫자가 9일 때 or 
        if (number[idx] == 9 || idx === number.length-k) {
            answer += tmp_n;
            tmp_n = 0;
            k--;
            idx = tmp_idx;
        }

    }

    return answer;
}