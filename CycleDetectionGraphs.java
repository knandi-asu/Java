import java.util.*;
public class CycleDetectionGraphs {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    
    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int cur, boolean rec[]){
        vis[cur]=true;
        rec[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(rec[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[cur]=false;
        return false;
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }

    public static void main(String[] args){
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        boolean vis[]=new boolean[v];
        boolean rec[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                boolean res=isCycleDirected(graph, vis, 0, rec);
                if(res){
                    System.out.println(res);
                    break;
                }
            }
        }
    }
}
