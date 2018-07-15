package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;

public interface BoardDao {

	public void create(BoardVo vo) throws Exception;
	
	public BoardVo read(Integer bno) throws Exception;
	
	public void update(BoardVo vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVo> listAll() throws Exception;
	
	public List<BoardVo> listPage(int page) throws Exception;
	
	public List<BoardVo> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
}
