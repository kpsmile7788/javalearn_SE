import java.util.Scanner;

public class DeleteTest {
	
	public static void main(String[] args) {

		String[] info = {"Jack","Rose","lily","haha"};
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您要删除的词汇：");
		String word = input.next();
		int index = -1;
		
		for(int i = 0 ;i < info.length;i++){
			if(info[i].equals(word)){
				index = i;
				break;
			}
		}
		
		if(index != -1){
			for(int i = index;i<info.length-1;i++){
				info[i]= info[i+1];
			}
			info[info.length-1] = null;
			System.out.println("删除成功！");
			System.out.print("目前该数组元素为：");
			for(int i = 0; i<info.length;i++){
				System.out.print(info[i]+"\t");
			}
		}else{
			System.out.println("无此元素！");
		}
	}
}
