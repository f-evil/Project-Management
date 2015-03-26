package data;

import user.UserHelper;
import model.Allxm;
import android.content.Context;

public class DataService {

	private UserHelper userHelper;
	
	public DataService(Context context){
		userHelper = new UserHelper(context);
	}
	
	public void closeDate(String DateName){
		userHelper.getWritableDatabase().close();
	}
	
	public void saveUserAllxm(Allxm allxm){
		userHelper.getWritableDatabase().execSQL(
				"insert into userAllxm (newid , name, newcreate, createtime, state1, state2," +
				"state3, state4, state5, state6, state7, state8) values(?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{allxm.getId(), allxm.getName(),allxm.getCreate(), allxm.getCreatetime(),
						allxm.getState1(), allxm.getState2(), allxm.getState3(),
						allxm.getState4(), allxm.getState5(), allxm.getState6(),
						allxm.getState7(), allxm.getState8()});
	}
	
	
	
	public void close(){
		userHelper.close();
	}
	
}
