
public class solution {

    private static String add_str(String s1,String s2){
      while(s1.length()>s2.length())s2 = "0"+s2;
      while(s1.length()<s2.length())s1 = "0"+s1;
      int temp = 0;
      int length = s1.length();
      String ans = "";
      String cur = "";
      for(int i=length-1;i>=0;i--){
        cur = Integer.toString((s1.charAt(i)-'0')+(s2.charAt(i)-'0')+temp);
        if(cur.length()==1)cur = "0"+cur;
        ans = cur.charAt(1) + ans;
        temp = cur.charAt(0) -'0';
      }
      if(cur.charAt(0)!='0')ans = cur.charAt(0)+ans;
      return ans;
    }
    
    private static String multiply(String s1,String s2){
      String ans = "0";
      String prefix = "";
      for(int i=s1.length()-1;i>=0;i--){
        int temp = 0;
        String str = "";
        String cur = "";
        for(int j=s2.length()-1;j>=0;j--){
          cur = add_str(Integer.toString((s1.charAt(i)-'0')*(s2.charAt(j)-'0')),Integer.toString(temp));
          if(cur.length()==1)cur = "0"+cur;
          temp = cur.charAt(0)-'0';
          str = cur.charAt(1)+str;
        }
        if(cur.charAt(0)!='0')str = cur.charAt(0)+str;
        str += prefix;
        ans = add_str(ans,str);
        prefix+="0";
      }
      return ans;
    }
    
    public static String solve(int[] xs) {
      String ans = "1";
      int[] negative = new int[xs.length];
      int pos= 0;
      int ZCount = 0;
      for(int i=0;i<xs.length;i++){
        if(xs[i]>0){ans = multiply(ans,Integer.toString(xs[i]));}
        else if(xs[i]<0)negative[pos++]=(xs[i]*-1);
        else ZCount++;
      }
         if(ZCount==xs.length)return "0";
      if(pos==xs.length&&pos==1)return Integer.toString(xs[0]);
      if(pos+ZCount==xs.length&&ZCount!=0)return "0";
      sort(negative,0,--pos);
      int start = 0;
      if((pos+1)%2==1)start++;
      for(int i=pos;i>=start;i--){ans = multiply(Integer.toString(negative[i]),ans);}
      return ans;
    }
    
    static int partition(int arr[], int lo, int hi) 
    { 
        int pivot = arr[hi];  
        int i = (lo-1);
        for (int j=lo; j<hi; j++) 
        { 
            if (arr[j] < pivot) { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[hi]; 
        arr[hi] = temp; 
  
        return i+1; 
    } 
  
   static void sort(int arr[], int lo, int hi) { 
        if (lo < hi) { 
            int mid = partition(arr, lo, hi); 
            sort(arr, lo, mid-1); 
            sort(arr, mid+1, hi); 
        } 
  }  
}
