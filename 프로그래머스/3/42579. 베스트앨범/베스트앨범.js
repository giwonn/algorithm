function solution(genres, plays) {    
    const totalDic = plays.reduce((obj, play, i) => {
        obj[genres[i]] ??= 0
        obj[genres[i]] += play
        return obj
    }, {})
    
    bestSellerDic = {}
    
    return genres.map((genre, i) => ({ genre, index: i, play: plays[i] }))
                    .sort((a, b) => {
                        if (a.genre !== b.genre) return totalDic[b.genre] - totalDic[a.genre]
                        if (a.play !== b.play) return b.play - a.play
                        return a.index - b.index
                    })
                    .filter(item => {
                        if (bestSellerDic[item.genre] >= 2) return false;
                        bestSellerDic[item.genre] ??= 0
                        bestSellerDic[item.genre]++;
                        return true;
                    })
                    .map(item => item.index)
    
}