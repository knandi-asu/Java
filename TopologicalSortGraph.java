import java.util.*;
public class TopologicalSortGraph {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    
    public static void topsort(ArrayList<Edge> graph[], boolean vis[], int cur, Stack st){
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.dest]){
                topsort(graph, vis, e.dest, st);
            }
        }
        st.push(cur);
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        //graph[0].add(new Edge(0,2));

        //graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    public static void main(String[] args){
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        boolean vis[]=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topsort(graph, vis, i, st);
            }
        }
        while(!st.empty()){
            System.out.print(st.pop() + "->");
        }
        System.out.println();
    }
}
