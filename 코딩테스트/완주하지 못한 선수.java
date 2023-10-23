import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashSet<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> comMap = new HashMap<>();

        for(int i=0;i<participant.length;i++){
            if(!map.containsKey(participant[i])){
                map.put(participant[i], 1);
                set.add(participant[i]);
            }else{
                map.replace(participant[i], map.get(participant[i])+1);
            }
        }

        for(int i=0;i<completion.length;i++){
            if(!comMap.containsKey(completion[i])){
                comMap.put(completion[i], 1);
            }else{
                comMap.replace(completion[i], comMap.get(completion[i])+1);
            }
        }

        Iterator<String> iter = set.iterator();	// Iterator 사용
        while(iter.hasNext()) {//값이 있으면 true 없으면 false
            String num = iter.next();
            if(comMap.containsKey(num)){
                if(map.get(num)-comMap.get(num) > 0) return num;
            }else
                return num;

        }

        return "";
    }
}