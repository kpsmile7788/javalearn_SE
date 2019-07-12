public class Test2 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while(i<=5){
			sum += i;
			i++;
		}
		System.out.println("sum--->"+sum);

		sum = 0;
		for(int j = 1;j<=5;j++){
			sum+=j;
		}
		System.out.println("sum--->"+sum);
	}
}
