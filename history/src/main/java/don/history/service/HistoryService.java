package don.history.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import don.history.domain.DonUserDonHst;
import don.history.domain.DonUserInfoMain;

/**
 * MY기부내역
 */
public interface HistoryService {

  DonUserInfoMain selectHistory(String userId); 
  String insertHistory(List<HashMap<String, Object>> donationHistory, String gubun);
}
