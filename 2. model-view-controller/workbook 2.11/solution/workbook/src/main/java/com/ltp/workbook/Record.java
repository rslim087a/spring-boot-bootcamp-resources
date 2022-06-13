package com.ltp.workbook;

import java.math.BigDecimal;

public class Record {
    private String item;
    private BigDecimal revenue;
    private BigDecimal cost;


    public Record(String item, BigDecimal revenue, BigDecimal cost) {
        this.item = item;
        this.revenue = revenue;
        this.cost = cost;
    }


    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getRevenue() {
        return this.revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }



}
