package com.lotushint.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName repair
 */
public class Repair implements Serializable {

    /**
     *
     */
    @NotNull(message = "[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
     * 报修时间
     */
    @NotNull(message = "[报修时间]不能为空")
    @ApiModelProperty("报修时间")
    private Date repairTime;
    /**
     * 报修物品
     */
    @NotBlank(message = "[报修物品]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("报修物品")
    @Length(max = 255, message = "编码长度不能超过255")
    private String goods;
    /**
     * 报修状态
     */
    @NotNull(message = "[报修状态]不能为空")
    @ApiModelProperty("报修状态")
    private Integer fkRepairGoodsStateId;
    /**
     * 房门号
     */
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("房门号")
    @Length(max = 255, message = "编码长度不能超过255")
    private String number;
    /**
     * 维修时间
     */
    @NotNull(message = "[维修时间]不能为空")
    @ApiModelProperty("维修时间")
    private Date maintenanceTime;
    /**
     * 预计花费
     */
    @ApiModelProperty("预计花费")
    private BigDecimal estimatedCost;
    /**
     * 实际花费
     */
    @ApiModelProperty("实际花费")
    private BigDecimal realCost;
    /**
     * 报修人
     */
    @NotNull(message = "[报修人]不能为空")
    @ApiModelProperty("报修人")
    private Integer fkRepairBaseId;
    /**
     * 报修详情
     */
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("报修详情")
    @Length(max = 255, message = "编码长度不能超过255")
    private String detail;

    /**
     *
     */
    private void setId(Integer id) {
        this.id = id;
    }

    /**
     * 报修时间
     */
    private void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    /**
     * 报修物品
     */
    private void setGoods(String goods) {
        this.goods = goods;
    }

    /**
     * 报修状态
     */
    private void setFkRepairGoodsStateId(Integer fkRepairGoodsStateId) {
        this.fkRepairGoodsStateId = fkRepairGoodsStateId;
    }

    /**
     * 房门号
     */
    private void setNumber(String number) {
        this.number = number;
    }

    /**
     * 维修时间
     */
    private void setMaintenanceTime(Date maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    /**
     * 预计花费
     */
    private void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    /**
     * 实际花费
     */
    private void setRealCost(BigDecimal realCost) {
        this.realCost = realCost;
    }

    /**
     * 报修人
     */
    private void setFkRepairBaseId(Integer fkRepairBaseId) {
        this.fkRepairBaseId = fkRepairBaseId;
    }

    /**
     * 报修详情
     */
    private void setDetail(String detail) {
        this.detail = detail;
    }


    /**
     *
     */
    private Integer getId() {
        return this.id;
    }

    /**
     * 报修时间
     */
    private Date getRepairTime() {
        return this.repairTime;
    }

    /**
     * 报修物品
     */
    private String getGoods() {
        return this.goods;
    }

    /**
     * 报修状态
     */
    private Integer getFkRepairGoodsStateId() {
        return this.fkRepairGoodsStateId;
    }

    /**
     * 房门号
     */
    private String getNumber() {
        return this.number;
    }

    /**
     * 维修时间
     */
    private Date getMaintenanceTime() {
        return this.maintenanceTime;
    }

    /**
     * 预计花费
     */
    private BigDecimal getEstimatedCost() {
        return this.estimatedCost;
    }

    /**
     * 实际花费
     */
    private BigDecimal getRealCost() {
        return this.realCost;
    }

    /**
     * 报修人
     */
    private Integer getFkRepairBaseId() {
        return this.fkRepairBaseId;
    }

    /**
     * 报修详情
     */
    private String getDetail() {
        return this.detail;
    }

}
