/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.human;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author 84904
 */
public class HumanTypeDAO {
    public List<HumanTypeDTO> getAll() throws SQLException{
        List<HumanTypeDTO> ds =new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT typeId, typeName FROM HumanType";
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while(rs.next()){
                HumanTypeDTO x = new HumanTypeDTO();
                x.setTypeId(rs.getInt("typeId"));
                x.setTypeName(rs.getString("typeName"));
                ds.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return ds;
    }
    public List<HumanTypeDTO> searchType(String search) throws SQLException{
        List<HumanTypeDTO> ds = new ArrayList<>();
        Connection conn =null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            final String SEARCH="SELECT typeId, typeName FROM HumanType WHERE typeId like ?";
            ptm=conn.prepareStatement(SEARCH);
            ptm.setString(1, "%"+search+"%");
            rs=ptm.executeQuery();
            while(rs.next()){
                HumanTypeDTO human = new HumanTypeDTO();
                human.setTypeId(rs.getInt("typeId"));
                human.setTypeName(rs.getString("typeName"));
                ds.add(human);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return ds;
    }
    public boolean deleteType(int typeId) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            String cmd = "DELETE FROM HumanType WHERE typeId = ?";
            ptm = conn.prepareStatement(cmd);
            ptm.setInt(1, typeId);
            int rows = ptm.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            if (e.getMessage() != null && e.getMessage().contains("FK__Human__typeId")) {
                return false;
            }
            throw new RuntimeException("SQL error while deleting typeId=" + typeId, e);
        } finally {
            try {
                if (ptm != null) ptm.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void update(HumanTypeDTO x) throws SQLException{
        Connection conn= null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            final String sql="update HumanType set typeName=? where typeId=?";
            ptm=conn.prepareStatement(sql);
            ptm.setString(1, x.getTypeName());
            ptm.setInt(2, x.getTypeId());
            ptm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
        }
    }
    public boolean checkDuplicate(int typeId) throws SQLException{
        boolean check =false;
        Connection conn =null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn=DBUtils.getConnection();
            String DUPLICATE="SELECT typeId FROM HumanType WHERE typeId=?";
            ptm = conn.prepareStatement(DUPLICATE);
            ptm.setInt(1, typeId);
            rs=ptm.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        
        return check;
    }
    public boolean insert(HumanTypeDTO type) throws SQLException{
        boolean check=false;
        Connection conn =null;
        PreparedStatement ptm = null;
        try {
            conn=DBUtils.getConnection();
            String INSERT="INSERT INTO HumanType(typeId, typeName) VALUES (?, ?)";
            if (conn != null) {
            ptm = conn.prepareStatement(INSERT);
            ptm.setInt(1, type.getTypeId());
            ptm.setString(2, type.getTypeName());

            check = ptm.executeUpdate() > 0 ? true : false;
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();        }
        return check;
    }
}
