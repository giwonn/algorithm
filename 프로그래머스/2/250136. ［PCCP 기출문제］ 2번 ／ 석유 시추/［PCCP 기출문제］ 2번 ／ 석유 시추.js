function solution(land) {
    const boreHole = new BoreHole(land)
    boreHole.scan()
    
    let max = 0
    
    for (let col=0; col<land[0].length; col++) {
        const oilSet = new Set()
        
        for (let row=0; row<land.length; row++) {
            const oilNum = boreHole.oilNumInfo[row][col]
            if (oilNum !== 0) oilSet.add(oilNum)
        }
        
        const oilSum = [...oilSet].reduce((sum, oilNum) => sum + boreHole.oilMap.get(oilNum), 0)
        max = Math.max(max, oilSum)
    }
    
    return max
}

const dx = [-1, 0, 1, 0];
const dy = [0, 1, 0, -1];

class BoreHole {

    constructor(land) {
        this.land = land
        this.oilNumInfo = land.map(row => [...row].fill(0)) // 기름 번호 저장
        this.oilMap = new Map() // 기름덩어리에 번호 매겨서 기름 사이즈 저장
        this.oilIndex = 1
    }
    
    isExistOil(row, col) {
        return this.land[row][col] === 1 && this.oilNumInfo[row][col] === 0
    }
    
    scan() {
        for (let row = 0; row < this.land.length; row++) {
            for (let col = 0; col < this.land[0].length; col++) {
                if (this.isExistOil(row, col)) {
                    this.extractOil(row, col)
                }
            }
        }
    }

    extractOil(row, col) {
        const queue = [[row, col]]
        let oil = 0
        
        this.oilNumInfo[row][col] = this.oilIndex;
    
        while(queue.length > 0) {
            const [x, y] = queue.shift()
            
            oil++

            for (let i=0; i<4; i++) {
                const nx = x + dx[i]
                const ny = y + dy[i]

                if (nx < 0 || nx >= this.land.length) continue
                if (ny < 0 || ny >= this.land[0].length) continue
                
                if (this.isExistOil(nx, ny)) {
                    queue.push([nx, ny])
                    this.oilNumInfo[nx][ny] = this.oilIndex;
                }
            }
        }
        
        if (oil > 0) {
            this.oilMap.set(this.oilIndex++, oil)
        }
    }
}
