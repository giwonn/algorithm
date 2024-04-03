const solution = (participant,completion) => {
    const p = participant.reduce((obj, name) => {
        obj[name] ??= 0
        obj[name]++;
        return obj
    }, {})
    
    completion.forEach(name => p[name]--)
    
    for (const name in p) {
        if (p[name] !== 0) return name
    }
};