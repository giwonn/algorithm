function solution(n, computers) {
    let answer = 0;
    const visited = [false]
    
    for (let i=0; i < computers.length; i++) {
        if (visited[i]) continue
        dfs(i, computers, visited)
        answer++
    }
    
    return answer
}

function dfs(i, computers, visited) {
    visited[i] = true;
    for (let j=0; j < computers[i].length; j++) {
        if (visited[j]) continue
        if (computers[i][j] === 0) continue
        dfs(j, computers, visited)
    }
}

