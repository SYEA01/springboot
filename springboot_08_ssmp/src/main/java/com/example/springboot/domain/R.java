package com.example.springboot.domain;

import lombok.Data;

@Data
public class R {
    private Boolean flag; // 代表是否成功
    private Object data;  // 代表返回的数据

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
