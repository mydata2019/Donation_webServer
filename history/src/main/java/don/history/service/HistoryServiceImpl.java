package don.history.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import don.history.mapper.HistoryRepository;

@Service
@Slf4j
class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryRepository histRepo; //repository
	
	public List<HashMap<String, Object>> selectHistory(String userId) {

		int id = Integer.parseInt(userId);				
		List<HashMap<String, Object>> result = histRepo.selectHistory(id);

		return result;
	}

	
}
