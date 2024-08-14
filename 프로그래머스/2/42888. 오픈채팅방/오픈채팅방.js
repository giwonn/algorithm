function solution(records) {
  const nicknameMap = getUserNickname(records)

  return records.map(record => record.split(" "))
    .filter(([action]) => action !== 'Change')
    .map(([action, userId]) => {
      const command = action === 'Enter' ? '들어왔습니다' : '나갔습니다'
      return `${nicknameMap[userId]}님이 ${command}.`
    })
}

function getUserNickname(records) {
  return records.map(record => record.split(" "))
    .filter(([action]) => action !== 'Leave')
    .reduce((obj, [_, userId, nickname]) => {
      obj[userId] = nickname
      return obj
    }, {})
}