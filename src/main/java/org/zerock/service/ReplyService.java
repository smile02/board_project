package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyVo;

public interface ReplyService {

	public void addReply(ReplyVo vo) throws Exception;
	
	public List<ReplyVo> listReply(Integer bno) throws Exception;
	
	public void modifyReply(ReplyVo vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
}
