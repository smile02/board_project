package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVo;
import org.zerock.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDao dao;
	
	@Override
	public void regist(BoardVo board) throws Exception {
		dao.create(board);
	}

	@Override
	public BoardVo read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVo board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVo> listAll() throws Exception {
		return dao.listAll();
	}

}
