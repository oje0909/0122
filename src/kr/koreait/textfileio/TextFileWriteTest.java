package kr.koreait.textfileio;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileWriteTest {
	
	public static void main(String[] args) {
		
		Scanner scanner = null;			//텍스트 파일로 저장할 데이터를 입력받는 Scanner
		PrintWriter printWriter = null;	//텍스트 파일에 데이터를 저장하는  PrintWriter		
				
//		출력 파일의 경로와 이름을 설정한다.
//		경로 지정 방식은 절대 경로 지정 방식과 상대 경로 지정 방식이 있다.
//		절대 경로는 파일이 위치한 디스크 드라이브의 최상위(root) 디렉토리(폴더)부터 파일이 위치한 디렉토리 까지의 경로를 의미한다.
//		상대 경로는 현재 작업중인 파일이 포함된 프로젝트 이름의 폴더(".")부터 파일이 위치한 디렉토리 까지의 경로를 의미한다.
//		python이나 c/c++의 "."은 화면에 열려있는 파일이 위치한 디렉토리를 의미하지만 java에서 "."은 현재 작업중인 파일이 포함된 프로젝트
//		이름의 디렉토리를 의미한다.
//		경로 지정시 경로와 경로 또는 경로와 파일을 구분하는 "\"는 연달아 2개를 써야 하나로 인식되며 "\\"를 "/"로 대체해서 사용할 수 있다.
		
//		String filename = "C:\\JAVA_090_LHY\\workspace\\0122\\src\\kr\\koreait\\textfileio\\out.txt";		//절대 경로
//		String filename = "C:/JAVA_090_LHY/workspace/0122/src/kr/koreait/textfileio/out.txt";		//절대 경로
		String filename = "./src/kr/koreait/textfileio/out.txt";		//절대 경로
		
		try {
//			printWriter 클래스 객체를 생성해서 출력으로 사용할 파일을 
			printWriter = new PrintWriter(filename);
			scanner = new Scanner(System.in);
			
//			"QUIT"가 입력될 때 까지 반복하며 키보드로 입력받은 데이터를 파일로 출력한다.
			while(true) {
				System.out.print(">>> ");
				String str = scanner.nextLine().trim();
				if(str.toUpperCase().equals("QUIT")) {
					break;
				}
				if(str.length() != 0) {
//					write() 메소드를 사용해서 PrintWriter 클래스 객체로 생성한 파일레 데이터를 출력한다.
//					\n : new line, 줄을 바꾼다.
//					\r : carriage return, 커서를 줄의 맨 앞으로 보낸다.
					printWriter.write(str + "\r\n");
				}
			}
			System.out.println("저장완료!!!");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
//			출력 용도로 사용하는 파일은 출력 작업이 완료되면 반드시 파일을 닫아야 정상적으로 파일에 저장된다.
			if(printWriter != null) {
				printWriter.close();
			}
		}
				
	}
	
	
	
	
}
