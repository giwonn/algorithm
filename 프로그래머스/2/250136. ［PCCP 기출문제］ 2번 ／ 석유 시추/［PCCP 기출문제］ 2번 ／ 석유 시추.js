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
        
        const oilSum = [...oilSet].reduce((sum, oilNum) => sum + boreHole.oilMap[oilNum], 0)
        max = Math.max(max, oilSum)
    }
    
    return max
}

class BoreHole {

    constructor(land) {
        this.land = land
        this.rowSize = land.length
        this.colSize = land[0].length
        this.dx = [-1, 0, 1, 0];
        this.dy = [0, 1, 0, -1];
        
        this.oilNumInfo = land.map(row => [...row].fill(0)) // 기름 번호 저장
        this.oilMap = new Map() // 기름덩어리에 번호 매겨서 기름 사이즈 저장
        this.oilIndex = 1
    }
    
    scan() {
        for (let row=0; row<this.land.length; row++) {
            for (let col=0; col<this.land[0].length; col++) {
                this.extractOil(row, col)
            }
        }
    }

    extractOil(row, col) {
        const queue = [[row, col]]
        let oil = 0

        while(queue.length > 0) {
            const coord = queue.shift()
            if (this.land[coord[0]][coord[1]] === 0) continue
            if (this.oilNumInfo[coord[0]][coord[1]] !== 0) continue
            
            oil++
            this.oilNumInfo[coord[0]][coord[1]] = this.oilIndex

            for (let i=0; i<4; i++) {
                const nx = coord[0] + this.dx[i]
                const ny = coord[1] + this.dy[i]

                if (nx < 0 || nx >= this.rowSize) continue
                if (ny < 0 || ny >= this.colSize) continue
                if (this.oilNumInfo[nx][ny] !== 0) continue
                
                queue.push([nx, ny])
            }
        }
        
        if (oil > 0) {
            this.oilMap[this.oilIndex++] = oil
        }
        
        return oil
    }
}
