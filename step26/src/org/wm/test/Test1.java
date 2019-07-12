package org.wm.test;

import org.wm.dao.DeptDao;
import org.wm.dao.EmpDao;
import org.wm.dao.impl.DeptDaoImpl;
import org.wm.dao.impl.EmpDaoImpl;
import org.wm.entity.Dept;
import org.wm.entity.Emp;
import org.wm.entity.EmpEx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        /*Dept d = new Dept(90,"人","洛杉矶");
        DeptDao dd = new DeptDaoImpl();
        //System.out.println(dd.insert(d)>0?"YYY":"NNN");
        //System.out.println(dd.update(d,d.getDeptNo())>0?"YYY":"NNN");
        System.out.println(dd.delete(d.getDeptNo())>0?"YYY":"NNN");*/
        System.out.println(new Date());

        //new Date();
        //Emp emp = new Emp(1234,"AAA","BBB",7788,new java.sql.Date(new Date().getTime()),80000,3000,30);
        EmpDao ed = new EmpDaoImpl();
        //List<Emp> all = ed.getAll();
        //System.out.println(ed.insert(emp)>0?"YYY":"NNN");
        //System.out.println(all.size());
        List<EmpEx> all2 = ed.getAll2();
        System.out.println(all2.size());
        for (EmpEx e:
             all2) {
            System.out.println(e);
        }

    }
}
