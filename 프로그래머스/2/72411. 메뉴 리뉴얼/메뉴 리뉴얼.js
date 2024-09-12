function solution(orders, course) {
    const courseMap = {}
    course.forEach(cnt => {
        orders.forEach(food => {
            getCombinations(food.split('').sort(), cnt).map(arr => {
                const f = arr.join('')
                courseMap[f] ??= 0
                courseMap[f]++
            })
        })
    })
    
    const result = []
    
    course.forEach(cnt => {
        const sameCntCourses = Object.entries(courseMap).filter(arr => arr[0].length === cnt && arr[1] > 1)
        const max = Math.max(...sameCntCourses.map(i => i[1]))
        result.push(...sameCntCourses.filter(i => i[1] === max).map(i => i[0]))
    })
    
    
    return result.sort();
}


 function getCombinations(arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map((el) => [el]); 

    arr.forEach((fixed, index, origin) => {
      const rest = origin.slice(index + 1); 
      // 해당하는 fixed를 제외한 나머지 뒤
      const combinations = getCombinations(rest, selectNumber - 1); 
      // 나머지에 대해서 조합을 구한다.
      const attached = combinations.map((el) => [fixed, ...el]); 
      //  돌아온 조합에 떼 놓은(fixed) 값 붙이기
      results.push(...attached); 
      // 배열 spread syntax 로 모두다 push
    });

    return results; // 결과 담긴 results return
}