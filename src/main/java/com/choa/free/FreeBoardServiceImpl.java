package com.choa.free;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;

@Service
public class FreeBoardServiceImpl implements BoardService{
	
	@Inject
	private FreeBoardDAOImpl freeBoardDAO;

	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		PageMaker pageMaker = new PageMaker(curPage);
		String kind = null;
		String search = null;		
		return freeBoardDAO.boardList(pageMaker.getRowMaker(kind, search));
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		
		return freeBoardDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeBoardDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeBoardDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return freeBoardDAO.boardDelete(num);
	}

	
	
	
}
