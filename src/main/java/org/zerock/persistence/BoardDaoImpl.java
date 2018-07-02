package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession session;
	
	private static String namespace
		= "org.zerock.mapper.BoardMapper";
	
	@Override
	public void create(BoardVo vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public BoardVo read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read",bno);
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete",bno);
	}	

	@Override
	public List<BoardVo> listAll() throws Exception {	
		return session.selectList(namespace+".listAll");
	}

}
