package don.point.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import don.point.domain.DonUserPntBamt;
import don.point.mapper.PointRepository;

@Service
@Slf4j
class PointServiceImpl implements PointService {

	@Autowired
	private PointRepository pntRepo; //repository
	
	public DonUserPntBamt selectPntBamt(String userId) {

		int id = Integer.parseInt(userId);				
		DonUserPntBamt result = pntRepo.selectPntBamt(id);

		return result;
	}

	
}
