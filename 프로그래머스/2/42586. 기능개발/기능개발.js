function solution(progresses, speeds) {
    const arr = []
    
    let day = 1;
    let count = 0;
    while (progresses.length > 0) {
        const progress = progresses[0] + (speeds[0] * day)
        
        if (progress >= 100) {
            progresses.shift();
            speeds.shift();
            count++;
        } else {
            day++;
            if (count > 0) {
                arr.push(count);
                count = 0;
            }
        }
    }
    
    arr.push(count);
    
    return arr;
}