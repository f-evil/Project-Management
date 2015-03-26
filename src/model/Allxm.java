package model;

public class Allxm {
	private int id;
	private String name;
	private String create;
	private String createtime;
	private int state1;
	private int state2;
	private int state3;
	private int state4;
	private int state5;
	private int state6;
	private int state7;
	private int state8;
	
	public Allxm(){
		
	}
	
	public Allxm(String name,String create,String createtime,int state1,int state2,
			int state3,int state4,int state5,int state6,int state7,int state8){
		this.name = name;
		this.create = create;
		this.createtime = createtime;
		this.state1 = state1;
		this.state2 = state2;
		this.state3 = state3;
		this.state4 = state4;
		this.state5 = state5;
		this.state6 = state6;
		this.state7 = state7;
		this.state8 = state8;
		
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getState1() {
		return state1;
	}
	public void setState1(int state1) {
		this.state1 = state1;
	}
	public int getState2() {
		return state2;
	}
	public void setState2(int state2) {
		this.state2 = state2;
	}
	public int getState3() {
		return state3;
	}
	public void setState3(int state3) {
		this.state3 = state3;
	}
	public int getState4() {
		return state4;
	}
	public void setState4(int state4) {
		this.state4 = state4;
	}
	public int getState5() {
		return state5;
	}
	public void setState5(int state5) {
		this.state5 = state5;
	}
	public int getState6() {
		return state6;
	}
	public void setState6(int state6) {
		this.state6 = state6;
	}
	public int getState7() {
		return state7;
	}
	public void setState7(int state7) {
		this.state7 = state7;
	}
	public int getState8() {
		return state8;
	}
	public void setState8(int state8) {
		this.state8 = state8;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
