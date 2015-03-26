package model;

public class SK {

	
	//TODO:在此添加相关字段属性
    //收款结案情况简介
   // @Lob
    private String skjajj;
    //收款结案文件
    private String path;
    //收款结案文件html
    private String htmlpath;
    //创建人姓名
    private String cjrname;
    //创建人id
    private Long cjrid;
    //项目id
    private Long xmid;
    //项目名称
    private String xmmc;
    //收款结案发布时间
    private String skjafbsj;
    //跟进阶段状态
    private Integer gjjdzt;
    //是否共享
    private Integer ifshare;
	  //记录时间
    private String jlsj;
	public String getSkjajj() {
		return skjajj;
	}
	public void setSkjajj(String skjajj) {
		this.skjajj = skjajj;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getHtmlpath() {
		return htmlpath;
	}
	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
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
	public String getSkjafbsj() {
		return skjafbsj;
	}
	public void setSkjafbsj(String skjafbsj) {
		this.skjafbsj = skjafbsj;
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
