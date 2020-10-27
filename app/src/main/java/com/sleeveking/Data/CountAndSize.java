package com.sleeveking.Data;

public class CountAndSize {

    public CountAndSize(String count, String size) {
        this.count = count;
        this.size = size;
    }

    public String getCount() {
        return count;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Data.CountAndSize{" +
                "count='" + count + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    private String count;
    private String size;
}
