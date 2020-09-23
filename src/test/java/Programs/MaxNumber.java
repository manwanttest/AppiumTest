package Programs;

public class MaxNumber {
	
//	2 4 5
//	0 4 0
//	3 2 9
//	8 7 10
//	
//	2 11 5
//	3 4 7
//	1 0 9
//	
//	2 11 5
//	3 4 7
//	1 2 0

	//static int a[][]= {{2,4,9},{3,4,43},{1,2,0}};
	static int a[][]= {{0,12,5},{3,1,0},{1,0,4},{8,7,10}};
	static int g;
	public static void main(String[] args) {
		System.out.println("Length of a: "+ a.length);	
		 for (int i=0;i<3;i++) 
		{
			 for (int j=0;j<a.length;j++) {
				 
				if (a[j][i]==0) {
					g=a[0][i];
					for (int k=0;k<a.length;k++) 
					{
						if (g<a[k][i]) {
							g=a[k][i];
						}
					}	
					System.out.println("Maximum Number is: "+ g);	
				}
			}	
		}
	}
}
