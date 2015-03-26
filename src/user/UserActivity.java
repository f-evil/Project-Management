package user;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tryee.xiangmuguanli.R;

import path.Url;

import model.Allxm;


import data.DataService;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class UserActivity extends Activity {
	
	Dialog dialog;
	private DataService dataService;
	Allxm ax;
	MyHandler mHandler;
	
	List<Allxm> allxm = new ArrayList<Allxm>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		
		
		
			UserHelper userHelper = new UserHelper(this);
	
			userHelper.getWritableDatabase().execSQL("delete from userAllxm");
	
			userHelper.getWritableDatabase().execSQL("update sqlite_sequence set seq=0 where name='userAllxm'");
			
			//userHelper.ExecuteNonQuery( "VACUUM")
			
			userHelper.close();
			
			
			
			
			dialog = ProgressDialog.show(this, "111", "messa111ge");
			
			UpdataUserAll();
			
			
			
	 
	}
			
			
	private void DeleteAll(){
		
	}
	
	
	@Override  
	protected void onDestroy() {  
	    super.onDestroy();  
	    //Ӧ�õ����һ��Activity�ر�ʱӦ�ͷ�DB  
	    dataService.close();  
	}
	
	
		
	
			
	private void UpdataUserAll(){
		new Thread(){
		
			public void run(){
				
			Looper.prepare();
			Log.e("thread", "start");

			  
			//String url = "http://192.168.191.1:8001/operator_ajax.htm";
			
			//String url = "http://192.168.191.1:8001/hightern/integration_ajax.htm";
			if (allxm != null) {
				allxm.clear();
			}
			
			
			
			String url = Url.URL+"xmgd/xmxx_ajax.htm";
			
			
			HttpClient client = new DefaultHttpClient();
			StringBuilder builder = new StringBuilder();
			
			HttpGet get = new HttpGet(url);
			
		try{
				
			HttpResponse response = client.execute(get);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			
			for(String s = reader.readLine();s != null;s=reader.readLine()){
				builder.append(s);
			}
				//����jsonarray
			JSONArray jsonArray = new JSONArray(builder.toString());
			Log.e("JsonArray.length",jsonArray.length()+"");
			
			
			
			//JSONObject jsonObject = (JSONObject) jsonArray.getJSONObject(69);
			
			//JSONObject jsonObject = new JSONObject(builder.toString());
			//Log.e("getjsonarray",jsonArray.toString());
			
			//Log.e("jsonArraylength", jsonArray.length()+"");
			//Log.e("getjsonarray", jsonArray.toString());
			//Log.e("getjsonyes", jsonObject.toString());
			ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
			
			//jsonArray.getInt(0);
			for(int i=0;i<jsonArray.length();i++){
			
				//ArrayList<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
			jsonList.add((JSONObject)jsonArray.getJSONObject(i));
			
			Allxm ax = new Allxm();
			
			ax.setId(Integer.parseInt(jsonArray.getJSONObject(i).getString("id")));
			
			Log.e("ID", ax.getId()+"");
			
			ax.setName(jsonArray.getJSONObject(i).getString("name"));
			
			ax.setCreate(jsonArray.getJSONObject(i).getString("cjrname"));
			
			ax.setCreatetime(jsonArray.getJSONObject(i).getString("qdsj"));
			
			//״̬1
			if(jsonArray.getJSONObject(i).getString("gjqk").equals("")){
				ax.setState1(0);
			}else{
			ax.setState1(Integer.parseInt(jsonArray.getJSONObject(i).getString("gjqk")));
			}
			
			//״̬2
			if(jsonArray.getJSONObject(i).getString("jdqk").equals("")){
				ax.setState1(0);
			}else{
				ax.setState2(Integer.parseInt(jsonArray.getJSONObject(i).getString("jdqk")));
			}
			//״̬3
			if(jsonArray.getJSONObject(i).getString("htqk").equals("")){
				ax.setState1(0);
			}else{
				ax.setState3(Integer.parseInt(jsonArray.getJSONObject(i).getString("htqk")));
			}
			//״̬4
			if(jsonArray.getJSONObject(i).getString("kfqk").equals("")){
				ax.setState1(0);
			}else{
				ax.setState4(Integer.parseInt(jsonArray.getJSONObject(i).getString("kfqk")));
			}
			//״̬5
			if(jsonArray.getJSONObject(i).getString("csqk").equals("")){
				ax.setState1(0);
			}else{
				ax.setState5(Integer.parseInt(jsonArray.getJSONObject(i).getString("csqk")));
			}
			//״̬6
			if(jsonArray.getJSONObject(i).getString("xqqk").equals("")){
				ax.setState1(0);
			}else{
				ax.setState6(Integer.parseInt(jsonArray.getJSONObject(i).getString("xqqk")));
			}
			//״̬7
			if(jsonArray.getJSONObject(i).getString("skqk").equals("")){
				ax.setState1(0);
			}else{
				ax.setState7(Integer.parseInt(jsonArray.getJSONObject(i).getString("skqk")));
			}
			//״̬8
			if(jsonArray.getJSONObject(i).getString("xmqk").equals("")){
				ax.setState1(0);
			}else{
				ax.setState8(Integer.parseInt(jsonArray.getJSONObject(i).getString("xmqk")));
			}
			
			allxm.add(ax);
			
			dataService = new DataService(UserActivity.this);
			
			dataService.saveUserAllxm(ax);
			dataService.close();
			
			Log.e("getContent" + i,jsonList.get(i).getString("name"));
				
			}
			
			Log.e("allxm", allxm.size()+"");
			
			
			jsonList.get(0).getString("name");
			//Log.e("getContent", jsonList.get(0).getString("name"));
			//HtmlString = jsonObject.getString("content");
			//Toast.makeText(XMXXActivity.this, resId, duration)
			mHandler = new MyHandler();
			Message msg = mHandler.obtainMessage(1);
				//Message msg = new Message();
			
			mHandler.sendMessage(msg);
			
		}catch(Exception e){
			Log.e("Exception", e.toString());
			mHandler = new MyHandler();
			Message msg = mHandler.obtainMessage(0);
					
					mHandler.sendMessage(msg);
				}			
				
				
				Looper.loop();
				
			}
			
			
		}.start();
			
	}
				
			
			
			
	private class MyHandler extends Handler{
		
		public void handleMessage(Message e){
			Log.e("msg get", "get");
			super.handleMessage(e);
			switch (e.what) {
			case 1:
				Log.e("dialog miss ", "success");
				dialog.dismiss();
				finish();
				break;
	
			default:
				Log.e("dialog miss ", "bed");
				dialog.dismiss();
				break;
			}
		}
	};
			
			
			@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
			
			return true;
		}
			
	}
