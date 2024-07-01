package himedia.miniproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.miniproject.repositories.PhonebookDao;
import himedia.miniproject.repositories.PhonebookVo;

@Service("phonebookService")
public class PhonebookServiceImpl implements PhonebookService {


	@Autowired 
	private PhonebookDao phonebookDao;
	
	@Override
	public List<PhonebookVo> getList() {
		List<PhonebookVo> list = phonebookDao.selectAll();
		return list;
	}

	@Override
	public PhonebookVo getContent(Long id) {
		PhonebookVo phonebookVo = phonebookDao.getTel(id);
		return null;
	}

	@Override
	public boolean write(PhonebookVo phonebookVo) {
		int insertedCount = phonebookDao.insert(phonebookVo);
		return insertedCount == 1;
	}

	@Override
	public boolean update(PhonebookVo phonebookVo) {
		int updatedCount = phonebookDao.update(phonebookVo);
		return updatedCount == 1;
	}

	@Override
	public boolean delete(Long id) {
		int deletedCount = phonebookDao.delete(id);
		return deletedCount == 1;
	}

	
	
}
