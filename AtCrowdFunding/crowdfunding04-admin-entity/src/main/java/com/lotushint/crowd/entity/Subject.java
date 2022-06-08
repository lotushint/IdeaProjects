package com.lotushint.crowd.entity;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/15 14:53
 * @package com.lotushint.crowd.entity
 * @description
 */
public class Subject {

    private String subjectName;
    private Integer subjectScore;

    public Subject() {

    }

    public Subject(String subjectName, Integer subjectScore) {
        super();
        this.subjectName = subjectName;
        this.subjectScore = subjectScore;
    }

    @Override
    public String toString() {
        return "Subject [subjectName=" + subjectName + ", subjectScore=" + subjectScore + "]";
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(Integer subjectScore) {
        this.subjectScore = subjectScore;
    }

}
