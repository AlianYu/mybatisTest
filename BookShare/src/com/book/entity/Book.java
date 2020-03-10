package com.book.entity;

import java.util.Date;

public class Book {

    public int bookId;
    public String bookName;
    public String picture;
    public int ownerId;
    public int currentOwnerId;
    public String author;
    public String description;
    public Date createdTime;
    public Date updateTime;
    
    public Book() {
        super();
    }
    public Book(int bookId, String bookName, String picture, int ownerId, int currentOwnerId, String author,
            String description, Date createdTime, Date updateTime) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.picture = picture;
        this.ownerId = ownerId;
        this.currentOwnerId = currentOwnerId;
        this.author = author;
        this.description = description;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public int getCurrentOwnerId() {
        return currentOwnerId;
    }
    public void setCurrentOwnerId(int currentOwnerId) {
        this.currentOwnerId = currentOwnerId;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", picture=" + picture + ", ownerId=" + ownerId
                + ", currentOwnerId=" + currentOwnerId + ", author=" + author + ", description=" + description
                + ", createdTime=" + createdTime + ", updateTime=" + updateTime + "]";
    }
      
      
      

}
