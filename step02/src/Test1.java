import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		boolean isStop = false;
		
		while(!isStop){
			
			Scanner input = new Scanner(System.in);
			System.out.println("请输入你的积分：");
			int i = input.nextInt();

			if(i>1000000){
				System.out.println("爸爸，您是最棒的！送您一台电饭煲+刀具一套！");
			}else if(i>5000){
				System.out.println("恭喜您获得纯棉四件套！");
			}else if(i>3000){
				System.out.println("恭喜您获得电动牙刷一只！");
			}else if(i>1000){
				System.out.println("恭喜您获得维达纸抽一袋！");
			}else if(i>500){
				System.out.println("恭喜您获得洗发水一瓶！");
			}else if(i>0){
				System.out.println("您的积分不足！谢谢参与！");
			}else{
				System.out.println("积分录入有误，请找客服核实");
			}
			
			System.out.println("是否停止输入？（y/n）:");
			if("Y".equals(input.next().toUpperCase())){
				System.out.println("程序安全退出！");
				isStop = true;
			}
		}

	}
}
