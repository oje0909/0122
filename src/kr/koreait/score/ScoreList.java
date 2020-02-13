package kr.koreait.score;

import java.util.ArrayList;

public class ScoreList {
	ArrayList<ScoreVO> list = new ArrayList<>();

	public ArrayList<ScoreVO> getList() {
		return list;
	}

	public void setList(ArrayList<ScoreVO> list) {
		this.list = list;
	}
	
	
//	ArrayList에 데이터를 추가하는 메소드
	public void addScore(ScoreVO score) {
		list.add(score);
	}                                              
	
	@Override
	public String toString() {
		
		String str = "";
		str += "==========================================\n";
		str += "번호   이름   java  jsp  spring  총점   평균    석차\n";
		str += "==========================================\n";
		
//		석차를 계산하는 메소드를 실행한다.
		ranking();
		
//		일반 for문
//		for(int i=0;i<list.size();i++) {
//			str += list.get(i)+ "\n";
//		}

//		향상된  for문
		for(ScoreVO i : list) {
			str+=i+"\n";
		}
		str += "==========================================\n";
		
		return str;
	}

//	선택 정렬 알고리즘을 사용해 석차를 계산하는 메소드
	private void ranking() {
//		선택 정렬 알고리즘을 사용해 석차를 계산한다.
		for(int i=0;i<list.size()-1;i++) {
			for(int j = i+1;j < list.size(); j++) {
//				i번째 총점이 크면 j번째 석차를 증가시키고 j번째 총점이 크면  i번째 석차를 증가시킨다.
				if(list.get(i).getAverage() > list.get(j).getAverage()) {
					list.get(j).setRank(list.get(j).getRank()+1);
				}else if(list.get(i).getAverage() < list.get(j).getAverage()) {
					list.get(i).setRank(list.get(i).getRank()+1);
				}
			}
		}
	}
	
	
	

	
	
	
}
