package com.cab.bean;

public class ResponseDetailsBean {
	 private Integer cbresponseDetailsId;
     private EventBean cbevents;
     private Integer status;
     private String url;
     private String msg;

    public ResponseDetailsBean() {
    }

	
    public ResponseDetailsBean(EventBean cbevents) {
        this.cbevents = cbevents;
    }
    public ResponseDetailsBean(EventBean cbevents, Integer status, String url, String msg) {
       this.cbevents = cbevents;
       this.status = status;
       this.url = url;
       this.msg = msg;
    }
   
    public Integer getCbresponseDetailsId() {
        return this.cbresponseDetailsId;
    }
    
    public void setCbresponseDetailsId(Integer cbresponseDetailsId) {
        this.cbresponseDetailsId = cbresponseDetailsId;
    }
    public EventBean getCbevents() {
        return this.cbevents;
    }
    
    public void setCbevents(EventBean cbevents) {
        this.cbevents = cbevents;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getMsg() {
        return this.msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
