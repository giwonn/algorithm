function solution(m, musicinfos) {
    const result = ['(None)', 0]
    
    for (const musicInfo of musicinfos) {
        const [start, end, name, melody] = musicInfo.split(',')

        const lowerMelody = getLowerMelody(melody)
        const playingTime = getPlayingTime(start, end)
        
        const entireMelody = []
        for (let i=0; i<playingTime; i++) {
            entireMelody.push(lowerMelody[i % lowerMelody.length])
        }
             
        // 기억한 멜로디가 방송된 멜로디에 없으면 패스
        if (!entireMelody.join('').includes(getLowerMelody(m))) continue
        // 현재 탐색중인 방송이 정답후보보다 방송시간이 짧으면 패스
        if (playingTime <= result[1]) continue
        
        result[0] = name
        result[1] = playingTime
    }
    
    return result[0];
}

function getLowerMelody(melody) {
    const arr = []
    for (let i=0; i<melody.length; i++) {
        if (melody[i+1] === '#') {
            arr.push(melody[i].toLowerCase())
            i++
        } else {
            arr.push(melody[i])
        }
    }
    return arr.join('')
}

function getPlayingTime(start, end) {
    const [startHour, startMinute] = start.split(':').map(Number)
    const startTime = startHour*60 + startMinute
    
    const [endHour, endMinute] = end.split(':').map(Number)
    const endTime = endHour*60 + endMinute
    
    return endTime - startTime
}