function solution(diffs, times, limit) {
    let start = 1
    let end = diffs.reduce((max, diff) => Math.max(max, diff), 0)
    
    while (start < end) {
        const level = Math.floor((start + end) / 2)
        let time = 0
        
        for (let i = 0; i < diffs.length; i++) {
            // 실패했을때의 시간 경과
            if (diffs[i] > level) {
                time += (times[i] + times[i-1]) * (diffs[i] - level)
            }
            // 성공시 시간경과
            time += times[i]
            
            // 경과시간이 리밋을 초과하면 조기종료
            if (time > limit) break
        }
        
        if (time > limit) {
            start = level + 1
        } else {
            end = level
        }
    }
    
    return start
}