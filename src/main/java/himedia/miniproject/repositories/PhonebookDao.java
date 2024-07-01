package himedia.miniproject.repositories;

import java.util.List;

public interface PhonebookDao {
	public List<PhonebookVo> selectAll();
	public int insert(PhonebookVo phonebookVo);
	public PhonebookVo getTel(Long id);
	public int update(PhonebookVo phonebookVo);
	public int select(PhonebookVo phonebookVo);
	public int delete(Long id);
}
