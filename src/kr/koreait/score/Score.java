package kr.koreait.score;

import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		/*
		ScoreVO score1 = new ScoreVO();
		System.out.println(score1);
		ScoreVO score2 = new ScoreVO();
		System.out.println(score2);
		
		ScoreVO score3 = new ScoreVO("홍길동",100,100,99);
		System.out.println(score3);
		
		System.out.println("score2.no => "+score2.no);
		score2.no = 100;
		System.out.println("score2.no => "+score2.no);
		System.out.println("score3.no => "+score3.no);
		System.out.println("ScoreVO.no => "+ScoreVO.no);
		*/
		
		ScoreList scoreList = new ScoreList();
		ScoreVO score1 = new ScoreVO("홍길동", 100,100,99);
		ScoreVO score2 = new ScoreVO("홍길자", 72,80,90);
		ScoreVO score3 = new ScoreVO("홍길숙", 50,60,70);
		ScoreVO score4 = new ScoreVO("홍길희", 97,56,97);
		ScoreVO score5 = new ScoreVO("홍길영", 95,85,75);
		
		scoreList.addScore(score1);
		scoreList.addScore(score2);
		scoreList.addScore(score3);
		scoreList.addScore(score4);
		scoreList.addScore(score5);
		
		System.out.println(scoreList);
		
		
		
//		Scanner sc = new Scanner(System.in);
//		for(int i=0;i<3;i++) {
//			System.out.println("이름 : ");
//			String name = sc.next();
//			System.out.println("java , jsp , spring 점수를 입력하세요 :");
//			int java = sc.nextInt();
//			int jsp = sc.nextInt();
//			int spring = sc.nextInt();
//			
//			ScoreVO s = new ScoreVO(name,java,jsp,spring);
//	//		System.out.println(s);
//			
//			scoreList.addScore(s);
//		}
//		System.out.println(scoreList);
		
		
		
	}

}
