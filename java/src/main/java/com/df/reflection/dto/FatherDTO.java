package com.df.reflection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FatherDTO implements Serializable {

    /**
     * id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

}
