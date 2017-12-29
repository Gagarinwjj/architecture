package com.wjj.architecture.entity;


import android.support.annotation.NonNull;

import com.wjj.architecture.utils.Constants;

import io.reactivex.functions.Function;

/**
 * http包裹map转换及预处理
 * Created by wjj on 2017/4/7 16:08.
 */

public class WrapperFun<T> implements Function<Wrapper<T>, T> {

    @Override
    public T apply(@NonNull Wrapper<T> wrapper) throws Exception {
        if (wrapper.getErrCode() == 0) {
            T data = wrapper.getData();
            if (data != null) {
                return data;
            }
            return (T) new Object();
        }
        if (wrapper.getErrCode() == -206) {
            throw new RuntimeException(Constants.RESPONSE.UNAUTHORIZED);
        } else if (wrapper.getErrCode() == 1202) {
            throw new RuntimeException(Constants.RESPONSE.RE_LOGIN);
        }else if(wrapper.getErrCode() == 2202){
            throw new RuntimeException(Constants.RESPONSE.FRESH_NOT_EXIST);
        } else if(wrapper.getErrCode() == 2219){
            throw new RuntimeException(Constants.RESPONSE.PERMISSION_DENIED);
        }else if(wrapper.getErrCode() == 2220){
            throw new RuntimeException(Constants.RESPONSE.PUBLISH_FRESH_REFUSED + wrapper.getErrMsg());
        } else if(wrapper.getErrCode() == 3001){
            throw new RuntimeException(Constants.RESPONSE.PLEASE_WRITE_RESUME);
        }else if(wrapper.getErrCode() == 3002){
            throw new RuntimeException(Constants.RESPONSE.PLEASE_WRITE_RESUME_INFO);
        }else if(wrapper.getErrCode() == 3003){
            throw new RuntimeException(Constants.RESPONSE.PLEASE_WRITE_RESUME_COMPLETE);
        }else if(wrapper.getErrCode() == 3004){
            throw new RuntimeException(Constants.RESPONSE.ALREADY_DELIVER);
        }else if(wrapper.getErrCode() == 3005){
            throw new RuntimeException(Constants.RESPONSE.JOB_DELIVER_FAILURE);
        } else if(wrapper.getErrCode() == 3006){
            throw new RuntimeException(Constants.RESPONSE.JOB_IS_NOT_EXIST);
        }
        throw new RuntimeException(Constants.RESPONSE.API_ERROR + wrapper.getErrMsg());
    }
}
