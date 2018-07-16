package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.ReplyVo;

public interface ReplyDao {

	public List<ReplyVo> list(Integer bno) throws Exception;
	
	public void create(ReplyVo vo) throws Exception;
	
	public void update(ReplyVo vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
}
