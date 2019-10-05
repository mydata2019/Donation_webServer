package don.point.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import don.point.domain.DonUserPntBamt;

/**
 * MY기부내역
 */
public interface PointService {

	DonUserPntBamt selectPntBamt(String userId); 
  
}
