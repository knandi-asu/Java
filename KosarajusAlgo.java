import java.util.*;
public class KosarajusAlgo {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void topsort(ArrayList<Edge> graph[], int cur, boolean vis[], Stack<Integer> st){
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.dest]){
                topsort(graph, e.dest, vis, st);
            }
        }
        st.push(cur);
    }

    public static void dfs(ArrayList<Edge> graph[], int cur, boolean vis[]){
        vis[cur]=true;
        System.out.print(cur + " ");
        for(int i=0;i<graph[cur].size();i++){
            Edge e = graph[cur].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int v){
        //Step 1
        Stack<Integer> st = new Stack<>();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topsort(graph, i, vis, st);

            }
        }

        //Step 2
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for(int i=0;i<v;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<>();
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();i++){
                Edge e=graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step 3
        while(!st.isEmpty()){
            int cur=st.pop();
            if(!vis[cur]){
                dfs(transpose, cur, vis);
                System.out.println();
            }
        }

    }

    public static void createGraph(ArrayList<Edge> graph[], int v){
        for(int i=0; i<v; i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void main(String[] args){
        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph, v);
        kosaraju(graph, v);
    }
}
