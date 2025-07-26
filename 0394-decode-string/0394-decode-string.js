/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    const stack = []
    let num = ''
    let str = ''

    for (const char of s) {
        // 1. '['일 경우
        if (char === '[') {
            // 1-1. 기존에 쌓아둔 num, str을 스택에 push
            stack.push([Number(num), str])
            // 1-2. 두 변수 전부 초기화
            num = ''
            str = ''
        }

        // 2. ']'일 경우 stack을 pop해서 stack에 있던 num, preStr을 이용해서 계산 후 answer에 문자열 추가
        // 여기서 num 변수는 버려지는것처럼 보이는데, 어차피 가장 깊숙하게 중첩된 ']'의 num은 없음. 무조건 문자열만 존재함
        if (char === ']') {
            const [preNum, preStr] = stack.pop()
            str = preStr + str.repeat(preNum)
        }

        // 3. 문자열이 올 경우 str에 추가
        if ('a' <= char && char <= 'z') {
            str += char
        }

        // 4. 숫자가 올 경우 num에 추가
        if ('0' <= char && char <= '9') {
            num += char
        }
    }

    return str
};