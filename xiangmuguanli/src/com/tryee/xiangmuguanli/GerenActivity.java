	package com.tryee.xiangmuguanli;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;


public class GerenActivity extends Activity {
	
	private String[] strs=new String[]{
			" 上传头像","修改密码","注销"
	};
	
	
	GestureDetector mGestureDetector;
	private int verticalMinDistance = 20;  
	private int minVelocity         = 0;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_geren);

		ListView gr_ls = (ListView)findViewById(R.id.gerenzhongxin_list);
		gr_ls.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strs));
		
		
		
		ImageButton button1=(ImageButton)findViewById(R.id.geren_back);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent back =new Intent(GerenActivity.this,MainActivity.class);
				startActivity(back);
				finish();
			}
		});
		
		
		
		
		gr_ls.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				int key=(int) parent.getItemIdAtPosition(position);
				switch (key) {
				case 0:
					Intent txIntent=new Intent(GerenActivity.this,TouxiangActivity.class);
					startActivity(txIntent);
					break;
				
				case 1:
					Intent xgIntent=new Intent(GerenActivity.this,XiugaimmActivity.class);
					startActivity(xgIntent);
					break;
					
				case 2:
					Intent zxIntent=new Intent(GerenActivity.this,LoginActivity.class);
					startActivity(zxIntent);
					break;

				default:
					break;
				}
				

				Log.i("get ItemIDPosition",
	                    "" + parent.getItemIdAtPosition(position));
	            Log.i("get ItemATPosition", "" + parent.getItemAtPosition(position));
				
				
			}
			
		});
	
	}
	

	

}
