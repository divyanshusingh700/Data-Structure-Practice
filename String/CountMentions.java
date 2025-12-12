package String;
import java.util.*;
public class CountMentions {
    
class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineTime = new int[numberOfUsers];

        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            return t1 != t2 ? Integer.compare(t1, t2) : b.get(0).compareTo(a.get(0));
        });

        for(List<String> event: events){
            if(event.get(0).equals("MESSAGE")){
                handleMessage(event, mentions, offlineTime);
            }else{
                handleOffline(event, offlineTime);
            }
        }
        return mentions;
    }
    private void handleMessage(List<String> event, int[] mentions, int[] offlineTime) {
        int timestamp = Integer.parseInt(event.get(1));
        String[] tokens = event.get(2).split("\\s+");

        for (String token : tokens) {
            if (token.equals("ALL")) {
                for (int i = 0; i < mentions.length; i++) mentions[i]++;
            } else if (token.equals("HERE")) {
                for (int i = 0; i < mentions.length; i++) {
                    if (offlineTime[i] == 0 || offlineTime[i] + 60 <= timestamp) mentions[i]++;
                }
            } else {
                int id = Integer.parseInt(token.substring(2));
                mentions[id]++;
            }
        }
    }

    private void handleOffline(List<String> event, int[] offlineTime) {
        int timestamp = Integer.parseInt(event.get(1));
        int id = Integer.parseInt(event.get(2));
        offlineTime[id] = timestamp;
    }
    
}