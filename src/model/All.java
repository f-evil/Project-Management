package model;

public class All {

	//TODO:在此添加相关字段属性
    //项目名
    private String name;
    //启动时间
    private String qdsj;
    //创建人姓名
    private String cjrname;
    //创建人id
    private Long cjrid;
    //客户单位
    private String khdw;
    //客户联系人
    private String khname;
    //联系号码
    private String lxhm;
    
    //跟进情况
    private Integer gjqk;
    //跟进情况跟进人
    private String gjqkname;
    //跟进情况时间
    private String gjqksj;
    //阶段情况
    private Integer jdqk;
    //阶段跟进人
    private String jdqkname;
    //阶段时间
    private String jdqksj;
    //合同签订情况
    private Integer htqk;
    //合同签订情况跟进人
    private String htqkname;
    //合同签订情况时间
    private String htqksj;
    //开发情况
    private Integer kfqk;
    //开发情况跟进人
    private String kfqkname;
    //开发情况时间
    private String kfqksj;
    //测试情况
    private Integer csqk;
    //测试情况跟进人
    private String csqkname;
    //测试情况时间
    private String csqksj;
    //需求变更阶段
    private Integer xqqk;
    //需求变更阶段跟进人
    private String xqqkname;
    //需求变更阶段时间
    private String xqqksj;
    //收款阶段
    private Integer skqk;
    //收款阶段跟进人
    private String skqkname;
    //收款阶段时间
    private String skqksj;
    //项目完成阶段
    private Integer xmqk;
    //项目完成阶段跟进人
    private String xmqkname;
    //项目完成阶段时间
    private String xmqksj;
    //售后阶段跟进人
    private String shname;
    //售后阶段时间
    private String shsj;
    
    
    //记录时间
    private String jlsj;
    //删除状态   （1：被删除    0：未被删除）
    private Integer  deletezt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQdsj() {
		return qdsj;
	}
	public void setQdsj(String qdsj) {
		this.qdsj = qdsj;
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
	public String getKhdw() {
		return khdw;
	}
	public void setKhdw(String khdw) {
		this.khdw = khdw;
	}
	public String getKhname() {
		return khname;
	}
	public void setKhname(String khname) {
		this.khname = khname;
	}
	public String getLxhm() {
		return lxhm;
	}
	public void setLxhm(String lxhm) {
		this.lxhm = lxhm;
	}
	public Integer getGjqk() {
		return gjqk;
	}
	public void setGjqk(Integer gjqk) {
		this.gjqk = gjqk;
	}
	public String getGjqkname() {
		return gjqkname;
	}
	public void setGjqkname(String gjqkname) {
		this.gjqkname = gjqkname;
	}
	public String getGjqksj() {
		return gjqksj;
	}
	public void setGjqksj(String gjqksj) {
		this.gjqksj = gjqksj;
	}
	public Integer getJdqk() {
		return jdqk;
	}
	public void setJdqk(Integer jdqk) {
		this.jdqk = jdqk;
	}
	public String getJdqkname() {
		return jdqkname;
	}
	public void setJdqkname(String jdqkname) {
		this.jdqkname = jdqkname;
	}
	public String getJdqksj() {
		return jdqksj;
	}
	public void setJdqksj(String jdqksj) {
		this.jdqksj = jdqksj;
	}
	public Integer getHtqk() {
		return htqk;
	}
	public void setHtqk(Integer htqk) {
		this.htqk = htqk;
	}
	public String getHtqkname() {
		return htqkname;
	}
	public void setHtqkname(String htqkname) {
		this.htqkname = htqkname;
	}
	public String getHtqksj() {
		return htqksj;
	}
	public void setHtqksj(String htqksj) {
		this.htqksj = htqksj;
	}
	public Integer getKfqk() {
		return kfqk;
	}
	public void setKfqk(Integer kfqk) {
		this.kfqk = kfqk;
	}
	public String getKfqkname() {
		return kfqkname;
	}
	public void setKfqkname(String kfqkname) {
		this.kfqkname = kfqkname;
	}
	public String getKfqksj() {
		return kfqksj;
	}
	public void setKfqksj(String kfqksj) {
		this.kfqksj = kfqksj;
	}
	public Integer getCsqk() {
		return csqk;
	}
	public void setCsqk(Integer csqk) {
		this.csqk = csqk;
	}
	public String getCsqkname() {
		return csqkname;
	}
	public void setCsqkname(String csqkname) {
		this.csqkname = csqkname;
	}
	public String getCsqksj() {
		return csqksj;
	}
	public void setCsqksj(String csqksj) {
		this.csqksj = csqksj;
	}
	public Integer getXqqk() {
		return xqqk;
	}
	public void setXqqk(Integer xqqk) {
		this.xqqk = xqqk;
	}
	public String getXqqkname() {
		return xqqkname;
	}
	public void setXqqkname(String xqqkname) {
		this.xqqkname = xqqkname;
	}
	public String getXqqksj() {
		return xqqksj;
	}
	public void setXqqksj(String xqqksj) {
		this.xqqksj = xqqksj;
	}
	public Integer getSkqk() {
		return skqk;
	}
	public void setSkqk(Integer skqk) {
		this.skqk = skqk;
	}
	public String getSkqkname() {
		return skqkname;
	}
	public void setSkqkname(String skqkname) {
		this.skqkname = skqkname;
	}
	public String getSkqksj() {
		return skqksj;
	}
	public void setSkqksj(String skqksj) {
		this.skqksj = skqksj;
	}
	public Integer getXmqk() {
		return xmqk;
	}
	public void setXmqk(Integer xmqk) {
		this.xmqk = xmqk;
	}
	public String getXmqkname() {
		return xmqkname;
	}
	public void setXmqkname(String xmqkname) {
		this.xmqkname = xmqkname;
	}
	public String getXmqksj() {
		return xmqksj;
	}
	public void setXmqksj(String xmqksj) {
		this.xmqksj = xmqksj;
	}
	public String getShname() {
		return shname;
	}
	public void setShname(String shname) {
		this.shname = shname;
	}
	public String getShsj() {
		return shsj;
	}
	public void setShsj(String shsj) {
		this.shsj = shsj;
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

    
}
