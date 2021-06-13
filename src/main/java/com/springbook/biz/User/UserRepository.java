package com.springbook.biz.User;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Integer>{
	//Native SQL, SQL구문은 JPQL형태가 아니라 DB에서 사용하는 SQL형식을 쓰면 된다.
	//nativeQuery 값의 default는 false
	//#entityName은 SpEL 표현이며 위 Repository<T, Long>의 T객체를 가리킨다.
//	  @Query(value="SELECT * FROM Users WHERE id = :id and password = :password",nativeQuery = true)
//	  User findUser(@Param("id")String id, @Param("password")String password);
	// 아래는 Native SQL 아님
	// user = @Entity(name="user") 이기때문에 user를 값을 넣어줌
      @Query("SELECT u FROM User u WHERE u.id = :id and u.pw = :pw") // 로그인
      User findUser(@Param("id")String id,@Param("pw")String pw);
      
      @Query("SELECT COUNT(*) FROM User u WHERE u.id = :id") // 아이디 체크
      Integer idChk(@Param("id")String id);
      
      @Query("SELECT u.id FROM User u WHERE u.name = :name") // 아이디 찾기
      String getId(String name);
      
      @Query("SELECT u.pw FROM User u WHERE u.id = :id") // 비번 찾기
      String getPw(String id);
      
      
      
      
}
