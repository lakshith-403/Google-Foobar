import java.math.BigInteger;
public class Solution{
  public static String solution(String F, String M){
   BigInteger one = BigInteger.ONE;
   BigInteger zero = new BigInteger("0");
   BigInteger f = new BigInteger(F);
   BigInteger m = new BigInteger(M);
   BigInteger Count = new BigInteger("0");
   while(!f.equals(one)&&!m.equals(one)){
      if(f.mod(m).equals(zero))return "impossible";
      Count = Count.add(f.max(m).divide(f.min(m)));
      BigInteger temp1 = f.max(m).mod(f.min(m));
      BigInteger temp2 = f.min(m);
      f = temp1;
      m = temp2;
   }
   Count = Count.add(f.max(m).subtract(f.min(m)));
    return Count.toString();
  }  
}

/*
  `-.    .-'
     :  :
  --:--:--
   :  :
.-'    `-.  ~LaKsHiTh_
*/
