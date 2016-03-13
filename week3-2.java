import java.util.Scanner;
import java.util.*;
class Test2
{
	public static void main(String[] args)
	{
		HashMap <String,Integer> hashMap = new HashMap<String,Integer>();
		while(true)
		{
			System.out.println("請輸入學生名稱:\n");
			Scanner op = new Scanner(System.in);
			String h1=op.nextLine();
			System.out.println("請輸入成績:\n");
			Scanner op2 = new Scanner(System.in);
			int h2=op2.nextInt();
			hashMap.put(h1,h2);
			System.out.println("繼續?y or n\n");
			Scanner op3 = new Scanner(System.in);
			String h3=op3.nextLine();
			if(h3.equals("Y")==true||h3.equals("y")==true)
			{
				continue;
			}
			else if(h3.equals("n")==true||h3.equals("N")==true)
			{
				break;
			}
			
		}

		while(true)
		{
			System.out.println("(1)查詢(2)離開\n");
			Scanner op4 = new Scanner(System.in);
			int h4=op4.nextInt();
			if(h4==1)
			{
				System.out.println("輸入學生名字\n");
				Scanner op5 = new Scanner(System.in);
				String h5=op5.nextLine();
				if(hashMap.get(h5)==null)
				{
					System.out.println("學生不存在!!!\n");
				}
				else
				{
					System.out.println(h5+":"+hashMap.get(h5)+"\n");
				}
			}
			else if(h4==2)
			{
				break;
			}
		}
		
	}
}