package com.book.entity;

public class KindBean {
    
    public int all;
    public int out;
    public int in;
    public int borrewed;
    
    
    public KindBean() {
        super();
    }


    public KindBean(int all, int out, int in, int borrewed) {
        super();
        this.all = all;
        this.out = out;
        this.in = in;
        this.borrewed = borrewed;
    }


    public int getAll() {
        return all;
    }


    public void setAll(int all) {
        this.all = all;
    }


    public int getOut() {
        return out;
    }


    public void setOut(int out) {
        this.out = out;
    }


    public int getIn() {
        return in;
    }


    public void setIn(int in) {
        this.in = in;
    }


    public int getBorrewed() {
        return borrewed;
    }


    public void setBorrewed(int borrewed) {
        this.borrewed = borrewed;
    }


    @Override
    public String toString() {
        return "KindBean [all=" + all + ", out=" + out + ", in=" + in + ", borrewed=" + borrewed + "]";
    }
    
    
    
    
    

}
