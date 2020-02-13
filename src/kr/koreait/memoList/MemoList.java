package kr.koreait.memoList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//	여러건의 메모를 기억하는 클래스
public class MemoList {

	private ArrayList<MemoVO> memoList = new ArrayList<>();

	public ArrayList<MemoVO> getMemoList() {
		return memoList;
	}
	public void setMemoList(ArrayList<MemoVO> memoList) {
		this.memoList = memoList;
	}
	
	@Override
	public String toString() {
//		마지막에 입력된 글(최신글) 부터 출력하기 위해 ArrayList에 저장된 마지막 글 부터 출력한다.
		String str = "";
//		memoList ArrayList에 저장된 메모가 없으면 메모가 없다는 메시지를 출력하고 저장된 메모가 있으면 저장된 메모를 출력한다.
		if(memoList.size()==0) {
			str+="저장된 메모가 없습니다.\n";
		}else {
			for(int i=memoList.size()-1; i>=0;i--) {
				str += memoList.get(i)+"\n";
			}
		}
		return str;
	}
	
//	MemoProject 클래스에서 호출되는 memoList ArrayList에 저장할 데이터가 기억된 객체를 넘겨받고  memoList ArrayList에 저장하는 메소드
	public void addMemo(MemoVO vo) {
		for(int i = 0; i < memoList.size();i++) {
			memoList.get(i).setIdx(i+1);
		}
		memoList.add(vo);
	}
	
//	MemoProject 클래스에서 수정 또는 삭제할 글 번호를 넘겨받고  memoList ArrayList에서 글 번호를 해당되는 글 1건을 리턴하는 메소드
	public MemoVO selectMemo(int idx) {
		try {
			return memoList.get(idx-1);
		}catch(Exception e) {
			return null;
		}
	}
	
	public void deleteMemo(int idx) {
		memoList.remove(idx-1);
//		글 삭제 후 글번호를 다시 붙여준다. => ArrayList를 사용하기 때문에 이런 현상이 발생된다.
		for(int i = 0; i < memoList.size();i++) {
			memoList.get(i).setIdx(i+1);
		}
//		글이 삭제된 후 새 글이 입력될 때 idx가 자동으로 1씩 증가되게 하기 위해서 1씩 증가하는 정적변수 count의 값을 수정한다. 
		MemoVO.count = memoList.size();
	}
	
//	MemoProject 클래스에서 수정할 글번호와 메모를 넘겨받고 memoList ArrayList에서 글번호에 해당되는 글 1건을 수정하는 메소드
	public void updateMemo(int idx, String memo) {
		memoList.get(idx-1).setMemo(memo);
	}
	
	public void fileWriteMemo(String filename) {
		PrintWriter printWriter = null;
		try {
			String filePath = "./src/kr/koreait/memoList/"+ filename + ".txt";
			printWriter = new PrintWriter(filePath);		//출력 파일 open
			
//			memoList ArrayList에 저장된 데이터의 개수만큼 반복하며 ArrayList에 저장된 데이터를 텍스트 파일에 출력한다.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			for(MemoVO vo : memoList) {
//				printWriter.write(vo + "\r\n");
				String str = "";
				str+=vo.getIdx() + " ";
//				replace(old, new) : 문자열의 모든 old를 new로 치환한다.
				str+= vo.getName().replace(" ", "_") + " ";
				str+= vo.getPassword() + " ";
				str+= vo.getMemo().replace(" ", "_") + " ";
				str+= vo.getWriteDate() + " ";
				str+= sdf.format(vo.getWriteDate());
//				String str = String.format("%s", args)
				
				printWriter.write(str + "\r\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일의 경로 또는 이름이 올바르지 않습니다.");
			e.printStackTrace();
		}finally {
			if(printWriter != null) {
				printWriter.close();  	//출력 파일 close
			}
		}
		
		
	}
	
	
	
			
	
	
	
	
	
	
}
