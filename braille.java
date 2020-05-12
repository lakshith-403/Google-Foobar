public class solution{

  static String[] alph = {"100000","110000","100100","100110","100010","110100","110110","110010","010100","010110","101000","111000","101100","101110","101010","111100","111110","111010","011100","011110","101001","111001","010111","101101","101111","101011","000000","000001"}; 
  
  public static String solve(String s) {
    	String str = "";
    	for(int i=0;i<s.length();i++){
	        char cur = s.charAt(i);
            if(cur==' '){str+=alph[26];continue;}
            if(Character.isUpperCase(cur)){
                str+=alph[27];
                cur = Character.toLowerCase(cur);
            }
            str+=alph[cur-'a'];
        }
        return str;
    }
  
}

/*
  `-.    .-'
     :  :
  --:--:--
   :  :
.-'    `-.  ~LaKsHiTh_
*/
