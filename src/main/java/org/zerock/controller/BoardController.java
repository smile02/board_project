package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVo;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public void registerGET(BoardVo board, Model model) {
		logger.info("register get....");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(BoardVo board, RedirectAttributes rttr) throws Exception {
		logger.info("regist post....");
		logger.info(board.getTitle()+", "+board.getContent()+", "+board.getWriter());
		
		service.regist(board);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all List................");
		model.addAttribute("list",service.listAll());
	}
}
