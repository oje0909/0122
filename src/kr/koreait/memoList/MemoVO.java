package kr.koreait.memoList;

import java.text.SimpleDateFormat;
import java.util.Date;

//	메모 1건을 기억하는 클래스
public class MemoVO {
	
	public static int count;
	private int idx;			//글 번호, 자동증가
	private String name;		//이름
	private String password;	//비밀번호
	private String memo;		//메모
	private Date writeDate;		//작성일, 현재 날짜 자동 입력

	public MemoVO() {}
	
	public MemoVO(String name, String password, String memo) {
		idx = ++count;
		this.name = name;
		this.password = password;
		this.memo = memo;
		writeDate = new Date();
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
	@Override
	public String toString() {
		
//		오늘 입력된 글은 시간만 표시하고 어제 이전에 입력된 글은 날짜만 표시한다
		Date date = new Date();		// 오늘
		SimpleDateFormat sdf = null;
//		작성일이 오늘인가 비교한다.
		if(date.getYear()==writeDate.getYear()&&date.getMonth()==writeDate.getMonth()&&date.getDate()==writeDate.getDate()) {
			sdf = new SimpleDateFormat("HH:mm:ss");			
		}else {
			sdf = new SimpleDateFormat("yyyy.MM.yy(E)");
		}
		return idx + ". " + name + "(" + password + ")님이 " + sdf.format(writeDate) + "에 남긴글\n"+ memo;
	}
	
	
	
	
}
