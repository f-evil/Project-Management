package com.tryee.xiangmuguanli.listfragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import path.Url;

import listadapt.HetongAdapt;
import model.HT;
import com.tryee.xiangmuguanli.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListHetongFragment extends ListBaseFragment {

	private ListView listView;
	private HetongAdapt adapter;
	private HT htDate;
	View listHetongView=null;
	private ArrayList<HT> htDateList;
	String newIdString;


	@Override
	protected View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		Bundle bundle = getArguments();
		String newIdString = bundle.getString("ID");
		//Toast.makeText(getActivity(), newIdString, Toast.LENGTH_LONG).show();

		listHetongView=inflater.inflate(R.layout.list_hetong, null);

		adapter =new HetongAdapt(getActivity());

		listView=(ListView)listHetongView.findViewById(R.id.XMListHeTong);

		htDateList =new ArrayList<HT>();

		getListData(newIdString);


		return listHetongView;
	}

	private void getListData(String newString){
		final String a = newString;
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Looper.prepare();
				htDateList.clear();
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
							HT htthisData=new HT();



							if(!jsonArray.getJSONObject(i).getString("cjrname").equals("")){
								htthisData.setCjrname(jsonArray.getJSONObject(i).getString("cjrname"));
								Log.e("cjrname", htthisData.getCjrname());
								}else {
									htthisData.setCjrname(" ");
								}

							if (!jsonArray.getJSONObject(i).getString("jlsj").equals("")) {
								htthisData.setJlsj(jsonArray.getJSONObject(i).getString("jlsj"));
								Log.e("jlsj", htthisData.getJlsj());
							}else {
								htthisData.setJlsj(" ");
							}

							if (!jsonArray.getJSONObject(i).getString("kssj").equals("")) {
								htthisData.setKssj(jsonArray.getJSONObject(i).getString("kssj"));
								Log.e("kssj", htthisData.getKssj());
							}else {
								htthisData.setKssj(" ");
							}
							if (!jsonArray.getJSONObject(i).getString("jssj").equals("")) {
								htthisData.setJssj(jsonArray.getJSONObject(i).getString("jssj"));
								Log.e("jssj", htthisData.getJssj());
							}else {
								htthisData.setJssj(" ");
							}
							if (!jsonArray.getJSONObject(i).getString("qdsj").equals("")) {
								htthisData.setQdsj(jsonArray.getJSONObject(i).getString("qdsj"));
								Log.e("qdsj", htthisData.getQdsj());
							}else {
								htthisData.setQdsj(" ");
							}
							if (!jsonArray.getJSONObject(i).getString("htjj").equals("")) {
								htthisData.setHtjj(jsonArray.getJSONObject(i).getString("htjj"));
								Log.e("htjj", htthisData.getHtjj());
							}else {
								htthisData.setHtjj(" ");
							}






							htDateList.add(htthisData);

						}
						Message msg = new Message();

						msg.what = 0;

						handler.sendMessage(msg);
					}else {
						Message msg = new Message();

						msg.what = 99;

						handler.sendMessage(msg);
					}




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
				adapter.setGetList(htDateList);
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





	@Override
	protected void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub

	}

}
