function solution(today, terms, privacies) {
    const termMap = terms.reduce((obj, term) => {
        const [str, num] = term.split(' ')
        obj[str] = Number(num)
        return obj
    }, {})
    
    return privacies.reduce((arr, privacy, index) => {
        const [date, str] = privacy.split(' ')
        const expireDate = getExpireDate(date, termMap[str])
        if (isAfter(today, expireDate)) arr.push(index+1)
        return arr
    }, [])
}

function getExpireDate(date, afterMonth) {
    const [year, month, day] = date.split('.').map(Number)
    
    const calculateMonth = month + afterMonth
    
    let resultDay = day - 1
    
    let resultMonth = calculateMonth % 12
    if (resultDay === 0) resultMonth--
    
    let resultYear = Number(year) + Math.floor(calculateMonth / 12)
    if (resultMonth === 0) resultYear--
    
    if (resultDay === 0) resultDay = 28
    if (resultMonth === 0) resultMonth = 12
    
    resultDay = resultDay < 10 ? `0${resultDay}` : resultDay.toString()
    resultMonth = resultMonth < 10 ? `0${resultMonth}` : resultMonth.toString()
    resultYear = resultYear.toString()
    
    return `${resultYear}.${resultMonth}.${resultDay}`
}

function isAfter(aDate, bDate) {
    const [aYear, aMonth, aDay] = aDate.split('.').map(Number)
    const [bYear, bMonth, bDay] = bDate.split('.').map(Number)
    
    if (aYear < bYear) return false
    if (aYear === bYear && aMonth < bMonth) return false
    if (aYear === bYear && aMonth === bMonth && aDay <= bDay) return false
    
    return true
}