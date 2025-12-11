import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        List<List<int[]>> buildingX = new ArrayList<>(n);
        List<List<int[]>> buildingY = new ArrayList<>(n);
        for(int i = 0; i < n; i++){buildingX.add(new ArrayList<>());buildingY.add(new ArrayList<>());}
        
        for(int i = 0; i < buildings.length; i++){
            buildingX.get(buildings[i][0] - 1).add(buildings[i]);
            buildingY.get(buildings[i][1] - 1).add(buildings[i]);
        }
        Set<String> xCovered = new HashSet<>();
        Set<String> yCovered = new HashSet<>();
        for(int i = 0; i < n; i++){
            List<int[]> liX = buildingX.get(i);
            List<int[]> liY = buildingY.get(i);
            Collections.sort(liY, (a,b) -> Integer.compare(a[0], b[0]));
            Collections.sort(liX, (a,b) -> Integer.compare(a[1], b[1]));
            // (3, 10)
            // (3, 2)
            // (3, 7)
            for(int j = 1; j < liX.size() - 1; j++){
                xCovered.add(liX.get(j)[0] + "#" + liX.get(j)[1]);
            }
            for(int j = 1; j < liY.size() - 1; j++){
                yCovered.add(liY.get(j)[0] + "#" + liY.get(j)[1]);
            }
        }
        int ans = 0;
        for (String key : xCovered) {
            if (yCovered.contains(key)) ans++;
        }
        return ans;
    }
}