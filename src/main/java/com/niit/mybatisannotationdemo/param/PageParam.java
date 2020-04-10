package com.niit.mybatisannotationdemo.param;

import lombok.Data;

/**
 * @author : Lenovo
 * @date : 2020/4/10 20：42
 * @description :
 */
@Data
public class PageParam {
    private Integer beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;
    public int getBeginLine() {
        return pageSize * currentPage;
    }
}