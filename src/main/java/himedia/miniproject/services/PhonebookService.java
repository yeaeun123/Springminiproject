package himedia.miniproject.services;

import java.util.List;

import himedia.miniproject.repositories.PhonebookVo;

public interface PhonebookService {

	public List<PhonebookVo> getList();
	public PhonebookVo getContent(Long id);
	public boolean write(PhonebookVo phonebookVo);
	public boolean update(PhonebookVo phonebookVo);
	public boolean delete(Long id);
}
