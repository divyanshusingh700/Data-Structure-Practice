import java.util.*;

class CourseSchedule2TopoBFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] course : prerequisites) {
            int prereq = course[1];
            int co = course[0];
            adj.get(prereq).add(co);
        }

        int[] indegree = new int[numCourses]; // number of incoming edges for node 
        int cnt = 0;
        for(int i = 0; i < numCourses; i++){
            for(int v: adj.get(i)){
                indegree[v]++;
            }
        }
        // we will first push out all those nodes which have indegree 0
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                cnt++;
                q.offer(i);
            }
        }

        int res[] = new int[numCourses];
        int k = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            res[k++] = u;
            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    cnt++;
                    q.offer(v);
                }
            }
        }
        return cnt == numCourses?res:new int[0];
    }



}
