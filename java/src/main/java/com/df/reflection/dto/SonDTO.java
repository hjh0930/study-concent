package com.df.reflection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author dongfeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SonDTO  extends FatherDTO {
    /**
     * id
     */
    private String sonId;
    /**
     * 姓名
     */
    private String sonName;

    /**
     * 年龄
     */
    private String sonAge;

    public String sex;

    public String a;
}
