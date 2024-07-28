import java.util.*;
public class BellmanFord {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int v){
        for(int i=0; i<v; i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        
        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void BellmanFordAlgo(ArrayList<Edge> graph[], int src, int v){
        int dist[]=new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        for(int k=0;k<v-1;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e=graph[i].get(j);
                    if(dist[e.src]!=Integer.MAX_VALUE && dist[e.src]+e.wt < dist[e.dest]){
                        dist[e.dest]= dist[e.src] + e.wt;
                    }
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String[] args){
        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph, v);
        BellmanFordAlgo(graph, 0, v);
    }
}
