import java.math.BigInteger;

public class fuel{
  static int total = 0; 
  static BigInteger one = BigInteger.ONE;
  static BigInteger two = new BigInteger("2");
  static BigInteger zero = new BigInteger("0");
  
  public static int solution(String num){
    BigInteger n = new BigInteger(num);
    int Count = 0;
    while(!n.equals(one)){
      if(!n.testBit(0))n = n.shiftRight(1);
      else{
        BigInteger a = n.add(one);
        BigInteger b = n.subtract(one);
        int aCount = 0;
        int bCount = 0;
        int pos = 0;
        while(!a.testBit(pos++)){
          aCount++;
        }
        pos = 0;
        while(!b.testBit(pos++)){
          bCount++;
        }
        if(aCount>bCount&&!n.equals(new BigInteger("3"))){
          n = n.add(one);
        }else{
          n = n.subtract(one);
        }
      }
      Count++;
    }
    return Count;
  }

}
