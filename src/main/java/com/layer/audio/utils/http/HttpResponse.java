package com.layer.audio.utils.http;

import lombok.*;

/**
 * Http请求标准相应类
 *
 * @author cdyangyang18
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HttpResponse {

    private boolean isSuccess;

    private Integer code;

    private String result;

}
