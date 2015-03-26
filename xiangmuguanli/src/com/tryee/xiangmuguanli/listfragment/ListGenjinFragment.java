package com.tryee.xiangmuguanli.listfragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.security.auth.PrivateCredentialPermission;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import path.Url;

import xmxx.ALLXMadapter;
import xmxx.XMXXActivity;

import listadapt.GenjinAdapt;
import model.Allxm;
import model.GJ;

import com.tryee.xiangmuguanli.R;

import android.R.string;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.StaticLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListGenjinFragment extends ListBaseFragment {
	
	
	private ListView listView;
	
	Dialog dialog;
	private GenjinAdapt adapter;
	View listGenjinView=null;
	private GJ gjData;
	private ArrayList<GJ> gjDataList;
	String newIdString;

	@Override
	protected View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		Bundle bundle = getArguments();
		newIdString = bundle.getString("ID");
		//Toast.makeText(getActivity(), newIdString, Toast.LENGTH_LONG).show();
		
		//dialog = ProgressDialog.show(getActivity(), null, "get...");
		listGenjinView=inflater.inflate(R.layout.list_genjin, null);
		//listGenjinActivity=this.getActivity();
		
		adapter = new GenjinAdapt(getActivity());
		
		listView = (ListView)listGenjinView.findViewById(R.id.XMListGenJin);
		
		gjDataList = new ArrayList<GJ>();
		
		getListData();

		//listView.setAdapter(new GenjinAdapt(getActivity(), gjDataList));
		
		
		
		return listGenjinView;
		//return inflater.inflate(R.layout.list_genjin, null);
	}
	

	private Handler handler=new Handler(){
		public void handleMessage(Message e){
			switch (e.what) {
			case 1:
				
					
					Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
					
				break;
			case 0:
				Log.e("listView", "!!!!!!!");
				adapter.setGetList(gjDataList);
				listView.setAdapter(adapter);
				//listView.setAdapter(new GenjinAdapt(getActivity(), gjDataList));
				break;
			case 99:
				Toast.makeText(getActivity(), "无数据...", Toast.LENGTH_LONG).show();
				break;
			default:
				break;
			}
		}
	};
	
	
	
	private void getListData(){
		//final String newString;
		//newString = urlid;
		new Thread(){
			public void run(){
				Looper.prepare();
				//gjDataList.clear();
				gjDataList.clear();
				//allxm.clear();
				//String url1="http://192.168.191.1:8080";
				String url=Url.URL+"/xmgd/xmxx_ajaxdetailgj.htm?id=" + newIdString;
				Log.e("url", url);
				Log.e("newIdString", newIdString);
				HttpClient client=new DefaultHttpClient();
				StringBuilder builder=new StringBuilder();
				
				HttpGet get=new HttpGet(url);
				try {
					HttpResponse response=client.execute(get);
					BufferedReader reader=new BufferedReader(new InputStreamReader(
							response.getEntity().getContent()));
					for(String s=reader.readLine();s!=null;s=reader.readLine()){
						builder.append(s);
					}
					JSONArray jsonArray=new JSONArray(builder.toString());
					ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
					Log.e("jsonlength", jsonArray.length()+"");
					if(jsonArray.length() > 0){
					for(int i=0;i<jsonArray.length();i++){

						//ArrayList<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
						
						
						//jsonList.add((JSONObject)jsonArray.getJSONObject(i));
						GJ gjthisData = new GJ();
						
						if(!jsonArray.getJSONObject(i).getString("cjrname").equals("")){
						gjthisData.setCjrname(jsonArray.getJSONObject(i).getString("cjrname"));
						Log.e("cjrname", gjthisData.getCjrname());
						}else {
							gjthisData.setCjrname(" ");
						}
						
						if (!jsonArray.getJSONObject(i).getString("xmmc").equals("")) {
							gjthisData.setXmmc(jsonArray.getJSONObject(i).getString("xmmc"));
							Log.e("xmmc", gjthisData.getXmmc());
						}else {
							gjthisData.setXmmc(" ");
						}
						
						if (!jsonArray.getJSONObject(i).getString("gjsj").equals("")) {
							gjthisData.setGjsj(jsonArray.getJSONObject(i).getString("gjsj"));
							Log.e("gjsj", gjthisData.getGjsj());
						}else {
							gjthisData.setGjsj(" ");
						}
						
						if (!jsonArray.getJSONObject(i).getString("content").equals("")) {
							gjthisData.setContent(jsonArray.getJSONObject(i).getString("content"));
							Log.e("content", gjthisData.getContent());
						}else {
							gjthisData.setContent(" ");
						}
						
						//
						
						gjDataList.add(gjthisData);
						Log.e("gjlistlength", gjDataList.size()+"");
					
						}
					
					Message msg = new Message();
					
					msg.what = 0;
					
					handler.sendMessage(msg);
					
					}else {
						Message msg = new Message();
						
						msg.what = 99;
						
						handler.sendMessage(msg);
					}
					//jsonList.get(0).getString("name");
					
					
				
					
				} catch (Exception e) {
					// TODO: handle exception
					Log.e("Exception", e.toString());
					Message msg = new Message();
					
					msg.what = 1;
					
					handler.sendMessage(msg);
				}
				Looper.loop();
				
			}
		}.start();
		
	}
	
	
	

	@Override
	protected void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub

	}

}
