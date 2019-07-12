package daoImpl;

import dao.AutionDao;
import entity.Aution;
import entity.Category;
import entity.User;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AutionDaoImpl implements AutionDao {
    @Override
    public ArrayList<Aution> findAllAution() {
        //查找全部商品列表
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        ArrayList<Aution> result = new ArrayList<>();

        try {
            String sql = "SELECT * FROM shopdemo.aution;";
            System.out.println(sql);
            conn = BaseDao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String name = rs.getString("name");
                String category = rs.getString("category");
                Aution aution = new Aution(id, name, description, price, new Category(category));
                result.add(aution);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(rs, st, conn);
        }
        return result;
    }

    @Override
    public Aution findAutionById(int fid) {
        //通过id来查找该商品
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            String sql="select * from shopdemo.aution where id='"+fid+"'";
            conn=BaseDao.getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()){
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String name = rs.getString("name");
                String category = rs.getString("category");
                Aution aution = new Aution(id, name, description, price, new Category(category));
                return  aution;
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

    @Override
    public Boolean addAution(Aution aution) {
        //添加商品
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        Boolean ret = false;

        try {
            String sql = "INSERT INTO `shopdemo`.`aution` (`id`, `name`, `description`, `price`, `category`) VALUES ('"+aution.getId()+"', " +
                    "'"+aution.getName()+"', '"+aution.getDescription()+"', '"+aution.getPrice()+"', '"+aution.getCategory().getName()+"');";
            System.out.println(sql);
            conn = BaseDao.getConnection();
            st = conn.createStatement();
            ret = st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(rs, st, conn);
        }

        return ret;
    }

    @Override
    public Boolean DeletAution(int id) {
        //删除商品
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        Boolean ret = false;

        try {
            String sql = "DELETE FROM `shopdemo`.`aution` WHERE (`id` = '"+id+"');";
            System.out.println(sql);
            conn = BaseDao.getConnection();
            st = conn.createStatement();
            ret = st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(rs, st, conn);
        }

        return ret;
    }

    @Override
    public Boolean UpdateAution(int id, Aution aution) {
        //更改商品
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        Boolean ret = false;

        try {
            String sql = "UPDATE `shopdemo`.`aution` SET `name` = '"+aution.getName()+"', `description` = '"+aution.getDescription()+"'," +
                    " `price` = '"+aution.getPrice()+"', `category` = '"+aution.getCategory().getName()+"' WHERE (`id` = '"+id+"');";
            System.out.println(sql);
            conn = BaseDao.getConnection();
            st = conn.createStatement();
            ret = st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(rs, st, conn);
        }

        return ret;
    }
}
