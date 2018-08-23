package com.xd.myspringbootblog.dao;

import com.xd.myspringbootblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    int countMatchLoginUser(User user);

    User getUserByUserId(int userId);

    User getUserByUserName(String userName);

    boolean saveUser(User user);

    List<User> listUsers();

    boolean updateLoginInfo(User user);



//    public int getMatchCount(String userName, String password){
//        String sqlStr = "select count(*) from t_user where user_name = ? and password = ?";
//        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName, password}, Integer.class);
//    }
//
//    public User findUserByUserName(final String userName){
//        String sqlStr = "select user_id, user_name, credits" + " from t_user where user_name = ?";
//        final User user = new User();
//        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                user.setUserId(resultSet.getInt("user_id"));
//                user.setUserName(userName);
//                user.setCredits(resultSet.getInt("credits"));
//            }
//        });
//        return user;
//    }
//    public User findUserByUserId(final int userId){
//        String sqlStr = "select user_id, user_name, credits" + " from t_user where user_id = ?";
//        final User user = new User();
//        jdbcTemplate.query(sqlStr, new Object[]{userId}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                user.setUserId(userId);
//                user.setUserName(resultSet.getString("user_name"));
//                user.setCredits(resultSet.getInt("credits"));
//            }
//        });
//        return user;
//    }
//
//    public boolean addUser(User user){
//        return true;
//    }
//
//    public void updateLoginInfo(User user){
//        String sqlStr = "update t_user set last_visit = ?, last_ip = ?, credits = ?" + " where user_id = ?";
//        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(),
//                user.getLastIp(), user.getCredits(), user.getUserId()});
//    }
//
//    public List<User> getUserList(){
//        String sqlStr = "SELECT user_id, user_name, credits FROM t_user";
//        List<User> userList = jdbcTemplate.query(sqlStr, new BeanPropertyRowMapper<User>(User.class));
//        return userList;
//    }
}
