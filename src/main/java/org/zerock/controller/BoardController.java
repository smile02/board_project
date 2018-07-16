package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/readPage", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,
					 @ModelAttribute("cri") Criteria cri,
					 Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}		
	
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
	
	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno,
				Criteria cri,
				RedirectAttributes rttr) throws Exception{
		
		service.remove(bno);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		//rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyGET(int bno,
						  @ModelAttribute("cri") Criteria cri,
						  Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage", method = RequestMethod.POST)
	public String modifyPost(BoardVo board, Criteria cri,
				RedirectAttributes rttr) throws Exception{
		logger.info("mod post ...............");
		
		service.modify(board);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		//rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(Criteria criteria, Model model) throws Exception{
		logger.info("show list Page with Criteria....................");
		model.addAttribute("list", service.listCriteria(criteria));
		
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
}
