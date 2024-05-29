function solution(survey, choices) {
  const category = {
    'R': 0, 'T': 0,
    'C': 1, 'F': 1,
    'J': 2, 'M': 2,
    'A': 3, 'N': 3,
  }
  const defaultCategory = ['R', 'C', 'J', 'A']
  const secondCategory = ['T', 'F', 'M', 'N']

  const scores = choices.reduce((obj, choice, i) => {
    const categories = survey[i].split('')
    const score = defaultCategory.includes(categories[0]) ? 4 - choice : choice - 4
    
    obj[defaultCategory[category[categories[0]]]] ??= 0
    obj[defaultCategory[category[categories[0]]]] += score
    return obj
  }, {})

  const answer = new Array(4).fill(null)
  for (const key in scores) {
    if (defaultCategory.includes(key)) {
      answer[category[key]] = scores[key] >= 0 ? key : secondCategory[category[key]]
    } else {
      answer[category[key]] = scores[key] > 0 ? key : defaultCategory[category[key]]
    }
  }
  
  return answer.map((str, i) => str ?? defaultCategory[i]).join('');
}