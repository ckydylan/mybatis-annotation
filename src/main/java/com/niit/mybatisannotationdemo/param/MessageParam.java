package com.niit.mybatisannotationdemo.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Lenovo
 * @date : 2020/4/10 20：41
 * @description : Message的分页类
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class MessageParam extends PageParam{
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
