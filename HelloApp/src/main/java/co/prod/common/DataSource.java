package co.prod.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// ojdbc 활용 : db connection객체
// 특징 : 객체 생성하고반환
// connection 객체 : 서버에 미리 생성 (ex10개)
// DataSource -> Resource 가져오는 룩업;
// 객체를 계속만들면 리소스 부족.

public class DataSource {
	
	// 싱글톤 방식
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
		
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
