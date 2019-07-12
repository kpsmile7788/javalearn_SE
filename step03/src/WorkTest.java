import java.util.Scanner;

public class WorkTest {
	
	public static void main(String[] args) {
		
		boolean isExit = false;
		boolean isRegist = false;
		boolean isLogin = false;
		Scanner input = new Scanner(System.in);
		String uname = "";
		int upwd = 0;
		int id = 0;
		
		while(!isExit){
			System.out.println("----------------------------------------------------------");
			System.out.println("欢迎使用本系统,本系统功能有:1.注册 2.登陆 3.抽奖 4.退出系统 。请选择:");
			System.out.println("----------------------------------------------------------");
			int choice = input.nextInt();
			switch(choice){
				case 1:
					System.out.println("请输入账号：");
					uname = input.next();
					System.out.println("请输入密码：");
					upwd = input.nextInt();
					System.out.println("确认您的密码：");
					int comPwd = input.nextInt();
					while(upwd!=comPwd){
						System.out.println("两次密码输入不同，请重新输入密码：");
						upwd = input.nextInt();
						System.out.println("确认您的密码：");
						comPwd = input.nextInt();
					}
					id = (int)(Math.random()*10000);
					System.out.println("注册成功！id为："+id);
					isRegist = true;
					continue;
				case 2:
					if(isRegist){
						for (int i = 0; i < 3; i++) {
							System.out.println("请输入账号：");
							String name = input.next();
							System.out.println("请输入密码：");
							int pwd = input.nextInt();
							if(name.equals(uname)&&pwd==upwd){
								System.out.println("登陆成功！");
								isLogin = true;
								break;
							}else{
								if(i<2){
									System.out.println("账号密码输入有误，您还有"+(2-i)+"次机会！");
									
								}else{
									System.out.println("您的账号已被锁定！");
									
								}
							}
						}
					}else{
						System.out.println("请先注册！");
						continue;
					}
					continue;
					
				case 3:
					if(isLogin){
						int luckNum = (int)(Math.random()*10);
						int myNum = id/100%10;
						if(luckNum==myNum){
							System.out.println("恭喜您中奖了！");
						}else{
							System.out.println("谢谢参与，本期幸运数字为"+luckNum);
						}
					}else{
						System.out.println("请先登陆！");
					}
					continue;
				case 4:
					System.out.println("您已安全退出本系统！");
					isExit = true;
					break;
				default:
					System.out.println("非法输入符号！请重新输入！");
					continue;
			}
		}
	}
}
