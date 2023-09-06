package com.yupi.springbootinit.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.kapicommon.model.entity.InterfaceInfo;
import com.yupi.springbootinit.model.entity.Post;

/**
* @author 14768
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-07-25 21:30:58
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
