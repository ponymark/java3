import java.io.*;
import java.util.*;
import java.util.Scanner;
class Test3
{
	public static void main(String args[]) throws Exception 
	{
		
		String text=new String("");//Ū�ɼȦs��
		HashMap <String,Integer> hashMap = new HashMap<String,Integer>();//hash��Ƶ��c

		int option=0;
		
		System.out.println("�O�_Ū���W���s��?(1)�O(2)�_\n");
		Scanner op3 = new Scanner(System.in);
		option=op3.nextInt();
		//��ܬO�_Ū���W���ɮשάO���s��J���
		

		if(option==1)
		{//Ū��
			text = fileToText("test.txt");
			System.out.println("Ū�J�U�C���e:");
			System.out.println(text);
			String [] jjj3=text.split("\\n");
			for(String s1:jjj3)
			{
				String [] s2=s1.split("\\:");
				hashMap.put(s2[0],Integer.parseInt(s2[1]));
			}


			//�Ntext���e���hash��
		}
		else if(option==2)
		{//���s��J
			System.out.println("�п�J�y�l\n");		
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
			System.out.println("(1)��J�s�y�l�W�[�r��(2)�d�ߦr�Ŧ���(3)���}�s��\n");
			Scanner op2 = new Scanner(System.in);
			int hhh2=op2.nextInt();
			if(hhh2==1)
			{
				System.out.println("�п�J�s�y�l\n");		
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
				System.out.println("�п�J�r��\n");		
				Scanner op5 = new Scanner(System.in);
				String hhh5=op5.nextLine();
				if(hashMap.get(hhh5)==null)
				{
					System.out.println("�d�L���r��!!!\n");
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
		
		//�g��
		text="";//�O�o�M��!
		for(HashMap.Entry<String,Integer> entry : hashMap.entrySet())//�Nhash��������নtext�榡
		{
			String key = entry.getKey();
    			int value = entry.getValue();
			text+=key+":"+value+"\n";
		}
		textToFile(text, "test.txt", "UTF-8");
		String text2 = fileToText("test.txt");
		System.out.println("���\�g�J�U�C���e:");
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
		FileOutputStream fos = new FileOutputStream(outFile, false);//***********�����W���[�Wfalse�i�H�л\�즳��� ���O�S��
		Writer writer;
		if (pEncode == null)
		{
			writer =new OutputStreamWriter(fos);
			writer.write(pText);
		}
		else
		{//�|���o�q
			writer = new  OutputStreamWriter(fos, pEncode);
			writer.write(pText);
		}
		writer.close();
	}
}