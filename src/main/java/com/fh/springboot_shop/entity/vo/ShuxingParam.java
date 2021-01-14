package com.fh.springboot_shop.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;

public class ShuxingParam {

    private Integer page;

    private Integer size;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer endDate;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }
}
