package com.bluedon.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: testentity
 **/
@Data
@TableName("t_demo")
@ApiModel(value = "demo对象", description = "demo对象")
public class DemoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id", name = "id", example = "cc8b4c08a511aa101bae5d38ar1a6326")
    private String id;

    @Max(value = 60, message = "年龄输入不能大于60")
    @Min(value = 18, message = "年龄输入不能小于18")
    @ApiModelProperty(value = "年龄", name = "age", example = "20")
    private int age;

    @NotBlank(message = "密码不能为空")
    @Length(max = 20,message = "密码不能大于20个字符")
    @ApiModelProperty(value = "密码", name = "password", example = "pwd123")
    private String password;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", name = "userName", example = "hhong")
    private String userName;

    @ApiModelProperty(value = "testId", name = "testId", example = "cc8b4c08a511aa101bae5d38ar1a6326")
    private String testId;

    @Email
    @ApiModelProperty(value = "邮箱", name = "email", example = "abcd123@qq.com")
    private String email;

}
