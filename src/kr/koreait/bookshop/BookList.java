package kr.koreait.bookshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class BookList {
	
	private ArrayList<BookVO> bookList = new ArrayList<>();
	DecimalFormat df = new DecimalFormat("#,##0원");
	
	public ArrayList<BookVO> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<BookVO> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		String str = "";
		str += "=============================================================\n";
		str += "도서명	저자명	출판사명	출판일	가격 \n";
		str += "=============================================================\n";
		
		double total=0.0;
		
		for(BookVO vo : bookList) {
			str+= vo + "\n";
			total += vo.getPrice();
		}
		str += "=============================================================\n";
		str += "                         합계금액 : "+ df.format(total)+"\n ";												
		return str;
	}

	public void addBook(BookVO book1) {
		
	
		bookList.add(book1);
		
		
		
		
	}

}
