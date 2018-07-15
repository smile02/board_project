package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void regist(BoardVo board) throws Exception;
	
	public BoardVo read(Integer bno) throws Exception;
	
	public void modify(BoardVo board)throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardVo> listAll() throws Exception;
	
	public List<BoardVo> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
}
