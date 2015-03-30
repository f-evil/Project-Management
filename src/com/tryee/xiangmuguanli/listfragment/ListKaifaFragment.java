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

import listadapt.DanganAdapt;
import listadapt.KaifaAdapt;
//import model.JD;
import model.KF;

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

public class ListKaifaFragment extends ListBaseFragment {

	private ListView listView;
	private KaifaAdapt adapter;
	private KF kfDate;
	View listKaiFaView=null;
	private ArrayList<KF> kfDateList;
	String newIdString;

	@Override
	protected View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		Bundle bundle = getArguments();
		String newIdString = bundle.getString("ID");
		//Toast.makeText(getActivity(), newIdString, Toast.LENGTH_LONG).show();

		listKaiFaView=inflater.inflate(R.layout.list_kaifa, null);

		adapter =new KaifaAdapt(getActivity());

		listView=(ListView)listKaiFaView.findViewById(R.id.XMListKaiFa);

		kfDateList =new ArrayList<KF>();

		getListData(newIdString);




		return listKaiFaView;
	}

	private void getListData(String newString){
		final String a = newString;
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Looper.prepare();
				kfDateList.clear();
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
							KF kfthisData=new KF();



							if(!jsonArray.getJSONObject(i).getString("cjrname").equals("")){
								kfthisData.setCjrname(jsonArray.getJSONObject(i).getString("cjrname"));
								Log.e("cjrname", kfthisData.getCjrname());
								}else {
									kfthisData.setCjrname(" ");
								}

							if (!jsonArray.getJSONObject(i).getString("kffbsj").equals("")) {
								kfthisData.setKffbsj(jsonArray.getJSONObject(i).getString("kffbsj"));
								Log.e("kffbsj", kfthisData.getKffbsj());
							}else {
								kfthisData.setKffbsj(" ");
							}

							if (!jsonArray.getJSONObject(i).getString("kfjj").equals("")) {
								kfthisData.setKfjj(jsonArray.getJSONObject(i).getString("kfjj"));
								Log.e("kfjj", kfthisData.getKfjj());
							}else {
								kfthisData.setKfjj(" ");
							}

							kfDateList.add(kfthisData);

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
				adapter.setGetList(kfDateList);
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
