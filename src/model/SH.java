package model;

public class SH {

	
	//TODO:在此添加相关字段属性
    //售后情况简介
    //@Lob
    private String shjj;
    //开发源码文件
    private String path;
    //开发源码文件html
    private String htmlpath;
    //创建人姓名
    private String cjrname;
    //创建人id
    private Long cjrid;
    //项目id
    private Long xmid;
    //项目名称
    private String xmmc;
    //开发完成发布时间
    private String shfbsj;
    //售后联系人
    private String shlxr;
    //售后联系人号码
    private String lxrhm;
    //访问网址
    private String fwwz;

    //记录时间
    private String jlsj;
    //删除状态   （1：被删除    0：未被删除）
    private Integer  deletezt;
    //是否共享
    private Integer ifshare;
	public String getShjj() {
		return shjj;
	}
	public void setShjj(String shjj) {
		this.shjj = shjj;
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
	public String getShfbsj() {
		return shfbsj;
	}
	public void setShfbsj(String shfbsj) {
		this.shfbsj = shfbsj;
	}
	public String getShlxr() {
		return shlxr;
	}
	public void setShlxr(String shlxr) {
		this.shlxr = shlxr;
	}
	public String getLxrhm() {
		return lxrhm;
	}
	public void setLxrhm(String lxrhm) {
		this.lxrhm = lxrhm;
	}
	public String getFwwz() {
		return fwwz;
	}
	public void setFwwz(String fwwz) {
		this.fwwz = fwwz;
	}
	public String getJlsj() {
		return jlsj;
	}
	public void setJlsj(String jlsj) {
		this.jlsj = jlsj;
	}
	public Integer getDeletezt() {
		return deletezt;
	}
	public void setDeletezt(Integer deletezt) {
		this.deletezt = deletezt;
	}
	public Integer getIfshare() {
		return ifshare;
	}
	public void setIfshare(Integer ifshare) {
		this.ifshare = ifshare;
	}
    
}
