package cinema;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {

	void Schedule(){
		try{
			Scanner schedule = new Scanner(new File("schedule.txt"));
			System.out.println("����������:");
			while(schedule.hasNextLine())
			{
				System.out.println(schedule.nextLine());
			}
		}catch(FileNotFoundException ex){
			System.out.println("���������� �� �������");
		}
	
} 
	 void Bron() throws FileNotFoundException{
		 
				Scanner Booking = new Scanner(new File("Booking.txt"));
				Scanner bb=new Scanner(System.in);
				System.out.println("������� ��� ����� �����");
				String bronn=bb.nextLine();
				boolean t=false;
				while(Booking.hasNext())
				{
					if(Booking.next().equals(bronn))
					{
						System.out.println("���� �����");
						System.out.println(bronn+Booking.nextLine());
						System.out.println();
						t=true;
						
					}
				}
				if(t==false)
					{
					System.out.println("����� ����� ����");
					System.out.println();
					}
				
	 }
	 
	boolean proverkaseansa(String bronnn){
		 boolean t=false;
		try{
	        Scanner schedule = new Scanner(new File("schedule.txt"));
	        while(schedule.hasNextLine())
	        {
	        	if(schedule.nextLine().equals(bronnn))
	        	{
	        		t=true;
	        		break;
	        	}
	        		
	        }
	        if(t==true)
	        return true;
	        else{ 
	         System.out.println("������ ������ � ���������� ����");
	         return false;
	        }
	        }catch(FileNotFoundException ex){
	        	System.out.println("���������� �� �������");
	        	return false;
	        }
	}
     void zapisbronei() throws IOException {
    		Scanner a=new Scanner(System.in);
    		String bronnn;
    		System.out.println("������� ������ ������ �� ������� 22.01 17:00 ���");
    		bronnn=a.nextLine();
    		System.out.println("������� ���������� �������");
			String  bil=a.next();
			System.out.println("������� ���� ���");
		     String FIO=a.next();
    		boolean t=new Main().proverkaseansa(bronnn);
    		if(t==true)
    		{
    			String filePath = "Booking.txt";
    	        String text =FIO+" "+bronnn+" "+bil+"\r\n";

    	        try {
    	            Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
    	        }
    	        catch (IOException e) {
    	            System.out.println(e);
    	        }
    		}
    	
    	
     }
     void delete() throws IOException{
    	 Scanner a=new Scanner(System.in);
    	 Scanner Booking = new Scanner(new File("Booking.txt"));
    	 System.out.println("������� ����  ����");
    	String f=a.nextLine();
		Scanner bb=new Scanner(System.in);
		System.out.println("������� ��� ����� �����");
		String bronn=bb.nextLine();
		
    	int m=f.length();
    	 int i=0;
    	 int n=0;
    	 String contents = readUsingBufferedReader("Booking.txt");
    	StringBuffer ss=new StringBuffer(contents);
    	int h=ss.indexOf(f);
    	 ss.delete(h, h+m+2);
    	 String filePath = "Booking.txt";
	        String text =ss.toString();

	        try {
	            Files.write(Paths.get(filePath), text.getBytes());
	        }
	        catch (IOException e) {
	            System.out.println(e);
	        }
     }
     private static String readUsingBufferedReader(String fileName) throws IOException {
         BufferedReader reader = new BufferedReader( new FileReader (fileName));
         String line = null;
         StringBuilder stringBuilder = new StringBuilder();
         String ls = System.getProperty("line.separator");
         while( ( line = reader.readLine() ) != null ) {
             stringBuilder.append( line );
             stringBuilder.append( ls );
         }
             stringBuilder.deleteCharAt(stringBuilder.length()-1);
             return stringBuilder.toString();
         }
     
	public static void main(String[] args) throws IOException {
		Scanner s=new Scanner(System.in);
		int i;
		do{
			System.out.println("������� 0 ���� ������ ���������� ����������.");
			System.out.println("������� 1 ����� ������������� �����(������).");
			System.out.println("������� 2 ����� ������ ���������� � ����� �����.");
			System.out.println("������� 3 ����� ������� ���� �����.");
			System.out.println("������� 4 ����� ����� �� ���������.");
			i=s.nextInt();
			switch(i){
			case 0: new Main().Schedule( );
				break;
			case 1: new Main().zapisbronei();
				break;
			case 2:new Main().Bron();
				break;
			case 3: new Main().delete();
				break;
			case 4:return;
			
			}
			}while (true);
		
	}

}
