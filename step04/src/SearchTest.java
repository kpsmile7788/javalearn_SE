import java.util.Scanner;

public class SearchTest {
	
	public static void main(String[] args) {
		String[] info = {"Jack","Rose","lily","haha"};
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您要查询的词汇：");
		String word = input.next();
		boolean isFind = false;
		
		for(int i = 0 ;i < info.length;i++){
			if(info[i].equals(word)){
				isFind = true;
				break;
			}
		}
		
		if(isFind){
			System.out.println("包含该词！");
		}else{
			System.out.println("不包含该词！");
		}
	}
}
