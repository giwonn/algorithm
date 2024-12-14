function solution(dartResult) {
    const bonuses = ['S', 'D', 'T']
    
    const arr = []
    for (let i = 0; i < dartResult.length; i++) {
        // 점수 파싱
        if (!Number.isNaN(Number(dartResult[i]))) {
            if (!Number.isNaN(Number(dartResult[i+1]))) {
                arr.push(Number(dartResult.slice(i, i+2)))
                i++
            } else {
                arr.push(Number(dartResult[i]))
            }
            continue
        }
        
        // 보너스 파싱
        const bonus = bonuses.indexOf(dartResult[i])
        if (bonus !== -1) {
            arr.push(arr.pop() ** (bonus+1))
            continue
        }
        
        // 옵션 * 파싱
        if (dartResult[i] === '*') {
            const lastNum = arr.pop() * 2
            if (arr.length > 0) arr.push(arr.pop() * 2)
            arr.push(lastNum)
            continue
        }
        
        // 옵션 # 파싱
        if (dartResult[i] === '#') {
            arr.push(-arr.pop())
            continue
        }
    }
    
    return arr.reduce((sum, cur) => sum + cur, 0);
}
