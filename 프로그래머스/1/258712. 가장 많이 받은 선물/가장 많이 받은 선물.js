// * 선물 지수 = 준 선물 - 받은 선물
// 선물 받는 기준
// 1. 서로에게 선물 횟수가 더 많은 사람
// 2. 서로 선물횟수가 없거나 같다면 선물 지수가 더 높은 사람
// 3. 선물 지수 조차 같다면 다음달에 주고받지 않음 (종결)
function solution(friends, gifts) {
    const friendCount = friends.length
    const giftScore = new Array(friendCount).fill(0)
    
    // friend의 인덱스 위치 캐싱
    const friendIndex = friends.reduce((acc, item, index) => {
        acc[item] = index
        return acc
    }, {})
    
    // 서로 주고받은 횟수 count
    const giveAndTakeCount = friends.reduce((obj, friend) => {
        obj[friend] = new Array(friendCount).fill(0)
        return obj
    }, {})
    
    gifts.forEach(gift => {
        const [from, to] = gift.split(' ')
        
        // 주고받은 선물 count
        giveAndTakeCount[to][friendIndex[from]]--
        giveAndTakeCount[from][friendIndex[to]]++
        
        // 선물 지수 count
        giftScore[friendIndex[from]]++
        giftScore[friendIndex[to]]--
    })
    
    const nextMonthCount = friends.map((friend, fromIndex) => {
        return giveAndTakeCount[friend].reduce((acc, count, toIndex) => {
            if (friendIndex[friend] === toIndex) return acc // 자신은 제외
            if (count < 0) return acc // count가 음수면 선물을 줘야하는 입장이므로 제외
            if (count > 0 || giftScore[fromIndex] > giftScore[toIndex]) acc++
            return acc
        }, 0)
    })
    
    return Math.max(...nextMonthCount)
}