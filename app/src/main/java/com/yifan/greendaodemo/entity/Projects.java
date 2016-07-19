package com.yifan.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.math.BigDecimal;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yifan on 2016/7/19.
 */
@Entity
public class Projects {

    @Id
    private Long id;

    private String projectName;

    private String description;

    private double totalMoney;

    public double getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 485260777)
    public Projects(Long id, String projectName, String description,
            double totalMoney) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.totalMoney = totalMoney;
    }

    @Generated(hash = 1005158188)
    public Projects() {
    }

    @Override
    public String toString() {
        return new StringBuilder("Projects: [").append("id:").append(id).append(",")
                .append("projectName:").append(projectName).append(",").append("description:").append(description).append(",")
                .append("totalMoney:").append(totalMoney).append(",").toString();
    }
}
