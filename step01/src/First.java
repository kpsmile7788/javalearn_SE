import java.util.Scanner;

public class First {

	public static void main(String[] args) {
		Person p = new Person();

		System.out.println("----------Start------------");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你的名字：");
		p.setName(input.next());
		System.out.println("请输入你的性别：");
		p.setSex(input.next().charAt(0));
		System.out.println("请输入你的年龄：");
		p.setAge(input.nextInt());
		System.out.println("请输入你的身高：");
		p.setHeight(input.nextDouble());
		System.out.println("----------End------------");
		System.out.println(p);
		String a = "aaaaa";
		System.out.println(a.toUpperCase());
	}
}
