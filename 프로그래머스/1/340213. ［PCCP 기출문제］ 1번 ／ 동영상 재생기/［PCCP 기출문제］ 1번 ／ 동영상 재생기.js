function solution(video_len, pos, op_start, op_end, commands) {
    const videoPlayer = new VideoPlayer(video_len, pos, op_start, op_end)
    commands.forEach(command => videoPlayer.run(command))
    return videoPlayer.pos
}

class VideoPlayer {
    constructor(video_len, pos, op_start, op_end) {
        const toSeconds = (time) => {
            const [minutes, seconds] = time.split(':').map(Number)
            return minutes*60 + seconds
        }
        
        this._video_len = toSeconds(video_len)
        this._pos = toSeconds(pos)
        this._op_start = toSeconds(op_start)
        this._op_end = toSeconds(op_end)
        
        this._skipOpening()
    }
    
    get pos() {
        return this._toTimeString(this._pos)
    }
    
    _toTimeString(seconds) {
        const minute = Math.floor(seconds / 60)
        const second = seconds % 60
        return `${minute < 10 ? 0 : ''}${minute}:${second < 10 ? 0 : ''}${second}`
    }
    
    _skipOpening() {
        if (this._op_start <= this._pos && this._pos <= this._op_end) {
            this._pos = this._op_end
        }
    }
    
    run(command) {
        if (command === 'prev') {
            this._pos -= 10
            if (this._pos < 0) this._pos = 0
        } else if (command === 'next') {
            this._pos += 10
            if (this._pos > this._video_len) this._pos = this._video_len
        }
        
        this._skipOpening()
    }
}