function solution(id_list, report, k) {
    const reportedHistory = report.reduce((arr, cur) => {
        const [id, reportedId] = cur.split(' ')
        arr[id_list.indexOf(reportedId)].add(id)
        return arr
    }, Array.from({length: id_list.length}, () => new Set()))
    .map(set => set.size)
    
    const reportingHistory = report.reduce((obj, cur) => {
        const [id, reportedId] = cur.split(' ')
        obj[id] ??= new Set()
        obj[id].add(reportedId)
        return obj
    }, {})
    
    const lockedIds = id_list.filter((_, i) => reportedHistory[i] && reportedHistory[i] >= k)
    
    return id_list.map((id, i) => reportingHistory[id] ? [...reportingHistory[id]].filter(item => lockedIds.includes(item)).length : 0)
}