package org.wm.entity;

import java.io.Serializable;

public class Dept implements Serializable {

    private static final long serialVersionUID = 8679849635903925091L;
    private int deptNo;
    private String deptName;
    private String loc;

    public Dept() {
    }

    public Dept(int deptNo, String deptName, String loc) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.loc = loc;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
