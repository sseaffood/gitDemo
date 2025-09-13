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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.utils.DBUtils;

/**
 *
 * @author 84904
 */
public class HumanDAO {
    
    public HumanDTO checkLogin(String uname, String psw) throws SQLException{
        HumanDTO human = null;
        Connection conn=null;
        PreparedStatement ptm =null;
        ResultSet rs = null;
        try {
            conn=DBUtils.getConnection();
            final String LOGIN = "SELECT humanId, humanName, dob, gender, typeId, role FROM Human "
                    + "WHERE userHuman=? AND passHuman=?";
            ptm=conn.prepareStatement(LOGIN);
            ptm.setString(1, uname);
            ptm.setString(2, psw);
            rs = ptm.executeQuery();
            while(rs.next()){
                human = new HumanDTO();
                human.setHumanID(rs.getString("humanId"));
                human.setHumanName(rs.getString("humanName"));
                human.setDob(rs.getDate("dob"));
                human.setGender(rs.getBoolean("gender"));
                human.setTypeId(rs.getInt("typeId"));
                human.setRole(rs.getString("role"));
                human.setUserHuman("userHuman");
                human.setPassHuman(rs.getString("passHuman"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return human;
    }
    
    public List<HumanDTO> getAll() throws SQLException{
        List<HumanDTO> ds = new ArrayList<>();
        Connection conn =null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            final String GET_ALL = "SELECT humanId, humanName, dob, gender, typeId,"
                    + " userHuman, passHuman, role FROM human";
            ptm = conn.prepareStatement(GET_ALL);
            rs = ptm.executeQuery();
            while(rs.next()){
                HumanDTO human = new HumanDTO();
                human.setHumanID(rs.getString("humanId"));
                human.setHumanName(rs.getString("humanName"));
                human.setDob(rs.getDate("dob"));
                human.setGender(rs.getBoolean("gender"));
                human.setTypeId(rs.getInt("typeId"));
                human.setUserHuman(rs.getString("userHuman"));
                human.setPassHuman(rs.getString("passHuman"));
                human.setRole(rs.getString("role"));
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
    public List<HumanDTO> searchHuman(String search) throws SQLException{
        List<HumanDTO> ds = new ArrayList<>();
        Connection conn =null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            final String SEARCH="SELECT humanId, humanName, dob, gender, typeId, userHuman, passHuman, role "
                + "FROM Human WHERE humanName like ?";
            ptm=conn.prepareStatement(SEARCH);
            ptm.setString(1, "%"+search+"%");
            rs=ptm.executeQuery();
            while(rs.next()){
                HumanDTO human = new HumanDTO();
                human.setHumanID(rs.getString("humanId"));
                human.setHumanName(rs.getString("humanName"));
                human.setDob(rs.getDate("dob"));
                human.setGender(rs.getBoolean("gender"));
                human.setTypeId(rs.getInt("typeId"));
                human.setUserHuman(rs.getString("userHuman"));
                human.setPassHuman("***");
                human.setRole(rs.getString("role"));
                human.setUserHuman("userHuman");
                human.setPassHuman(rs.getString("passHuman"));
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
    public void deleteHuman(String humanId) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            String cmd = "DELETE FROM Human WHERE humanId =?";
            ptm = conn.prepareStatement(cmd);
            ptm.setString(1, humanId);
            ptm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
        }
    }
    public boolean update(HumanDTO x) throws SQLException{
        boolean check=false;
        Connection conn= null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            final String sql="UPDATE Human SET humanName=?, dob=?, gender=?, typeId=?, userHuman=?, passHuman=?, role=?"
                    + " WHERE humanId=?";
            ptm=conn.prepareStatement(sql);
            ptm.setString(1, x.getHumanName());
            ptm.setDate(2, x.getDob());
            ptm.setBoolean(3, x.isGender());
            ptm.setInt(4, x.getTypeId());
            ptm.setString(5, x.getUserHuman());
            ptm.setString(6, x.getPassHuman());
            ptm.setString(7, x.getRole());
            ptm.setString(8, x.getHumanID());
            
            check = ptm.executeUpdate()> 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
        }
        return check;
    }
    public boolean checkDuplicate(String humanId) throws SQLException{
        boolean check =false;
        Connection conn =null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn=DBUtils.getConnection();
            String DUPLICATE="SELECT humanId FROM Human WHERE HumanId=?";
            ptm = conn.prepareStatement(DUPLICATE);
            ptm.setString(1, humanId);
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
    public boolean checkDuplicateUser(String userHuman) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT humanID FROM Human WHERE userHuman = ?";
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, userHuman);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return check;
    }
    public boolean insert(HumanDTO human) throws SQLException{
        boolean check=false;
        Connection conn =null;
        PreparedStatement ptm = null;
        try {
            conn=DBUtils.getConnection();
            String INSERT="INSERT INTO Human(humanId, humanName, dob, gender, typeId, userHuman, passHuman,"
                    + " role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            if (conn != null) {
            ptm = conn.prepareStatement(INSERT);
            ptm.setString(1, human.getHumanID());
            ptm.setString(2, human.getHumanName());
            ptm.setDate(3, human.getDob());
            ptm.setBoolean(4, human.isGender());   
            ptm.setInt(5, human.getTypeId());
            ptm.setString(6, human.getUserHuman());
            ptm.setString(7, human.getPassHuman());
            ptm.setString(8, human.getRole()); 

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
