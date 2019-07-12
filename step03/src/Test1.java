import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------");
		System.out.println("请输入年份：");
		int year = input.nextInt();
		System.out.println("请输入月份：");
		int month = input.nextInt();
		int day = 0;
		boolean isError = false;
		
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			case 2:
				if(		(year%4==0&&year%100!=0) ||
						(year%400==0)){
					day = 29;
				}else{
					day =28;
				}
				break;
				
			default:
				System.out.println("输入有误！");
				isError = true;
				break;
		}
		if(!isError){
			System.out.println(year+"年"+month+"月有"+day+"天");
		}
		System.out.println("---------------------");
		
	}
}
