package himedia.miniproject.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("phonebookDao")
public class PhonebookDaoImpl implements PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PhonebookVo> selectAll() {
		List<PhonebookVo> list = sqlSession.selectList("phonebook.selectAll");
		return list;
	}

	@Override
	public int insert(PhonebookVo phonebookVo) {
		try {
			int insertedCount = sqlSession.insert("phonebook.insert", phonebookVo);
			return insertedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhonebookDaoException("게시물 입력 중 예외 발생",phonebookVo);
		}
		
	}

	@Override
	public PhonebookVo getTel(Long id) {
		PhonebookVo phonebookVo = sqlSession.selectOne("phonebook.getTel", id);
		
		return phonebookVo;
	}

	@Override
	public int update(PhonebookVo phonebookVo) {
		try {
			int updatedCount = sqlSession.update("phonebook.update", phonebookVo);
			return updatedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhonebookDaoException("게시물 업데이트 도중 예외 발생!", phonebookVo);
		}
		
	}

	@Override
	public int select(PhonebookVo phonebookVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		try {
			Map<String, Long> map = new HashMap<>();
			map.put("id", id);
			return sqlSession.delete("phonebook.deleteByUserNo", map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhonebookDaoException("게시물 삭제 중 오류 발생!");
		}	
	}
	
	
}
