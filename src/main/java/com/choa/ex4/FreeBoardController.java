package com.choa.ex4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.free.FreeBoardDTO;
import com.choa.free.FreeBoardServiceImpl;
import com.choa.notice.NoticeDTO;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/freeboard/**")
public class FreeBoardController {
	

	@Inject
	FreeBoardServiceImpl freeBoardServiceImpl;
	
	@RequestMapping(value="freeboardList")
	public String boardList(Model model, ListInfo listInfo)throws Exception{
		model.addAttribute("board", "freeboard");
		model.addAttribute("list", freeBoardServiceImpl.boardList(listInfo));
		
		return "board/boardList";
		
	}
	
	@RequestMapping(value="freeboardView",method=RequestMethod.GET)
	public String noticeView(Integer num,Model model) throws Exception{
		if(num==null){}
		
		FreeBoardDTO  freeBoardDTO=(FreeBoardDTO) freeBoardServiceImpl.boardView(num);
		
		model.addAttribute("dto", freeBoardDTO);
		model.addAttribute("board", "freeboard");
		
		return "board/boardView";
		
	}
	@RequestMapping(value="freeboardWrite",method=RequestMethod.GET)
	public String noticeWrite(Integer num, Model model) throws Exception{
		model.addAttribute("path", "Write");
		model.addAttribute("board", "freeboard");
		return "board/boardWrite";
		
	}
	@RequestMapping(value="freeboardWrite",method=RequestMethod.POST)
	public String noticeWrite(FreeBoardDTO freeBoardDTO,RedirectAttributes rd) throws Exception{
		
			int result = freeBoardServiceImpl.boardWrite(freeBoardDTO);
			String message = "FAIL";
			if(result>0){
				message="SUCCESS";
			}
			rd.addAttribute("board", "freeboard");
			rd.addFlashAttribute("message", message);
		return "redirect:freeboardList?curPage=1";
		
		
	}
	@RequestMapping(value="freeboardUpdate",method=RequestMethod.GET)
	public String noticeUpdate(Model model, Integer num )throws Exception{
		
		FreeBoardDTO freeBoardDTO =(FreeBoardDTO) freeBoardServiceImpl.boardView(num);
		model.addAttribute("path", "Update");
		model.addAttribute("dto", freeBoardDTO);
		model.addAttribute("board", "freeboard");
		
		return"board/boardWrite";
	}
	@RequestMapping(value="freeboardUpdate",method=RequestMethod.POST)
	public String noticeUpdate(FreeBoardDTO freeBoardDTO, RedirectAttributes rd)throws Exception{
		
			int result = freeBoardServiceImpl.boardUpdate(freeBoardDTO);
			String message = "FAIL";
			if(result>0){
				message = "SUCCESS";
			}
			rd.addAttribute("board", "freeboard");
			rd.addFlashAttribute("message", message);
	
		
		return "redirect:freeboardList";
	}
	@RequestMapping(value="freeboardDelete",method=RequestMethod.GET)
	public String noticeDelete(Integer num, RedirectAttributes rd)throws Exception{
		
			int result = freeBoardServiceImpl.boardDelete(num);
			String message = "FAIL";
			if(result>0){				
				message="SUCCESS";
			}
			rd.addAttribute("board", "freeboard");
			rd.addFlashAttribute("message", message);
	
		return "redirect:freeboardList?curPage=1";
	}
	
	
	
	
}
