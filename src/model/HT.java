package model;

public class HT {

	//TODO:在此添加相关字段属性
	  //合同简介
	   // @Lob
	    private String htjj;
	    //合同文件
	    private String path;
	    //合同文件html
	    private String htmlpath;
	    //创建人姓名
	    private String cjrname;
	    //创建人id
	    private Long cjrid;
	    //项目id
	    private Long xmid;
	    //项目名称
	    private String xmmc;
	    //合同发布时间
	    private String htfbsj;
	    //开始时间
	    private String kssj;
	    //结束时间
	    private String jssj;
	    //签订时间
	    private String qdsj;
	    //乙方名称
	    private String jfname;
	    //跟进阶段状态
	    private Integer gjjdzt;
	    //是否共享
	    private Integer ifshare;
		  //记录时间
	    private String jlsj;
		public String getHtjj() {
			return htjj;
		}
		public void setHtjj(String htjj) {
			this.htjj = htjj;
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
		public String getHtfbsj() {
			return htfbsj;
		}
		public void setHtfbsj(String htfbsj) {
			this.htfbsj = htfbsj;
		}
		public String getKssj() {
			return kssj;
		}
		public void setKssj(String kssj) {
			this.kssj = kssj;
		}
		public String getJssj() {
			return jssj;
		}
		public void setJssj(String jssj) {
			this.jssj = jssj;
		}
		public String getQdsj() {
			return qdsj;
		}
		public void setQdsj(String qdsj) {
			this.qdsj = qdsj;
		}
		public String getJfname() {
			return jfname;
		}
		public void setJfname(String jfname) {
			this.jfname = jfname;
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
