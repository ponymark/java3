import java.io.*;
import java.util.*;
import java.util.Scanner;
class Test3
{
	public static void main(String args[]) throws Exception 
	{
		
		String text=new String("");//讀檔暫存器
		HashMap <String,Integer> hashMap = new HashMap<String,Integer>();//hash資料結構

		int option=0;
		
		System.out.println("是否讀取上次存檔?(1)是(2)否\n");
		Scanner op3 = new Scanner(System.in);
		option=op3.nextInt();
		//選擇是否讀取上次檔案或是重新輸入資料
		

		if(option==1)
		{//讀檔
			text = fileToText("test.txt");
			System.out.println("讀入下列內容:");
			System.out.println(text);
			String [] jjj3=text.split("\\n");
			for(String s1:jjj3)
			{
				String [] s2=s1.split("\\:");
				hashMap.put(s2[0],Integer.parseInt(s2[1]));
			}


			//將text內容灌到hash中
		}
		else if(option==2)
		{//重新輸入
			System.out.println("請輸入句子\n");		
			Scanner op = new Scanner(System.in);
			String hhh=op.nextLine();
			String [] jjj=hhh.split("\\s|\\,|\\.|\\!|\\?");
			for(String s:jjj)
			{
				if(s.toLowerCase().matches("^[a-zA-Z]*")&&s.equals("")==false)
				{
					if(hashMap.get(s)==null)
					{
						hashMap.put(s,1);	
					}
					else
					{
						hashMap.put(s,hashMap.get(s)+1);
					}
				}
			}
		}





		while(true)//
		{
			System.out.println("(1)輸入新句子增加字符(2)查詢字符次數(3)離開存檔\n");
			Scanner op2 = new Scanner(System.in);
			int hhh2=op2.nextInt();
			if(hhh2==1)
			{
				System.out.println("請輸入新句子\n");		
				Scanner op4 = new Scanner(System.in);
				String hhh4=op4.nextLine();
				String [] jjj2=hhh4.split("\\s|\\,|\\.|\\!|\\?");
				for(String s:jjj2)
				{
					if(s.toLowerCase().matches("^[a-zA-Z]*")&&s.equals("")==false)
					{
						if(hashMap.get(s)==null)
						{
							hashMap.put(s,1);	
						}
						else
						{
							hashMap.put(s,hashMap.get(s)+1);
						}
					}
				}


			}
			else if(hhh2==2)
			{
				System.out.println("請輸入字符\n");		
				Scanner op5 = new Scanner(System.in);
				String hhh5=op5.nextLine();
				if(hashMap.get(hhh5)==null)
				{
					System.out.println("查無此字符!!!\n");
				}
				else
				{
					System.out.println(hhh5+":"+hashMap.get(hhh5)+"\n");
				}
				
				
			}
			else if(hhh2==3)
			{
				break;
			}
		}
		
		//寫檔
		text="";//記得清空!
		for(HashMap.Entry<String,Integer> entry : hashMap.entrySet())//將hash中的資料轉成text格式
		{
			String key = entry.getKey();
    			int value = entry.getValue();
			text+=key+":"+value+"\n";
		}
		textToFile(text, "test.txt", "UTF-8");
		String text2 = fileToText("test.txt");
		System.out.println("成功寫入下列內容:");
		System.out.println(text2);
	}
	public static String fileToText(String fileName) throws Exception 
	{
		File f = new File(fileName);
		int length = (int)(f.length());
		FileInputStream fin = new FileInputStream(f);
		DataInputStream in = new DataInputStream(fin);
		byte[] bytes = new byte[length];
		in.readFully(bytes);
		return new String(bytes);
	}
	
	public static void textToFile(String pText, String outFile, String pEncode) throws Exception 
	{
		FileOutputStream fos = new FileOutputStream(outFile, false);//***********網路上說加上false可以覆蓋原有資料 但是沒用
		Writer writer;
		if (pEncode == null)
		{
			writer =new OutputStreamWriter(fos);
			writer.write(pText);
		}
		else
		{//會做這段
			writer = new  OutputStreamWriter(fos, pEncode);
			writer.write(pText);
		}
		writer.close();
	}
}