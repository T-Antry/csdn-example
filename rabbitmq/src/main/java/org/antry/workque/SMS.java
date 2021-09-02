package org.antry.workque;

public class SMS {
    /**
     * 接收人姓名
     */
    private String name;
    /**
     * 接收人电话
     */
    private String mobile;
    /**
     * 短信内容
     */
    private String content;

    public SMS(String name, String mobile, String content) {
        this.name = name;
        this.mobile = mobile;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
