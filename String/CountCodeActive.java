package String;

import java.util.*;

public class CountCodeActive {
        public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> res = new ArrayList<>();
        Map<String, Integer> line = Map.of("electronics", 0, "grocery", 1, "pharmacy", 2, "restaurant", 3);
        int n = code.length;
        for(int i = 0; i < n; i++){
            boolean isValid = true;
            if(code[i].length() == 0)isValid = false;
            for(char ch: code[i].toCharArray()){
                if(!( Character.isLetterOrDigit(ch) || ch == '_' )){
                    isValid = false;break;
                }
            }
            isValid = (isValid && isActive[i]);
            isValid = (isValid && line.containsKey(businessLine[i]));
            if(isValid)res.add(new String[]{code[i], String.valueOf(line.get(businessLine[i]))});
        }
        Collections.sort(res, (a, b) -> {
            return a[1].equals(b[1]) ? a[0].compareTo(b[0]) : Integer.compare((a[1].charAt(0) - '0'), (b[1].charAt(0) - '0'));
        });
        List<String> ans = new ArrayList<>();
        int k = 0;
        for(String[] str: res){
            ans.add(str[0]);
        }
        return ans;
    }
}
