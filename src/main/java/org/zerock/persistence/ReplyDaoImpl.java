package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ReplyVo;

@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.ReplyMapper";

	@Override
	public List<ReplyVo> list(Integer bno) throws Exception {
		return session.selectList(namespace+".list",bno);
	}

	@Override
	public void create(ReplyVo vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public void update(ReplyVo vo) throws Exception {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		session.delete(namespace+".delete",rno);
	}
	
	
}
