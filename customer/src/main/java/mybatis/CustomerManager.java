package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dmvno.charging.customer.domain.CSR_SV_ACNT;



public class CustomerManager {
	
	private static SqlSessionFactory sqlMapper;
    static{
        try {
            Reader reader = Resources.getResourceAsReader("sqlmapConfig.xml");
            
            sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
        } catch (IOException err){
            throw new RuntimeException("SQL세션팩토리 인스턴스 생성 실패" + err,err);
        }
    }


	public static CSR_SV_ACNT SelectCustInfo(String SVC_NUM) {
		// TODO Auto-generated method stub
		System.out.println("[Manager]SVC_NUM :" + SVC_NUM);
		
		return null;
//		SqlSession session = sqlMapper.openSession();
//        CSR_SV_ACNT result = session.selectOne("SelectCustInfo",SVC_NUM);
//        session.close();
//
//		return result;
	}
}
