package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;

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

	@Override
	public List<BoardVo> listPage(int page) throws Exception {
		if(page <= 0) {
			page = 1;
		}
		page = (page -1) * 10;
		return session.selectList(namespace+ ".listPage", page);
	}

	@Override
	public List<BoardVo> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria",cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging",cri);
	}

}
