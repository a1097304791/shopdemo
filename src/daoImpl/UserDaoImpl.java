package daoImpl;

import dao.UserDao;
import entity.User;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean isExist(String username){
        //通过用户名查找该用户是否存在
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            String sql = "select count(*) from user where username = '"+username+"';";
            System.out.println(sql);
            conn = BaseDao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            //如果找到该用户返回true
            while (rs.next()){
                if(rs.getBoolean(1))
                    return true;
                else
                    return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(rs, st, conn);
        }
        return false;
    }


    @Override
    public User findUserByUsername(String username) {
        //通过用户名来查找该用户
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            String sql="select * from shopdemo.user where username='"+username+"'";
            conn=BaseDao.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()){
                Boolean isAdm;
                if(rs.getInt("isAdm")==1) isAdm = true;
                else isAdm = false;

                User target = new User(rs.getString("username"), rs.getString("password"), Integer.parseInt(rs.getString("age"))
                        , rs.getString("gender"), rs.getString("address"), rs.getString("tel"), rs.getString("email")
                        , rs.getString("school"), rs.getString("major"), rs.getString("education"), rs.getString("name")
                        , isAdm);
                return target;
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.closeAll(rs, st, conn);
        }
        return null;
    }
}
