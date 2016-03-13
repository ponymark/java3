import java.util.Scanner;
import java.util.*;
class Test1
{
	public static void main(String[] args)
	{
		String []sss=new String[10000];
		int sss2=0;
		int cou=0;
		System.out.println("\n");		
		Scanner op = new Scanner(System.in);
		String hhh=op.nextLine();
		String [] jjj=hhh.split("\\s|\\,|\\.|\\!|\\?");
		for(String s:jjj)
		{
			if(s.toLowerCase().matches("^[a-zA-Z]*"))
			{
				sss[cou++]=new String(s.toLowerCase());
			}
			else if(s.matches("^[0-9]*"))
			{
				sss2+=Integer.parseInt(s);
			}
		}
		System.out.println("­^¤å:\n");
		for(int v=0;v<cou;v++)
		{
			System.out.println(sss[v]+"\n");
		}
		System.out.println("¼Æ¦r"+sss2+"\n");
	}
}