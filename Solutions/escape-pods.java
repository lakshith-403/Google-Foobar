public class Solution{

  static int[][] grid;
  static int[] prevNode;
  static Boolean[] visited;
  static int[] flow;
  static int INF = 1000000000;
  static int n;
  
  public static int solution(int[] sources,int[] sinks,int[][] path){
    n = path.length;
    grid = new int[n+2][n+2];
    for(int i=0;i<n;i++)
      for(int j=0;j<n;j++)
        grid[i][j] = path[i][j];
    int src,sink;
    src = n;
    sink = n+1;
    for(int i=0;i<sources.length;i++)grid[src][sources[i]] = INF;
    for(int i=0;i<sinks.length;i++)grid[sinks[i]][sink] = INF;
    n+=2;
    prevNode = new int[n];
    visited = new Boolean[n];
    flow = new int[n];
    return getMaxFLow(src,sink);
  }
  
  static int min(int a,int b){
  if(a<b)return a;
  else return b;
  }
  
  public static int getMaxFLow(int src,int sink){
    if(src==sink)return INF;
    int totalFlow = 0;
    while(true){
      for(int i=0;i<n;i++){
        prevNode[i]=-1;
        flow[i]=0;
        visited[i]=false;
      }
      flow[src]=INF;
      int maxFlow = 0;
      int maxLoc = -1;
      while(true){
        maxFlow = 0;
        maxLoc = -1;
        for(int i=0;i<n;i++){
          if(flow[i]>maxFlow && !visited[i]){
            maxFlow = flow[i];
            maxLoc = i;
          }
        }
        if(maxLoc==sink || maxLoc==-1)break;
        visited[maxLoc]=true;
        for(int i=0;i<n;i++){
          if(maxLoc==i||grid[maxLoc][i]==0)continue;
          if(flow[i]<min(maxFlow,grid[maxLoc][i])){
            prevNode[i] = maxLoc;
            flow[i]=min(maxFlow,grid[maxLoc][i]);
          }
        }
      }
      if(maxLoc==-1)break;
      totalFlow += flow[sink];
      int pathCap = flow[sink];
      int curNode = sink;
      while(curNode!=src){
        int nextNode = prevNode[curNode];
        grid[nextNode][curNode] = grid[nextNode][curNode]-pathCap;
        grid[curNode][nextNode] = grid[curNode][nextNode]+pathCap;
        curNode = nextNode;
      }
    }
    return totalFlow;
  }
}
