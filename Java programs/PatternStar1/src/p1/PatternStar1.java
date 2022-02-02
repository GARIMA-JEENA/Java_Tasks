
package p1;
import java.util.*;
public class PatternStar1 {
		public static void main(String[] args)   
			{  
				int n=0;
			
				System.out.println("ENTER ANY NUMBER");
			try (Scanner s1 = new Scanner(System.in)) {
				n=s1.nextInt();
				}
			      for(int i=0;i<n;i++)
			      {
			          for(int k=0;k<n-i;k++)
			          {
			            System.out.print("  ");
			          }
			          for(int j=0;j<n;j++)
			          {
			            System.out.print("*  ");
			          }
			          System.out.println();
		}
	 }
	}