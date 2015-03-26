package com.tryee.xiangmuguanli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Allxm;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONObject;

import xmxx.ALLXMadapter;

import xmxx.XMXXActivity;
import android.Manifest.permission;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import com.tryee.xiangmuguanli.fragment.BaseFragment;

public class HomeFragment extends BaseFragment {
	Activity homeActivity;
	ArrayList<Allxm> allxm = new ArrayList<Allxm>();
	ListView listView;
	Dialog dialog;
	private EditText seachEdit ;
	private ALLXMadapter adapter;
	@Override
	protected View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		dialog = ProgressDialog.show(getActivity(), null, "get...");
		View homeView = null;
		homeView = inflater.inflate(R.layout.frag_xiangmu, null);
		

		
		getListData();
		
		
		

		homeActivity = this.getActivity();
		seachEdit = (EditText)homeView.findViewById(R.id.search_view);
		adapter = new ALLXMadapter(homeActivity);
		
		
//		Dialog dialog;
//		//DialogFragment dialog = DialogFragment.instantiate(getActivity(), fname)
//		dialog = ProgressDialog.show(getActivity(), null, "dialog",true,true);
		
		listView = (ListView)homeView.findViewById(R.id.XMList);
		
		//listView.setAdapter(adapter);
		//adapter.setGetList(allxm);
//		seachEdit.addTextChangedListener(new TextWatcher() {
//			
//			@Override
//			public void onTextChanged(CharSequence s, int start, int before, int count) {
//				// TODO Auto-generated method stub
//				adapter.searchData(seachEdit.getText().toString());
//			}
//			
//			@Override
//			public void beforeTextChanged(CharSequence s, int start, int count,
//					int after) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void afterTextChanged(Editable s) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//	
		
		
		
		
		//listView = (ListView) findViewById(R.id.xmList);
		return homeView;
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub

		
	}
	private void getListData(){
		
		new Thread(){
			public void run(){
				Looper.prepare();
				Log.e("thread", "start");
				//String url = "http://192.168.191.1:8001/operator_ajax.htm";
				
				//String url = "http://192.168.191.1:8001/hightern/integration_ajax.htm";
				
				allxm.clear();
				
				
				//String url = "http://172.16.53.136:8080/xmgd/xmxx_ajaxlist.htm?ym=4";
				String url2="http://60.190.203.28:81";
				//String url2="http://192.168.191.1:8080";
				String url = url2+"/xmgd/xmxx_ajaxlist.htm?ym=1";
				try{
					
				HttpClient client = new DefaultHttpClient();
				StringBuilder builder = new StringBuilder();
				
				HttpConnectionParams.setConnectionTimeout(client.getParams(), 10*1000);
				HttpGet get = new HttpGet(url);
				
				
					HttpResponse response = client.execute(get);
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(
							response.getEntity().getContent()));
					
					for(String s = reader.readLine();s != null;s=reader.readLine()){
						builder.append(s);
					}
					//????jsonarray
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
						
						//??1
						if(jsonArray.getJSONObject(i).getString("gjqk").equals("")){
							ax.setState1(0);
						}else{
						ax.setState1(Integer.parseInt(jsonArray.getJSONObject(i).getString("gjqk")));
						}

						//??2
						if(jsonArray.getJSONObject(i).getString("jdqk").equals("")){
							ax.setState1(0);
						}else{
							ax.setState2(Integer.parseInt(jsonArray.getJSONObject(i).getString("jdqk")));
						}
						//??3
						if(jsonArray.getJSONObject(i).getString("htqk").equals("")){
							ax.setState1(0);
						}else{
							ax.setState3(Integer.parseInt(jsonArray.getJSONObject(i).getString("htqk")));
						}
						//??4
						if(jsonArray.getJSONObject(i).getString("kfqk").equals("")){
							ax.setState1(0);
						}else{
							ax.setState4(Integer.parseInt(jsonArray.getJSONObject(i).getString("kfqk")));
						}
						//??5
						if(jsonArray.getJSONObject(i).getString("csqk").equals("")){
							ax.setState1(0);
						}else{
							ax.setState5(Integer.parseInt(jsonArray.getJSONObject(i).getString("csqk")));
						}
						//??6
						if(jsonArray.getJSONObject(i).getString("xqqk").equals("")){
							ax.setState1(0);
						}else{
							ax.setState6(Integer.parseInt(jsonArray.getJSONObject(i).getString("xqqk")));
						}
						//??7
						if(jsonArray.getJSONObject(i).getString("skqk").equals("")){
							ax.setState1(0);
						}else{
							ax.setState7(Integer.parseInt(jsonArray.getJSONObject(i).getString("skqk")));
						}
						//??8
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
				}catch(ConnectTimeoutException e){
					Log.e("Exception", e.toString());
					Message timeMsg = new Message();
					timeMsg.what = 0;
					handler.sendMessage(timeMsg);
				}catch (IllegalArgumentException e) {
					Log.e("urlError", e.toString());
					Message msgUrl = new Message();
					msgUrl.what = 10;
					handler.sendMessage(msgUrl);
					// TODO: handle exception	
					
					
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

	
	private Handler handler = new Handler(){
		public void handleMessage(Message e){
			switch (e.what) {
			case 1:
				
				
				if(allxm.size() == 0){
					Toast.makeText(getActivity(), "null",Toast.LENGTH_LONG).show();
					dialog.dismiss();
				}else{
					//init();
					//listView.setAdapter(new ALLXMadapter(XMXXActivity.this,allxm));
					setListViewListener();
					dialog.dismiss();
				}
//				listView.setAdapter(new ALLXMadapter(homeActivity, allxm));
//				setListViewListener();
//				dialog.dismiss();
				break;
			case 0:
				
				dialog.dismiss();
				Log.e("msgTimeOut", "TimeOut0000000");
				
				Toast.makeText(getActivity(), "连接超时，请检查你得网络...", Toast.LENGTH_SHORT).show();
				
				break;
			case 10:
				Toast.makeText(getActivity(), "urlError", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
				break;
			default:
				break;
			}
			
			
			
		}
	};

	private void init(){
		
		homeActivity = this.getActivity();
		seachEdit = (EditText)homeActivity.findViewById(R.id.search_view);
		adapter = new ALLXMadapter(homeActivity);
		
		
//		Dialog dialog;
//		//DialogFragment dialog = DialogFragment.instantiate(getActivity(), fname)
//		dialog = ProgressDialog.show(getActivity(), null, "dialog",true,true);
		
		listView = (ListView)homeActivity.findViewById(R.id.XMList);
		
		listView.setAdapter(adapter);
		adapter.setGetList(allxm);
		seachEdit.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				adapter.searchData(seachEdit.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		

	}
	private void setListViewListener() {
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> a, View v, int position,long l) {
				//temp= (BuddyEntity) listView.getItemAtPosition(position);
				//Toast.makeText(XMXXActivity.this, listView.getItemAtPosition(position)+"??????", Toast.LENGTH_LONG).show();

				Toast.makeText(homeActivity, allxm.get(position).getId()+"??????", Toast.LENGTH_LONG).show();
				//?????????
//				Intent intent=new Intent(BuddyActivity.this,ChatActivity.class);
//				intent.putExtra("avatar", temp.getAvatar());
//				intent.putExtra("account",temp.getAccount());
//				intent.putExtra("nick", temp.getNick());
//				startActivity(intent);
			}
        });
        listView.setOnItemLongClickListener(new OnItemLongClickListener(){
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int position, long arg3) {
//				temp= (BuddyEntity) listView.getItemAtPosition(position);
//				listView.setOnCreateContextMenuListener(new OnCreateContextMenuListener(){
//					public void onCreateContextMenu(ContextMenu menu,
//							View arg1, ContextMenuInfo arg2) {
//						menu.setHeaderTitle("????");
//						menu.add(0,0,0,"?????");
//						menu.add(0,1,0,"??????");
//						menu.add(0,2,0,"??????????");
//					}
//				});
//				return false;
				Toast.makeText(homeActivity, listView.getItemAtPosition(position)+"?????", Toast.LENGTH_LONG).show();
				return false;
			}
        });
	}
	
	

	

}
