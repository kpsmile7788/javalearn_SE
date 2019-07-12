import java.util.Scanner;

public class Game4PK {

	public static void main(String[] args) {
		
		boolean isStop = false;
		Scanner input = new Scanner(System.in);
		
		while(!isStop){
			System.out.println("----------------------------------------");
			System.out.println("\t\t好戏开演！");
			System.out.println("----------------------------------------");
			System.out.println("");
			System.out.println("");
			
			System.out.println("请输入角色名：");
			String roleName = input.next();
			
			System.out.println("请选择敌人名：1.太原火焰刀 \t 2.八宝寅家枪 \n "
					+ "----------------->付费后可解锁更多角色！");
			int enemyId = input.nextInt();
			
			System.out.println("出拳：(1.石头 2.剪刀 3.布)");
			int myHandId = input.nextInt();
			
			int enemyHandId = (int)(Math.random()*3)+1;
			
			int resId = 3;//0输，1平，2赢
			if(myHandId == enemyHandId){
				resId = 1;
			}else if(
					(myHandId==1&& enemyHandId==2)||
					(myHandId==2&& enemyHandId==3)||
					(myHandId==3&& enemyHandId==1)
					){
				resId = 2;
			}else{
				resId = 0;
			}
			String result = getResultById(resId,roleName,enemyId);
			System.out.println("桌间大战开始！");
			System.out.println("["+roleName+"]PK["+getNameById(enemyId)+"]");
			System.out.println("对决结果为-------->"+result);
			
			System.out.println("退出对决吗？（y/n）:");
			if("Y".equals(input.next().toUpperCase())){
				System.out.println("程序安全退出！");
				isStop = true;
			}
			
		}
	}
	
	public static String getResultById(int id,String roleName,int enemyId){
		int resRandom = (int)(Math.random()*2);
		if(id == 0){
			if(resRandom == 0)
				return roleName+"--->落荒而逃！";
			if(resRandom == 1)
				return getNameById(enemyId)+"大获全胜！";
		}else if(id==1){
			return "无胜无败!";
		}else if(id==2){
			return roleName+"--->凯旋！";
		}
		return null;
	}
	public static String getNameById(int id){
		if(id == 1){
			return "太原火焰刀";
		}else if(id==2){
			return "八宝寅家枪";
		}else{
			return "*****（付费后解锁！）";
		}
	}
	
}
