package com.lotus.spring5.entity;

/**
 * @author hefan
 * @package com.lotus.spring5.entity
 * @date 2021/9/27 19:27
 * @description
 */
public class Book {
    private String userId;
    private String userName;
    private String usStatus;

    @Override
    public String toString() {
        return "Book{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", usStatus='" + usStatus + '\'' +
                '}';
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUsStatus(String usStatus) {
        this.usStatus = usStatus;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUsStatus() {
        return usStatus;
    }
}
