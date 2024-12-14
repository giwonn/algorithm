function solution(today, terms, privacies) {
    const termMap = terms.reduce((obj, term) => {
        const [str, num] = term.split(' ')
        obj[str] = Number(num) // ex) { 'A' : 6 }
        return obj
    }, {})
    
    return privacies.reduce((arr, privacy, index) => {
        const [date, str] = privacy.split(' ')
        const expireTime = getTime(date) + termMap[str] * 28
        if (expireTime <= getTime(today)) arr.push(index+1)
        return arr
    }, [])
}

function getTime(date) {
    const [year, month, day] = date.split('.').map(Number)
    return year * 12 * 28 + month * 28 + day
}