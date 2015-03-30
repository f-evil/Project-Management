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
import model.JD;

import com.tryee.xiangmuguanli.GerenActivity;
import com.tryee.xiangmuguanli.LoginActivity;
import com.tryee.xiangmuguanli.R;
import com.tryee.xiangmuguanli.TouxiangActivity;
import com.tryee.xiangmuguanli.XiugaimmActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("CutPasteId")
public class ListDanganFragment extends ListBaseFragment {


	private ListView listView;
	private DanganAdapt adapter;
	private JD jdDate;
	View listDangAnView=null;
	private ArrayList<JD> jdDateList;
	String newIdString;
	private JD jdthisData=new JD();
	private SpannableString sStr;
	private String path;


	@Override
	protected View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		Bundle bundle = getArguments();
		newIdString = bundle.getString("ID");
		//Toast.makeText(getActivity(), newIdString, Toast.LENGTH_LONG).show();

		listDangAnView=inflater.inflate(R.layout.list_dangan, null);

		adapter =new DanganAdapt(getActivity());

		listView=(ListView)listDangAnView.findViewById(R.id.XMListDangAn);

		jdDateList =new ArrayList<JD>();

		getListData(newIdString);

		//LinearLayout dangan_ll=(LinearLayout)listDangAnView.findViewById(R.id.dangan_ll);
		ListView xiazailListView=(ListView)listDangAnView.findViewById(R.id.XMListDangAn);

		xiazailListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub



				String urlPath=""+path;
				Log.e("urlPath", urlPath);

				if (path!=null) {
					int key=(int) parent.getItemIdAtPosition(position);
					switch (key) {

					case 0:
						Intent intent=new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse(urlPath));
						startActivity(intent);
						break;

					default:
						break;
					}
				} else {
					return;
				}


			}
		});



		return listDangAnView;
	}

	private void getListData(String newString){
		final String a = newString;
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Looper.prepare();
				jdDateList.clear();
				String url=Url.URL+"/xmgd/xmxx_ajaxdetailjd.htm?id="+a;
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
							JD jdthisData=new JD();



							if(!jsonArray.getJSONObject(i).getString("cjrname").equals("")){
								jdthisData.setCjrname(jsonArray.getJSONObject(i).getString("cjrname"));
								Log.e("cjrname", jdthisData.getCjrname());
								}else {
									jdthisData.setCjrname(" ");
								}

							if (!jsonArray.getJSONObject(i).getString("wasj").equals("")) {
								jdthisData.setWasj(jsonArray.getJSONObject(i).getString("wasj"));
								Log.e("wasj", jdthisData.getWasj());
							}else {
								jdthisData.setWasj(" ");
							}

							if (!jsonArray.getJSONObject(i).getString("jdjj").equals("")) {
								jdthisData.setJdjj(jsonArray.getJSONObject(i).getString("jdjj"));
								Log.e("jdjj", jdthisData.getJdjj());
							}else {
								jdthisData.setJdjj(" ");
							}

							if (!jsonArray.getJSONObject(i).getString("path").equals("")) {
								jdthisData.setPath(jsonArray.getJSONObject(i).getString("path"));
								path=jdthisData.getPath();
								Log.e("path", jdthisData.getPath());
							}else {
								jdthisData.setPath(" ");
							}

							jdDateList.add(jdthisData);

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
				adapter.setGetList(jdDateList);
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
