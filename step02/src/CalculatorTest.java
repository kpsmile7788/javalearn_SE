import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		
		boolean isStop = false;
		Scanner input = new Scanner(System.in);
		
		System.out.println("----------计算开始------------");
		while(!isStop){
			System.out.println("请输入第一个数：");
			int left = input.nextInt();
			System.out.println("请输入第二个数：");
			int right = input.nextInt();
			if(right==0){
				System.out.println("除数不能为0！请重新输入！");
				continue;
			}
			System.out.println("请输入运算符：");
			char oper = input.next().charAt(0);
			
			int result = 0;
			switch(oper){
				case '+':
					result = left + right;
					break;
				case '-':
					result = left - right;
					break;
				case '*':
					result = left * right;
					break;
				case '/':
					result = left / right;
					break;
				default :
					System.out.println("无此运算符！请重新输入！");
					continue;
			}
			System.out.println(""+left+oper+right+"="+result);
			
			System.out.println("是否停止输入？（y/n）:");
			if("Y".equals(input.next().toUpperCase())){
				System.out.println("程序安全退出！");
				isStop = true;
			}
		}
	}
}
