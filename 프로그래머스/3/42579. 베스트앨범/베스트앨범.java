import java.util.*;
import java.util.stream.*;


class Music implements Comparable<Music> {
    final int id;
    final int played;
    final String genre;
    
    private Music(int id, String genre, int played) {
        this.id = id;
        this.genre = genre;
        this.played = played;
    }
    
    public static Music of(int id, String genre, int played) {
        return new Music(id, genre, played);
    }
    
    public int getPlayed() {
        return this.played;
    }
    
    @Override
    public int compareTo(Music other) {
        if (this.played == other.played) return this.id - other.id;
        return other.played - this.played;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 -> 노래 -> 고유번호 낮은 순
        // 인덱스 i = 노래번호
        Map<String, List<Music>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            List<Music> list = map.getOrDefault(
                genres[i],
                new ArrayList<Music>()
            );
            list.add(Music.of(i, genres[i], plays[i]));
            
            map.put(genres[i], list);
        }
        
        List<List<Music>> list = map.values().stream()
            .collect(Collectors.toList());
        
        list.sort(
            (a, b) -> b.stream().mapToInt(Music::getPlayed).sum() - a.stream().mapToInt(Music::getPlayed).sum()
        );
        
        
        List<Integer> answer = new ArrayList<>();
        for (List<Music> musics : list) {
            musics.sort((a, b) -> a.compareTo(b));
            
            for (int i = 0; i < musics.size(); i++) {
                if (i > 1) break;
                answer.add(musics.get(i).id);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}