package org.wm.dao;

import org.wm.entity.Emp;
import org.wm.entity.EmpEx;

import java.util.List;

public interface EmpDao  {
    int insert(Emp emp);
    int update(Emp emp,int empno);
    int delete(int empno);
    List<Emp> getAll();
    List<EmpEx> getAll2();
}
