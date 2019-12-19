package ¼­´Ù¼Ø;

public class ProgTest1 {
	public static int cVar=0;
	String[] iStr = {"0","1","2","3","4","5","6","7","8","9"};
	double iDouble;
	boolean iBool = false;
	char iChar = 'a';
	
	String getGuGudan(int dan) {
		String gugu = dan + "´Ü\n";

		for (int i = 0; i < 9; i++) {       	   
          gugu = gugu + dan + " * " + (i+1) + " = " + (i+1) * dan + "\t";
      }
		return gugu;
		
	}
	
}
