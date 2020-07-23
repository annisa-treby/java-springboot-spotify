package com.enigma.sepotifay.entity;

public class Counter {
    private Integer count;

    public Counter() {
        this.count = 0;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void increment(){
        count++;
    }
}
