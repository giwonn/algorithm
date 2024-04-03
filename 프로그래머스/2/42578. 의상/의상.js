function solution(clothes) {
    const clothObj = clothes.reduce((obj, [,category]) => {
        obj[category] ??= 0
        obj[category]++
        return obj
    }, {})
    
    return Object.entries(clothObj).reduce((res, [,count]) => res * (count + 1), 1) - 1
    
}