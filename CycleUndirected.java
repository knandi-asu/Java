import java.util.*;
public class CycleUndirected {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    
    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int cur, int parent){
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(vis[e.dest] && parent!=e.dest){
                return true;
            }else if(!vis[e.dest]){
                if(isCycleUndirected(graph, vis, e.dest, cur)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        //graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        //graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
    }

    public static void main(String[] args){
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        boolean vis[]=new boolean[v];
        System.out.println(isCycleUndirected(graph, vis, 0, -1));
    }
}
