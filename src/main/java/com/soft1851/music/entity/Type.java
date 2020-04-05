package com.soft1851.music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Type {
    private Integer id;
    private String typeName;
}
