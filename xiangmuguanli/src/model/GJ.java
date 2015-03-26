package model;

public class GJ {

	 //跟进情况
   
    private String content;
    //跟进时间
    private String gjsj;
    //创建人姓名
    private String cjrname;
    //创建人id
    private Long cjrid;
    //项目id
    private Long xmid;
    //项目名称
    private String xmmc;
    //跟进阶段状态
    private Integer gjjdzt;
    //是否共享
    private Integer ifshare;
	  //记录时间
    private String jlsj;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGjsj() {
		return gjsj;
	}
	public void setGjsj(String gjsj) {
		this.gjsj = gjsj;
	}
	public String getCjrname() {
		return cjrname;
	}
	public void setCjrname(String cjrname) {
		this.cjrname = cjrname;
	}
	public Long getCjrid() {
		return cjrid;
	}
	public void setCjrid(Long cjrid) {
		this.cjrid = cjrid;
	}
	public Long getXmid() {
		return xmid;
	}
	public void setXmid(Long xmid) {
		this.xmid = xmid;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public Integer getGjjdzt() {
		return gjjdzt;
	}
	public void setGjjdzt(Integer gjjdzt) {
		this.gjjdzt = gjjdzt;
	}
	public String getJlsj() {
		return jlsj;
	}
	public void setJlsj(String jlsj) {
		this.jlsj = jlsj;
	}
	public Integer getIfshare() {
		return ifshare;
	}
	public void setIfshare(Integer ifshare) {
		this.ifshare = ifshare;
	}
    
}
