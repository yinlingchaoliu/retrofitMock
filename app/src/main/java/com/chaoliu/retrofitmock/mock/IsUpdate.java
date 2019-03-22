package com.chaoliu.retrofitmock.mock;

public class IsUpdate {

    /**
     * versions : 2.1.2
     * currFlag : 212
     * forceUpdate : 1
     * content :
     * downloadUrl :
     * releaseTime :
     * isUpdate : 2
     */

    private String versions;
    private int currFlag;
    private int forceUpdate;
    private String content;
    private String downloadUrl;
    private String releaseTime;
    private int isUpdate;

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public int getCurrFlag() {
        return currFlag;
    }

    public void setCurrFlag(int currFlag) {
        this.currFlag = currFlag;
    }

    public int getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(int forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(int isUpdate) {
        this.isUpdate = isUpdate;
    }

    @Override
    public String toString() {
        return "IsUpdate{" +
                "versions='" + versions + '\'' +
                ", currFlag=" + currFlag +
                ", forceUpdate=" + forceUpdate +
                ", content='" + content + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", isUpdate=" + isUpdate +
                '}';
    }
}
