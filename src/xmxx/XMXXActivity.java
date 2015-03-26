package xmxx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import model.Allxm;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tryee.xiangmuguanli.MainActivity;
import com.tryee.xiangmuguanli.R;
import com.tryee.xiangmuguanli.XiugaimmActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;





public class XMXXActivity extends Activity {

	
	ListView listView;
	public static int[] stateImage = new int[]{R.drawable.stategrey,R.drawable.statered,R.drawable.stateyellow,R.drawable.stategreen};
	List<Allxm> allxm = new ArrayList<Allxm>();
	Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.allxm);
		
		
		ImageButton xgmm_back=(ImageButton)findViewById(R.id.ls_back);
		xgmm_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentxg=new Intent(XMXXActivity.this,MainActivity.class);
				startActivity(intentxg);
			}
		});
		
		
		
		
		dialog = ProgressDialog.show(XMXXActivity.this, null, "dialog",true,true);
		
		
		
		new Thread(){
			public void run(){
				Looper.prepare();
				Log.e("thread", "start");
				//String url = "http://192.168.191.1:8001/operator_ajax.htm";
				
				//String url = "http://192.168.191.1:8001/hightern/integration_ajax.htm";
				
				allxm.clear();
				
				
				String url = "http://172.16.53.136:8080/xmgd/xmxx_ajaxlist.htm?ym=1";
				
				
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
						
						
						Log.e("getContent" + i,jsonList.get(i).getString("name"));
						
					}
					
					Log.e("allxm", allxm.size()+"");
					
					
					jsonList.get(0).getString("name");
					//Log.e("getContent", jsonList.get(0).getString("name"));
					//HtmlString = jsonObject.getString("content");
					//Toast.makeText(XMXXActivity.this, resId, duration)
					Message msg = new Message();
					
					msg.what = 1;
					
					handler.sendMessage(msg);
					
					
				}catch(Exception e){
					Log.e("Exception", e.toString());
					Message msg = new Message();
					
					msg.what = 1;
					
					handler.sendMessage(msg);
				}			
				
				Looper.loop();
			}
			
		}.start();
	
		
		

		
		
		
		
		
	}

	
	private void setListViewListener() {
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> a, View v, int position,long l) {
				//temp= (BuddyEntity) listView.getItemAtPosition(position);
				//Toast.makeText(XMXXActivity.this, listView.getItemAtPosition(position)+"���ݵ��", Toast.LENGTH_LONG).show();

				//Toast.makeText(XMXXActivity.this, allxm.get(position).getId()+"���ݵ��", Toast.LENGTH_LONG).show();
				//������ҳ��
//				Intent intent=new Intent(BuddyActivity.this,ChatActivity.class);
//				intent.putExtra("avatar", temp.getAvatar());
//				intent.putExtra("account",temp.getAccount());
//				intent.putExtra("nick", temp.getNick());
//				startActivity(intent);
				int key=(int)a.getItemIdAtPosition(position);
				switch (key) {
				case 0:
					Intent intent1=new Intent(XMXXActivity.this,ListActivity.class);
					startActivity(intent1);
					break;
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					
					break;
				case 9:
					
					break;


				default:
					break;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				Log.e("get ItemIDPosition",
	                    "" + a.getItemIdAtPosition(position));
	            Log.e("get ItemATPosition", "" + a.getItemAtPosition(position));
				
				
				
				
				
				
				
			}
        });
//        listView.setOnItemLongClickListener(new OnItemLongClickListener(){
//			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int position, long arg3) {
////				temp= (BuddyEntity) listView.getItemAtPosition(position);
////				listView.setOnCreateContextMenuListener(new OnCreateContextMenuListener(){
////					public void onCreateContextMenu(ContextMenu menu,
////							View arg1, ContextMenuInfo arg2) {
////						menu.setHeaderTitle("����");
////						menu.add(0,0,0,"����Ự");
////						menu.add(0,1,0,"ɾ�����");
////						menu.add(0,2,0,"�鿴��������");
////					}
////				});
////				return false;
//				Toast.makeText(XMXXActivity.this, listView.getItemAtPosition(position)+"�����", Toast.LENGTH_LONG).show();
//				return false;
//			}
//        });
	}
	
	
	
	private Handler handler = new Handler(){
		public void handleMessage(Message e){
			switch (e.what) {
			case 1:
				
				listView = (ListView) findViewById(R.id.xmList);
				if(allxm.size() == 0){
					Toast.makeText(XMXXActivity.this, "null",Toast.LENGTH_LONG).show();
				}else{

					//listView.setAdapter(new ALLXMadapter(XMXXActivity.this,allxm));
					setListViewListener();
					
				}
				//listView.setAdapter(this,allxm);
				dialog.dismiss();
				break;

			default:
				break;
			}
			
			
			
		}
	};
	
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xmgl, menu);
		return true;
	}

}
