function solution(priorities, location) {
    const arr = priorities.map((item, i) => ({value: item, index: i}))
    
    let count = 0
    while(arr.length > 0) {
        const firstElement = arr.shift()
        
        if (arr.some(item => item.value > firstElement.value)) {
            arr.push(firstElement)
        } else {
            count++;
            if (location === firstElement.index) return count;
        }
    }
}