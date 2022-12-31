package lecture;
import java.util.*;

public class BestAlbum {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int size = genres.length;
        Map<String,List<Music>> musicMap = new HashMap<>();
        Map<String,Total> totalMap = new HashMap<>();
        List<Total> totalList = new ArrayList<>();

        for(int i = 0; i < size; i++){
            int value = plays[i];
            String type = genres[i];
            Music music = new Music(i,value);

            if(!musicMap.containsKey(type)){
                List<Music> list = new ArrayList<>();
                list.add(music);
                musicMap.put(type,list);
                totalMap.put(type,new Total(value,type));
            }else{
                musicMap.get(type).add(music);
                totalMap.get(type).value += value;
            }
        }

        for(String str : totalMap.keySet()){
            totalList.add(totalMap.get(str));
        }

        Collections.sort(totalList);
        int listSize = totalList.size();

        for(int i = 0; i < listSize; i++){
            List<Music> musicList = musicMap.get(totalList.get(i).type);
            Collections.sort(musicList);
            if(musicList.size() == 1) answer.add(musicList.get(0).idx);
            else {
                answer.add(musicList.get(0).idx);
                answer.add(musicList.get(1).idx);
            }
        }




        return answer;
    }

    static class Total implements Comparable<Total>{
        public Total(int value,String type){
            this.value = value;
            this.type = type;
        }
        int value;
        String type;

        @Override
        public int compareTo(Total o) {
            return o.value - this.value;
        }

    }

    static class Music implements Comparable<Music>{
        public Music(int idx, int size){
            this.idx = idx;
            this.size = size;
        }

        int size;
        int idx;


        @Override
        public int compareTo(Music o) {
            if(o.size == this.size) return this.idx - o.idx;
            else return o.size - this.size;
        }
    }
}
