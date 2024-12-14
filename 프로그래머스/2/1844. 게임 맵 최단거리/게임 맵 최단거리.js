function solution(maps) {
    const endRow = maps.length - 1;
    const endCol = maps[0].length - 1;
    
    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const visited = maps.map(arr => arr.map(item => !item));
    visited[0][0] = true;
    
    const queue = [[0, 0, 1]];
    while(queue.length > 0) {
        const [row, col, count] = queue.shift();
        
        // 현재 탐색중인 좌표가 목적지라면 count 리턴
        if (row === endRow && col === endCol) return count;
        
        for (const [dRow, dCol] of directions) {
            // 다음에 탐색할 좌표 선언 및 검증
            const nextRow = row + dRow;
            if (nextRow < 0 || nextRow > endRow) continue;
            
            const nextCol = col + dCol;
            if (nextCol < 0 || nextCol > endCol) continue;
            
            // 방문한 좌표면 스킵
            if (visited[nextRow][nextCol]) continue;
            
            visited[nextRow][nextCol] = true;
            queue.push([nextRow, nextCol, count+1]);
        }
    }
    
    return -1;
}