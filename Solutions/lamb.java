public class Solution{
  public static void solution(int n){
    int n = N;
    int m=1;
    int prev=0;
    int maxCount=0;
    while(n>0){
      m+=prev;
      n-=m;
      prev=m-prev;
      maxCount++;
    }

    m=1;
    int minCount = 0;
    n=N;
    while(n>0){
      n-=m;
      minCount++;
      m*=2;
    }
    if(n<0)minCount--;
    return maxCount-minCount;
  }
}
