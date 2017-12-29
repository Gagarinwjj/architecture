package com.wjj.architecture.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 租户实体
 * Created by wjj on 2017/12/29 10:35.
 */
@Entity
public class Tenant {
    @PrimaryKey
    private int uuid;
    /**
     * id : bac
     * img : http://img.cpdaily.com/schoolIcon/10020.jpg
     * name : 内控测试大学
     * shortName : 内控测试大学
     * joinType : CLOUD
     * idsUrl : https://wectest3.wisedu.com/iap
     * ampUrl : https://wectest3.wisedu.com/wec-portal-mobile/client
     * ampUrl2 :
     * priorityUrl : 1
     * appId :
     * appSecret :
     * tenantCode : 654321
     * msgUrl :
     * msgAccessToken :
     * msgAppId :
     * msgAppIdIos :
     * zgAppKey :
     * yktBalanceUrl :
     * yktTransferUrl :
     * yktQrCodeUrl :
     * xykUrl :
     * userShowCollege : DISABLE
     * scheduleOpenUrl :
     * scheduleDataUrl :
     * isIdsProxy : NO
     * tenantNameImg :
     * isNeedAlias : NO
     * modifyPassUrl :
     * modifyPassSuccessUrl :
     * modifyPassDescr :
     * taskUrl :
     * taskAppId :
     * circleShowType : ALL_SHOW
     * isShowHotList : YES
     * appStyleVersionId : bc1d3c7d-9538-4ff4-93d2-6347de3993f71514182646000
     * appStyleResUrl : http://img.cpdaily.com/wejia/20170928/1506583282258MoOxeScAVw5UvfDi7Z5n.zip
     * likeBtnSpace : INNER
     * iRobotUrl :
     */

    private String id;
    private String img;
    private String name;
    private String shortName;
    private String joinType;
    private String idsUrl;
    private String ampUrl;
    private String ampUrl2;
    private String priorityUrl;
    private String appId;
    private String appSecret;
    private String tenantCode;
    private String msgUrl;
    private String msgAccessToken;
    private String msgAppId;
    private String msgAppIdIos;
    private String zgAppKey;
    private String yktBalanceUrl;
    private String yktTransferUrl;
    private String yktQrCodeUrl;
    private String xykUrl;
    private String userShowCollege;
    private String scheduleOpenUrl;
    private String scheduleDataUrl;
    private String isIdsProxy;
    private String tenantNameImg;
    private String isNeedAlias;
    private String modifyPassUrl;
    private String modifyPassSuccessUrl;
    private String modifyPassDescr;
    private String taskUrl;
    private String taskAppId;
    private String circleShowType;
    private String isShowHotList;
    private String appStyleVersionId;
    private String appStyleResUrl;
    private String likeBtnSpace;
    private String iRobotUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getIdsUrl() {
        return idsUrl;
    }

    public void setIdsUrl(String idsUrl) {
        this.idsUrl = idsUrl;
    }

    public String getAmpUrl() {
        return ampUrl;
    }

    public void setAmpUrl(String ampUrl) {
        this.ampUrl = ampUrl;
    }

    public String getAmpUrl2() {
        return ampUrl2;
    }

    public void setAmpUrl2(String ampUrl2) {
        this.ampUrl2 = ampUrl2;
    }

    public String getPriorityUrl() {
        return priorityUrl;
    }

    public void setPriorityUrl(String priorityUrl) {
        this.priorityUrl = priorityUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public String getMsgAccessToken() {
        return msgAccessToken;
    }

    public void setMsgAccessToken(String msgAccessToken) {
        this.msgAccessToken = msgAccessToken;
    }

    public String getMsgAppId() {
        return msgAppId;
    }

    public void setMsgAppId(String msgAppId) {
        this.msgAppId = msgAppId;
    }

    public String getMsgAppIdIos() {
        return msgAppIdIos;
    }

    public void setMsgAppIdIos(String msgAppIdIos) {
        this.msgAppIdIos = msgAppIdIos;
    }

    public String getZgAppKey() {
        return zgAppKey;
    }

    public void setZgAppKey(String zgAppKey) {
        this.zgAppKey = zgAppKey;
    }

    public String getYktBalanceUrl() {
        return yktBalanceUrl;
    }

    public void setYktBalanceUrl(String yktBalanceUrl) {
        this.yktBalanceUrl = yktBalanceUrl;
    }

    public String getYktTransferUrl() {
        return yktTransferUrl;
    }

    public void setYktTransferUrl(String yktTransferUrl) {
        this.yktTransferUrl = yktTransferUrl;
    }

    public String getYktQrCodeUrl() {
        return yktQrCodeUrl;
    }

    public void setYktQrCodeUrl(String yktQrCodeUrl) {
        this.yktQrCodeUrl = yktQrCodeUrl;
    }

    public String getXykUrl() {
        return xykUrl;
    }

    public void setXykUrl(String xykUrl) {
        this.xykUrl = xykUrl;
    }

    public String getUserShowCollege() {
        return userShowCollege;
    }

    public void setUserShowCollege(String userShowCollege) {
        this.userShowCollege = userShowCollege;
    }

    public String getScheduleOpenUrl() {
        return scheduleOpenUrl;
    }

    public void setScheduleOpenUrl(String scheduleOpenUrl) {
        this.scheduleOpenUrl = scheduleOpenUrl;
    }

    public String getScheduleDataUrl() {
        return scheduleDataUrl;
    }

    public void setScheduleDataUrl(String scheduleDataUrl) {
        this.scheduleDataUrl = scheduleDataUrl;
    }

    public String getIsIdsProxy() {
        return isIdsProxy;
    }

    public void setIsIdsProxy(String isIdsProxy) {
        this.isIdsProxy = isIdsProxy;
    }

    public String getTenantNameImg() {
        return tenantNameImg;
    }

    public void setTenantNameImg(String tenantNameImg) {
        this.tenantNameImg = tenantNameImg;
    }

    public String getIsNeedAlias() {
        return isNeedAlias;
    }

    public void setIsNeedAlias(String isNeedAlias) {
        this.isNeedAlias = isNeedAlias;
    }

    public String getModifyPassUrl() {
        return modifyPassUrl;
    }

    public void setModifyPassUrl(String modifyPassUrl) {
        this.modifyPassUrl = modifyPassUrl;
    }

    public String getModifyPassSuccessUrl() {
        return modifyPassSuccessUrl;
    }

    public void setModifyPassSuccessUrl(String modifyPassSuccessUrl) {
        this.modifyPassSuccessUrl = modifyPassSuccessUrl;
    }

    public String getModifyPassDescr() {
        return modifyPassDescr;
    }

    public void setModifyPassDescr(String modifyPassDescr) {
        this.modifyPassDescr = modifyPassDescr;
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    public String getTaskAppId() {
        return taskAppId;
    }

    public void setTaskAppId(String taskAppId) {
        this.taskAppId = taskAppId;
    }

    public String getCircleShowType() {
        return circleShowType;
    }

    public void setCircleShowType(String circleShowType) {
        this.circleShowType = circleShowType;
    }

    public String getIsShowHotList() {
        return isShowHotList;
    }

    public void setIsShowHotList(String isShowHotList) {
        this.isShowHotList = isShowHotList;
    }

    public String getAppStyleVersionId() {
        return appStyleVersionId;
    }

    public void setAppStyleVersionId(String appStyleVersionId) {
        this.appStyleVersionId = appStyleVersionId;
    }

    public String getAppStyleResUrl() {
        return appStyleResUrl;
    }

    public void setAppStyleResUrl(String appStyleResUrl) {
        this.appStyleResUrl = appStyleResUrl;
    }

    public String getLikeBtnSpace() {
        return likeBtnSpace;
    }

    public void setLikeBtnSpace(String likeBtnSpace) {
        this.likeBtnSpace = likeBtnSpace;
    }

    public String getIRobotUrl() {
        return iRobotUrl;
    }

    public void setIRobotUrl(String iRobotUrl) {
        this.iRobotUrl = iRobotUrl;
    }
}
