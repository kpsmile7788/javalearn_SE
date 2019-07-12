package org.wm.dao;

import org.wm.entity.Dept;

import java.util.List;

public interface DeptDao {
    int insert(Dept dept);
    int update(Dept dept,int deptno);
    int delete(int deptno);
    List<Dept> getAll();
}
