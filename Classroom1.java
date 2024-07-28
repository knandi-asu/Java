import java.util.*;
public class Classroom1{
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));
        
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start){
        //Time complexity - O(V+E)
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);
        while(!q.isEmpty()){
            int cur = q.remove();
            if(vis[cur]==false){
                System.out.print(cur + " ");
                vis[cur]=true;
                for(int i=0;i< graph[cur].size();i++){
                    q.add(graph[cur].get(i).dest);
                }
            }
        }
        System.out.println();

    }

    public static void dfs(ArrayList<Edge> graph[], int cur, boolean vis[]){
        System.out.print(cur + " ");
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e = graph[cur].get(i);
            if(vis[e.dest]==false)
                dfs(graph, e.dest, vis);
        }
    }
    public static void mod_dfs(ArrayList<Edge> graph[],boolean vis[], int cur, int dest, String str){
        if(cur==dest){
            str+=cur;
            System.out.println(str);
            return;
        }
        for(int i=0;i<graph[cur].size();i++){
            Edge e = graph[cur].get(i);
            if(vis[cur]==false){
                vis[cur]=true;
                mod_dfs(graph, vis, e.dest, dest, str+cur);
                vis[cur]=false;
            }
        }
    }

    public static void main(String[] args){
        int v=7;
        ArrayList<Edge> graph[] = new ArrayList[7];
        createGraph(graph);
        boolean vis[] = new boolean[v];
        //print 2's neightbours
        // for(int i=0;i<graph[5].size();i++){
        //     System.out.println(graph[5].get(i).dest);
        // }
        // for(int i=0;i<v;i++){
        //     if(vis[i]==false){
        //         bfs(graph, v, vis, i);
        //     }
        // }
        //We have to follow the same pattern even for dfs inorder to traverse  disconnected graphs
        //dfs(graph, 0, vis);
        mod_dfs(graph,vis, 0, 5, "");
    }
}