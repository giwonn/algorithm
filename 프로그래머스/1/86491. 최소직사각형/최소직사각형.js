function solution(sizes) {
    
    sizes.forEach(arr => {
        if (arr[0] < arr[1]) {
            const temp = [...arr][0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        
        return arr;
    });
    
    const w = Math.max(...sizes.map(arr => arr[0]));
    const h = Math.max(...sizes.map(arr => arr[1]));
    
    return w * h;
}