package test;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

public interface Mapper {
  User getUser(Integer id);

  void insertUser(User user);

  // works fine
  @Select("SELECT * FROM USERS")
  Cursor<User> listUsers();

  // No operations allowed after statement closed.
  @Options(fetchSize = Integer.MIN_VALUE)
  @Select("SELECT * FROM USERS")
  Cursor<User> listUsersWithFetchSize();
}
