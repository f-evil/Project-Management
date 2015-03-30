package com.tryee.xiangmuguanli.listfragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import path.Url;

import listadapt.CeshiAdapt;
import listadapt.KaifaAdapt;
import model.CS;
import model.KF;

import com.tryee.xiangmuguanli.LeftMenuFragment;
import com.tryee.xiangmuguanli.ListActionActivity;
import com.tryee.xiangmuguanli.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class ListCeshiFragment extends ListBaseFragment {


	private ListView listView;
	private CeshiAdapt adapter;
	private CS csDate;
	View listCeShiView=null;
	private ArrayList<CS> csDateList;
	String newIdString;

	//private Activity fActivity = new ListActionActivity();

	@Override
	protected View initView(LayoutInflater inflater) {
		Bundle bundle = getArguments();
		String newIdString = bundle.getString("ID");

		//Toast.makeText(getActivity(), newIdString, Toast.LENGTH_LONG).show();

		listCeShiView=inflater.inflate(R.layout.list_ceshi, null);

		adapter =new CeshiAdapt(getActivity());

		listView=(ListView)listCeShiView.findViewById(R.id.XMListCeShi);

		csDateList =new ArrayList<CS>();

		getListData(newIdString);







		// TODO Auto-generated method stub
		return listCeShiView;
	}

	private void getListData(String newString){
		final String a = newString;
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Looper.prepare();
				csDateList.clear();
				String url=Url.URL+""+a;
				Log.e("URLgetString", url);
				HttpClient client=new DefaultHttpClient();
				StringBuilder builder=new StringBuilder();
				HttpGet get=new HttpGet(url);

				try {
					HttpResponse response=client.execute(get);
					BufferedReader reader=new BufferedReader(new InputStreamReader(
							response.getEntity().getContent()));
					for (String s=reader.readLine();s!=null;s=reader.readLine()) {
						builder.append(s);
					}
					JSONArray jsonArray=new JSONArray(builder.toString());
					ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
					Log.e("jsonlength", jsonArray.length()+"");
					if (jsonArray.length() > 0) {
						for (int i=0;i<jsonArray.length();i++) {
							CS csthisData=new CS();



							if(!jsonArray.getJSONObject(i).getString("cjrname").equals("")){
								csthisData.setCjrname(jsonArray.getJSONObject(i).getString("cjrname"));
								Log.e("cjrname", csthisData.getCjrname());
								}else {
									csthisData.setCjrname(" ");
								}

							if (!jsonArray.getJSONObject(i).getString("csfbsj").equals("")) {
								csthisData.setCsfbsj(jsonArray.getJSONObject(i).getString("csfbsj"));
								Log.e("csfbsj", csthisData.getCsfbsj());
							}else {
								csthisData.setCsfbsj(" ");
							}

							if (!jsonArray.getJSONObject(i).getString("csjj").equals("")) {
								csthisData.setCsjj(jsonArray.getJSONObject(i).getString("csjj"));
								Log.e("csjj", csthisData.getCsjj());
							}else {
								csthisData.setCsjj(" ");
							}

							csDateList.add(csthisData);

						}
						Message msg = new Message();

						msg.what = 0;

						handler.sendMessage(msg);
					}else {
						Message msg = new Message();

						msg.what = 99;

						handler.sendMessage(msg);
					}

				}catch(JSONException e){
					Message jsonMessage = new Message();
					jsonMessage.what = 98;
					handler.sendMessage(jsonMessage);



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

	private Handler handler= new Handler(){
		public void handleMessage(Message e){
			switch (e.what) {
			case 1:
				Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
				break;
			case 0:
				Log.e("listView", "!!!!!!!");
				adapter.setGetList(csDateList);
				listView.setAdapter(adapter);
				//listView.setAdapter(new GenjinAdapt(getActivity(), gjDataList));
				break;
			case 99:
				Toast.makeText(getActivity(), "无数据...", Toast.LENGTH_LONG).show();
				break;
			case 98:
				Toast.makeText(getActivity(), "无此数据...", Toast.LENGTH_LONG).show();
				break;
			default:
				break;
			}
		}
	};







	@Override
	protected void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub

	}

}
