package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.zerock.domain.ReplyVo;
import org.zerock.persistence.ReplyDao;

public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDao dao;
	
	@Override
	public void addReply(ReplyVo vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<ReplyVo> listReply(Integer bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVo vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		dao.delete(rno);
	}

}
