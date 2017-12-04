package com.yun.base;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by lizhe on 2017/12/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Data
public class PageParam extends BaseParam{

    private Integer page = 0;
    private Integer size = 10;
    private Sort sort;

    public PageRequest transPageRequest(){

        return new PageRequest(this.page,this.size,this.sort);
    }

}
