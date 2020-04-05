package com.soft1851.music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Music {
    private Integer musicId;
    private String musicName;
    private Integer type;
    private String url;
    private String singer;
}
