function solution(records) {
  const nicknameMap = getUserNicknames(records);
  const result = [];

  for (const record of records) {
    if (record.startsWith('Change')) continue

    const [action, userId] = record.split(" ");
    const command = action === 'Enter' ? '들어왔습니다' : '나갔습니다';

    result.push(`${nicknameMap[userId]}님이 ${command}.`);
  }

  return result;
}

function getUserNicknames(records) {
  return records.reduce((obj, record) => {
    if (record.startsWith('Enter') || record.startsWith('Change')) {
      const [_, userId, nickname] = record.split(" ");
      obj[userId] = nickname;
    }
    return obj;
  }, {})
}