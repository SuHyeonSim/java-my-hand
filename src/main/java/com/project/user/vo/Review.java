package com.project.user.vo;

import java.sql.Timestamp;

public class Review {
    private int reviewNo;
    private int prodNo;
    private int userNo;
    private String reviewContent;
    private String reviewImgEnroll;
    private String reviewImgRevise;
    private Timestamp reviewDate;
    private int reviewStar;

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public int getProdNo() {
        return prodNo;
    }

    public void setProdNo(int prodNo) {
        this.prodNo = prodNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewImgEnroll() {
        return reviewImgEnroll;
    }

    public void setReviewImgEnroll(String reviewImgEnroll) {
        this.reviewImgEnroll = reviewImgEnroll;
    }

    public String getReviewImgRevise() {
        return reviewImgRevise;
    }

    public void setReviewImgRevise(String reviewImgRevise) {
        this.reviewImgRevise = reviewImgRevise;
    }

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getReviewStar() {
        return reviewStar;
    }

    public void setReviewStar(int reviewStar) {
        this.reviewStar = reviewStar;
    }

    @Override
    public String toString() {
        return "Review [reviewNo=" + reviewNo + ", prodNo=" + prodNo + ", userNo=" + userNo + ", reviewContent=" + reviewContent
                + ", reviewImgEnroll=" + reviewImgEnroll + ", reviewImgRevise=" + reviewImgRevise + ", reviewDate=" + reviewDate
                + ", reviewStar=" + reviewStar + "]";
    }
}
