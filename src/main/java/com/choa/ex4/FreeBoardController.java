package com.choa.ex4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.free.FreeBoardServiceImpl;

@Controller
@RequestMapping(value="/freeboard/**")
public class FreeBoardController {
	

	@Inject
	FreeBoardServiceImpl freeBoardServiceImpl;
	
	@RequestMapping(value="freeboardList")
	public String boardList(@RequestParam(defaultValue="1") Integer curPage, Model model)throws Exception{
		model.addAttribute("board", "freeboard");
		model.addAttribute("list", freeBoardServiceImpl.boardList(curPage));
		
		return "board/boardList";
		
	}
	
	
	
	
}
