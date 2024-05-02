const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

// n: NxN 격자
// m: 파이어볼 개수
// k: K번 이동
const [n, m, k] = input.shift().trim().split(' ').map(Number)

// fireball: [r1(행=y축), c1(열=x축), m(질량), s(속력), d(방향)]
let fireballs = input.map(item => item.trim().split(' ').map(Number).map(item => {
  // 인덱스에 맞추는 작업. (1,1)은 1행 1열이므로 배열에선 (0,0)
  item[0] -= 1
  item[1] -= 1
  return item
}))

// 맵 그리기 (칸마다 여러개의 파이어볼이 들어갈 수 있으므로 배열로 초기화)
const map = Array.from({ length: n }, () => Array.from({ length: n }).map(() => []))

// 인덱스(0 ~ 7방향)별 이동 방향
const dr = [-1, -1, 0, 1, 1, 1, 0, -1]
const dc = [0, 1, 1, 1, 0, -1, -1, -1]

// 파이어볼 이동
const movement = () => {
  fireballs.forEach(([row, col, mass, speed, direction]) => {
    row = row + (speed * dr[direction]) % n
    col = col + (speed * dc[direction]) % n
    
    // n=7, row=7일 경우 실제 인덱스는 row[7]===row[0]이기 때문에 n으로 나눈 나머지를 구하면 됨
    if (row >= n) row %= n
    // n=7, row=-1일 경우 실제 인덱스는 row[-1]===row[6]이기 때문에 n과 row를 더한 결과가 실제 인덱스가 됨
    if (row < 0) row = n + row

    if (col >= n) col %= n
    if (col < 0) col = n + col

    // map에 추가
    map[row][col].push([row, col, mass, speed, direction])
  })
}

// 이동 후 파이어볼 처리
const process = () => {
  const arr = []
    for (let i=0; i<n; i++) {
      for (let j=0; j<n; j++) {
        const sameFireballs = map[i][j]
        if (sameFireballs.length === 0) continue
        if (sameFireballs.length === 1) arr.push(sameFireballs[0])
        if (sameFireballs.length > 1) {
          const [mass, speed] = sameFireballs.reduce((acc, fireball) => {
            acc[0] += fireball[2]
            acc[1] += fireball[3]
            return acc
          }, [0, 0])

          // 2-3. 방향이 모두 홀수이거나 짝수면 [0, 2, 4, 6], 아니면 [1, 3, 5, 7]
          const remainder = sameFireballs[0][4] % 2 // 홀짝여부 미리 계산
          const directions = sameFireballs.every(item => remainder === item[4] % 2) ? [0, 2, 4, 6] : [1, 3, 5, 7]
          
          if (Math.floor(mass / 5) !== 0) {
            const newFireballs = directions.map(direction => [i, j, Math.floor(mass / 5), Math.floor(speed / sameFireballs.length), direction])
            arr.push(...newFireballs)
          }
        }
          
        map[i][j] = []
      }
    }
  fireballs = arr
}

for (let i = 0; i < k; i++) {
  movement()
  process()
}

console.log(fireballs.reduce((sum, cur) => sum + cur[2], 0))
