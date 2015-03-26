package com.tryee.xiangmuguanli;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class XiugaimmActivity extends Activity {
	
	private final long SPLASH_LENGTH = 200000; 
	Dialog dialog;
	Dialog dialog4 ;
	Dialog dialog2;
	Dialog dialog3;
	Dialog dialog1;
	String getname = "1";
	String getpassword = "1";
	String getnewpassword="1";
	String yzpassword="1";
	Handler handler2 = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_xiugaimm);
		
		ImageButton xgmm_back=(ImageButton)findViewById(R.id.mm_back);
		
		
		
		xgmm_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentxg=new Intent(XiugaimmActivity.this,GerenActivity.class);
				startActivity(intentxg);
			}
		});
		
		
		final EditText zhanghaoEditText=(EditText)findViewById(R.id.accountEd);
		final EditText mimaEditText=(EditText)findViewById(R.id.pwdEd);
		final EditText mimaEditText2=(EditText)findViewById(R.id.pwdEd2);
		Button xiugaibButton=(Button)findViewById(R.id.xgBtn);
		xiugaibButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				new Thread(){
					public void run() {
						Looper.prepare();
						
						
						if (zhanghaoEditText.getText().toString()!=null&&
								mimaEditText.getText().toString()!=null) {
							
							if (mimaEditText2.getText().toString()!=null) {
								getname=zhanghaoEditText.getText().toString();
								getpassword=mimaEditText.getText().toString();
								getnewpassword=mimaEditText2.getText().toString();
								Log.e("npn", getname+getpassword+getnewpassword);
								
								String out=getChange(getname, getpassword, getnewpassword);
								int a=Integer.parseInt(out);
								
								switch (a) {
								case 1:
									
									Message m=new Message();
									m.what=1;
									yzpassword=getnewpassword;
									handler.sendMessage(m);
									break;
								case 2:

									Message m1=new Message();
									m1.what=2;
									handler.sendMessage(m1);
									break;
								case 3:
		
									Message m2=new Message();
									m2.what=3;
									handler.sendMessage(m2);
									break;
									

								default:
									break;
								}
								
								
							} else {
								Message m3=new Message();
								m3.what=4;
								handler.sendMessage(m3);
							}
							
						} else {
							Message m3=new Message();
							m3.what=4;
							handler.sendMessage(m3);
						}
						
					}	
				
					
				}.start();
				
				
			}
		});
		

	}
	
	
	private Handler handler=new Handler(){
		public void handleMessage(Message msg){
			switch (msg.what) {
			case 1:
				Toast.makeText(XiugaimmActivity.this, "修改成功，新密码："+yzpassword, Toast.LENGTH_SHORT).show();
				Log.e("xmm", yzpassword);
				break;
				
			case 2:
				Toast.makeText(XiugaimmActivity.this, "账号密码错误", Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(XiugaimmActivity.this, "请输入完整", Toast.LENGTH_SHORT).show();
				break;
				
			default: 
				Toast.makeText(XiugaimmActivity.this, "检查您的手机网络是否正常", Toast.LENGTH_SHORT).show();
				
				break;
			}
			Looper.loop();
		}
		
	};
	
	private String getChange(String name,String password,String newpassword){
		String url="http://60.190.203.28:81/xmgd/glyxx_edit.htm?glyzh="+name+"&glypwd="+password+"&nglypwd="+newpassword;
		Log.e("URL", url);
		HttpClient client=new DefaultHttpClient();
		String out=null;
		try{
			HttpGet get=new HttpGet(url);
			HttpResponse response=client.execute(get);
			if(response.getStatusLine().getStatusCode()==200){
				HttpEntity entity=response.getEntity();
				if(EntityUtils.toString(entity).equals("1")){
					out="1";
					Log.e("entity!=null",out);
				}else {
					out="2";
				}	
			}else {
				out="3";
			}
		}catch(Exception e){
			Log.e("e",e.toString());
			out="3";
		}
		return out;
	}


}
