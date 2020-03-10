package com.book.entity;

public class PageBean {
    public int totalcount;//一共多少条数据
    public int pagesize;  //每页显示多少条数据
    public int pagecount; //总共多少页
    public int currentPage;//当前多少页
    public int offset;     //偏移量
    
    
    
    public PageBean() {
        super();
    }



    public PageBean(int totalcount, int pagesize, int pagecount, int currentPage, int offset) {
        super();
        this.totalcount = totalcount;
        this.pagesize = pagesize;
        this.pagecount = pagecount;
        this.currentPage = currentPage;
        this.offset = offset;
    }



    public int getTotalcount() {
        return totalcount;
    }



    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }



    public int getPagesize() {
        if(pagesize==0) {
            pagesize=5;//每页显示5条数据
        }
        
        return pagesize;
    }



    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }



    public int getPagecount() {//总页数
        if(totalcount<1) {
            totalcount=0;
            return totalcount;
        }
        pagecount = (totalcount-1) / getPagesize()+1;
        return pagecount;
    }



    


    public int getCurrentPage() {
        
        if(currentPage<1) {
            currentPage=1;
        }
        if(currentPage>getPagecount()) {
            currentPage=getPagecount();
        }
        return currentPage;
    }



    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }



    public int getOffset() {//偏移量
        offset = (getCurrentPage()-1)*getPagesize();
        return offset;
    }



    


    @Override
    public String toString() {
        return "PageBean [totalcount=" + totalcount + ", pagesize=" + pagesize + ", pagecount=" + pagecount
                + ", currentPage=" + currentPage + ", offset=" + offset + "]";
    }
    
    

    
    
}
