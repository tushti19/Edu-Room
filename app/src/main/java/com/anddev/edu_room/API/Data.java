package com.anddev.edu_room.API;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("postId")
    private int postId;
    @SerializedName("userId")
    private int userId;
    @SerializedName("userName")
    private String userName;
    @SerializedName("text")
    private String text;
    @SerializedName("image")
    private String image;
    @SerializedName("createdOn")
    private String createdOn;
    @SerializedName("updatedOn")
    private String updatedOn;
    @SerializedName("studentClass")
    private String studentClass;
    @SerializedName("studentBoard")
    private String studentBoard;
    @SerializedName("subject")
    private String subject;
    @SerializedName("answerCount")
    private int answerCount;
    @SerializedName("upvoteCount")
    private int upvoteCount;
    @SerializedName("upvoted")
    private boolean upvoted ;
    @SerializedName("reportCount")
    private int reportCount;
    @SerializedName("reported")
    private  boolean reported;

    public Data(int postId, int userId, String userName, String text, String image, String createdOn, String updatedOn, String studentClass, String studentBoard, String subject, int answerCount, int upvoteCount, boolean upvoted, int reportCount, boolean reported) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.image = image;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.studentClass = studentClass;
        this.studentBoard = studentBoard;
        this.subject = subject;
        this.answerCount = answerCount;
        this.upvoteCount = upvoteCount;
        this.upvoted = upvoted;
        this.reportCount = reportCount;
        this.reported = reported;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentBoard() {
        return studentBoard;
    }

    public void setStudentBoard(String studentBoard) {
        this.studentBoard = studentBoard;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(int upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public boolean isUpvoted() {
        return upvoted;
    }

    public void setUpvoted(boolean upvoted) {
        this.upvoted = upvoted;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }
}
