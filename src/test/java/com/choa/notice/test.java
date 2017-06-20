package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;

public class test extends MyTestA {
	@Inject
	private NoticeDAOImpl dao;
	
	/*@Test
	public void connectionTest() throws Exception{
		
		
		PageMaker pageMaker = new PageMaker(1);
		
		List<BoardDTO> ar =  dao.boardList(pageMaker.getRowMaker(),"writer","choa");
		for(int i=0; i<ar.size(); i++){
		System.out.println(ar.get(i).getWriter());
		}
		assertNotEquals(0, ar.size());		
		
		
	}*/
	@Test
	public void countTest() throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setFind("choa");
		listInfo.setSearch("writer");
		int count = dao.boardCount(listInfo);
		System.out.println(count);
		
	}

}
