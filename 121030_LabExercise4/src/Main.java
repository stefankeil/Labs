
public class Main {

	static int n = 100;
	static int sum;
	
	public static void main(String[] args) {
//		// Fragment #1
//		for ( int i = 0; i < n; i ++)
//			sum++;
//		    System.out.println(sum);
//		

//		/*// Fragment #2
//		for ( int i = 0; i < n; i ++)
//		    for ( int j = 0; j < n; j ++){
//		        sum++;
//		System.out.println(sum);
//		    }*/
//
//		// Fragment #3
//		for ( int i = 0; i < n; i ++)
//		    for ( int j = i; j < n; j ++){
//		        sum++;
//		System.out.println(sum);}
//
//		//* Fragment #4
//		for ( int i = 0; i < n; i ++){
//		    sum ++;
//		    System.out.println("erste Summe: "+sum);
//		    for ( int j = 0; j < n; j ++){
//		        sum ++;
//		        System.out.println("zweite Summe: "+sum);
//		    }
//		}
//
//		// Fragment #5
//		for ( int i = 0; i < n; i ++){
//		    for ( int j = 0; j < n*n; j ++){
//		    sum++;
//		    System.out.println(sum);
//		    }
//		}
//			
		// Fragment #6
		for ( int i = 0; i < n; i ++){
		    for ( int j = 0; j < i; j ++){
		        sum++;
		        System.out.println(sum);
		    }
		}
////
//		// Fragment #7
//		for ( int i = 1; i < n; i ++){
//		    for ( int j = 0; j < n*n; j ++){
//		        if (j % i == 0)
//		           for (int k = 0; k < j; k++){
//		               sum++;
//		               System.out.println(sum);
//		           }
//		    }
//		}
	}

}
