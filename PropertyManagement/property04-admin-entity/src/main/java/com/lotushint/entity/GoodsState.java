package com.lotushint.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
* 物品状态
* @TableName goods_state
*/
public class GoodsState implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 物品状态
    */
    @NotBlank(message="[物品状态]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("物品状态")
    @Length(max= 255,message="编码长度不能超过255")
    private String state;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 物品状态
    */
    private void setState(String state){
    this.state = state;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 物品状态
    */
    private String getState(){
    return this.state;
    }

}
