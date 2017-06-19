package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.util.PageMaker;

public class test extends MyTestA {
	@Inject
	private NoticeDAOImpl dao;
	
	@Test
	public void connectionTest() throws Exception{
		
		
		PageMaker pageMaker = new PageMaker(1);
		List<BoardDTO> ar =  dao.boardList(pageMaker.getRowMaker(null, null));
		
		assertNotEquals(0, ar.size());		
		
		
	}
	@Test
	public void countTest() throws Exception{
		int count = dao.boardCount();
		assertNotEquals(0, count);
	}

}
