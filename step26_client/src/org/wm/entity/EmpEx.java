package org.wm.entity;

import java.io.Serializable;
import java.util.Date;

public class EmpEx extends Emp implements Serializable {
    private static final long serialVersionUID = -7028258263282929561L;

    private String deptName;
    private String deptLoc;

    public EmpEx(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno, String deptName, String deptLoc) {
        super(empno, ename, job, mgr, hiredate, sal, comm, deptno);
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLoc() {
        return deptLoc;
    }

    public void setDeptLoc(String deptLoc) {
        this.deptLoc = deptLoc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\t");
        sb.append(deptName).append("\t");
        sb.append(deptLoc).append("\t");
        return sb.toString();
    }
}
