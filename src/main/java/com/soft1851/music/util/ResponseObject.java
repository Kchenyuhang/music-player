package com.soft1851.music.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/3/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private  Integer code;
    private  String msg;
    private  Object data;
}
