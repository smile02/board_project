package org.zerock.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.controller.CommonExceptionAdvice;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {
	
	@Inject
	private BoardDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVo board = new BoardVo();
		board.setTitle("새로운 글을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user00");
		
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception {
		System.out.println(dao.read(1));
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVo board = new BoardVo();
		board.setBno(1);
		board.setTitle("수정된 글입니다.");
		board.setContent("수정된 글을 넣습니다.");		
		
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
	
	@Test
	public void testListPage() throws Exception{
		int page = 3;
		
		List<BoardVo> list = dao.listPage(page);
		
		for(BoardVo boardVo : list) {
			System.out.println(boardVo);
		}
	}
	
	@Test
	public void testListCriteria() throws Exception{
		Criteria criteria = new Criteria();
		criteria.setPage(2);
		criteria.setPerPageNum(20);
		
		List<BoardVo> list = dao.listCriteria(criteria);
		
		for(BoardVo boardVo : list) {
			logger.info(boardVo.getBno() + " : "+ boardVo.getTitle());
		}
		
	}
	
	@Test
	public void testURI() throws Exception{
		UriComponents uriComponents = 
					UriComponentsBuilder.newInstance()
					.path("/board/read")
					.queryParam("bno", 12)
					.queryParam("perPageNum", 20)
					.build();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());		
	}
	
	@Test
	public void testURI2() throws Exception{
		UriComponents uriComponents = 
					UriComponentsBuilder.newInstance()
					.path("/{module}/{page}")
					.queryParam("bno", 12)
					.queryParam("perPageNum", 20)
					.build()
					.expand("board","read")
					.encode();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());		
	}
}
