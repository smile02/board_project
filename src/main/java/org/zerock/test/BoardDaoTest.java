package org.zerock.test;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVo;
import org.zerock.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {

	@Inject
	private BoardDao dao;
	
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
}
