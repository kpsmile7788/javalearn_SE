package org.wm.dao.impl;

import org.wm.dao.EmpDao;
import org.wm.entity.Emp;
import org.wm.entity.EmpEx;
import org.wm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public int insert(Emp emp) {
        String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
        return DBUtil.update(sql,
                emp.getEmpno(),
                emp.getEname(),
                emp.getJob(),
                emp.getMgr(),
                emp.getHiredate(),
                emp.getSal(),
                emp.getComm(),
                emp.getDeptno());
    }

    @Override
    public int update(Emp emp, int empno) {
        String sql = "updata emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        return DBUtil.update(emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),sql,emp.getEmpno());
    }

    @Override
    public int delete(int empno) {
        String sql = "delete from emp where empno=?";
        return DBUtil.update(sql,empno);
    }

    @Override
    public List<Emp> getAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from emp";
        List<Emp> list = new ArrayList<Emp>();
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Emp emp = new Emp(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getDate(5),rs.getDouble(6),
                        rs.getDouble(7),rs.getInt(8));
                list.add(emp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,st,conn);
        }

        return list;
    }

    @Override
    public List<EmpEx> getAll2() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select e.*,d.dname,d.loc from emp e,dept d where e.deptno=d.deptno";
        List<EmpEx> list = new ArrayList<EmpEx>();
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                EmpEx empEx = new EmpEx(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getDate(5),rs.getDouble(6),
                        rs.getDouble(7),rs.getInt(8),rs.getString(9),rs.getString(10));
                list.add(empEx);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,st,conn);
        }

        return list;
    }


    public List<Emp> quaryByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from emp where ename like ?";
        List<Emp> list = new ArrayList<Emp>();
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            String temp = "%"+name+"%";
            ps.setString(1,temp);
            rs = ps.executeQuery();
            while (rs.next()){
                Emp emp = new Emp(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getDate(5),rs.getDouble(6),
                        rs.getDouble(7),rs.getInt(8));
                list.add(emp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,ps,conn);
        }

        return list;
    }

}
