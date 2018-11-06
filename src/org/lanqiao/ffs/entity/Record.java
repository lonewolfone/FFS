package org.lanqiao.ffs.entity;

import java.util.Objects;

public class Record {
    private String pname;

    public Record(){

    }

    public Record(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(pname, record.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pname);
    }

    @Override
    public String toString() {
        return "Record{" +
                "pname='" + pname + '\'' +
                '}';
    }
}
