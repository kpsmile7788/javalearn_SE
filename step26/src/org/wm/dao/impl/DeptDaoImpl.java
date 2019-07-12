package org.wm.dao.impl;

import org.wm.dao.DeptDao;
import org.wm.entity.Dept;
import org.wm.util.DBUtil;

import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public int insert(Dept dept) {
        String sql = "insert into Dept values(?,?,?)";
        return DBUtil.update(sql,dept.getDeptNo(),dept.getDeptName(),dept.getLoc());
    }

    @Override
    public int update(Dept dept, int deptno) {
        String sql = "update Dept set dname=?,loc=? where deptno=?";
        return DBUtil.update(sql,dept.getDeptName(),dept.getLoc(),dept.getDeptNo());
    }

    @Override
    public int delete(int deptno) {
        String sql = "delete from dept where deptno=?";
        return DBUtil.update(sql,deptno);
    }

    @Override
    public List<Dept> getAll() {
        return null;
    }
}
