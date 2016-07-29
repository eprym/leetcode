public class Solution {
    public int countComponents(int n, int[][] edges){
        int[] id = new int[n];
        for(int i=0; i<n; i++){
            id[i] = i;
        }
        int i, j = 0;
        for(int[] edg : edges){
           i = find(id, edg[0]); 
           j = find(id, edg[1]);
           if(i != j)   union(id, i, j);
        }
        int count = 0;
        for(int k=0; k<n; k++){
            if(id[k] == k)  count++;
        }
        return count;
    }
    
    private int find(int[] id, int i){
        while(id[i] != i){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    private void union(int[] id, int i, int j){
        int id1 = find(id, i);
        int id2 = find(id, j);
        id[id1] = id2;
    }
