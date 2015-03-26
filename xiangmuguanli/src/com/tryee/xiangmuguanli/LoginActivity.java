package com.tryee.xiangmuguanli;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.R.integer;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Activity {
	
	private String zh="a";
	private String mm="a";
	Dialog dialog;
	String getname = "111";
	String getpassword = "1";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_t);
		
		
		
		
		final EditText zhanghao=(EditText)findViewById(R.id.accountEt);
		final EditText mima=(EditText)findViewById(R.id.pwdEt);
		
		
		Button lixianButton=(Button)findViewById(R.id.lxsubBtn);
		lixianButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(LoginActivity.this, "新功能施工中...", Toast.LENGTH_SHORT).show();
				Intent tiaozhuanIntent=new Intent(LoginActivity.this,MainActivity.class);
				startActivity(tiaozhuanIntent);
				
			}
		});
		
		
		

		Button denglu=(Button)findViewById(R.id.subBtn);
		denglu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				

				dialog = ProgressDialog.show(LoginActivity.this,null, "login....",true,true);
				
				new Thread(){
					
					public void run() {
						Looper.prepare();
						// TODO 自动生成的方法存根
						if(zhanghao.getText().toString() != null|| mima.getText().toString() != null){
							
							
							//asyncTask.execute(1000);
							
							getname = zhanghao.getText().toString();
							getpassword = mima.getText().toString();
							
							
							Log.e("namepassword", getname+getpassword);
							
							String out = getChange(getname, getpassword);
							
							
							
							int a = Integer.parseInt(out);
							
							switch (a) {
							case 1:
								Message m = new Message();
								m.what = 1;
								handler.sendMessage(m);
								
								Intent intentdl=new Intent(LoginActivity.this,MainActivity.class);
								intentdl.putExtra("name", getname);
								startActivity(intentdl);
								finish();
								break;
							case 2:
								Message m1 = new Message();
								m1.what = 2;
								handler.sendMessage(m1);
								
							default:
								Message am = new Message();
								am.what = 3;
								handler.sendMessage(am);
								break;
							}
							
							
							
						}else {
							dialog.dismiss();
							Toast.makeText(LoginActivity.this, "!!!!", Toast.LENGTH_SHORT).show();
						}
						

						Looper.loop();
					}
					
				}.start();
				// TODO Auto-generated method stub
//				final String zhang=zhanghao.getText().toString();
//				final String mi=mima.getText().toString();
//				String zhang1="a";
//				String mi1="a";
//				if (zh.equals(zhang1)&&mm.equals(mi1)) {
//				//if (zhanghao.getText().toString().equals("aaa")) {
//					Intent intentdl=new Intent(LoginActivity.this,MainActivity.class);
//					startActivity(intentdl);
//				}else {
//					Toast.makeText(LoginActivity.this, "账号密码错误", Toast.LENGTH_SHORT).show();
//				}
			}
		});
	}

	
	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case 1:

				Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
					String out = getChange(getname, getpassword);
					if (out == "1") {
						Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
						dialog.dismiss();
						
//					}else {
//						Toast.makeText(LoginActivity.this, "bed", Toast.LENGTH_SHORT).show();
//						dialog.dismiss();
					}
					
				
				break;
			case 2:

				Toast.makeText(LoginActivity.this, "账号或密码出错...", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
				break;
			default:
				Toast.makeText(LoginActivity.this, "或检查您手机的网络连接是否连上...", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
				break;
			}
		}
	};

	
//	
	private String getChange(String name,String password){
		String url = "http://60.190.203.28:81/xmgd/glyxx_login.htm?glyzh="+name+"&glypwd="+password;
		Log.e("URL", url);
		
		//url = url +"?name=a";
		HttpClient client = new DefaultHttpClient();
		String out = null;
		try{
			HttpGet get = new HttpGet(url);
			HttpResponse response = client.execute(get);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					if(EntityUtils.toString(entity).equals("1")){
						out = "1";
					}else{
						out = "2";

						Log.e("entity != null", out);
					}
					
				}else {
					out = "3";
					Log.e("entity = null", out);
				}
			}
			//return out;
			
		}catch(Exception e){
			Log.e("e", e.toString());
			out = "3";
		}
		return out;
				
	}
	
	
	private void setDate() {
		
		FileOutputStream date=null;
		try {
			date = new FileOutputStream("date.txt");
			try {
				date.write("1".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			date.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	private   boolean cxDate(){
		
		try {
			FileInputStream date =new FileInputStream("date.txt");
			
			byte[] a=new byte[10];
			String b=new String(a);
			
			if (b=="1") {
				
				
				
				return true;
				
			}

			date.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
		
		
	}

	
	
	
}
