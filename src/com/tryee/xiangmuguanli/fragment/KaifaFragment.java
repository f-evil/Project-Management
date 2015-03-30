package com.tryee.xiangmuguanli.fragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
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

import com.tryee.xiangmuguanli.ListActionActivity;
import com.tryee.xiangmuguanli.R;
import com.tryee.xiangmuguanli.R.id;

import android.R.integer;
import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.os.Handler;

public class KaifaFragment extends BaseFragment {

	private Activity kaifaActivity;
	private ListView listView;
	private Activity mActivity;
	public static int[] stateImage = new int[]{R.drawable.stategrey,R.drawable.statered,R.drawable.stateyellow,R.drawable.stategreen};
	ArrayList<Allxm> allxm = new ArrayList<Allxm>();
	Dialog dialog;
	private EditText seachEdit;
	private ALLXMadapter adapter;
	View kaifaView = null;
	@Override
	protected View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub


		dialog = ProgressDialog.show(getActivity(), null, "get...");

		kaifaView = inflater.inflate(R.layout.frag_kaifa, null);
		kaifaActivity = this.getActivity();
//		Dialog dialog;
//		//DialogFragment dialog = DialogFragment.instantiate(getActivity(), fname)
//		dialog = ProgressDialog.show(getActivity(), null, "dialog",true,true);
		adapter = new ALLXMadapter(getActivity());
		seachEdit = (EditText)kaifaView.findViewById(R.id.search_view);
		listView = (ListView)kaifaView.findViewById(R.id.XMList);
		//listView.setAdapter(adapter);
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


		GetListData();


		//return inflater.inflate(R.layout.frag_kaifa, null);




		return kaifaView;





	}

	private void init(View view){
		adapter = new ALLXMadapter(getActivity(),allxm);
		seachEdit = (EditText)view.findViewById(R.id.search_view);
		listView = (ListView)view.findViewById(R.id.XMList);
		listView.setAdapter(adapter);
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



	private void GetListData() {


		new Thread(){
			public void run(){
				Looper.prepare();
				Log.e("thread", "start");


				allxm.clear();


				String url2="";

				String url = url2+"";


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
					Log.e("JsonArray",jsonArray.toString());



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

						//Log.e("ID", ax.getId()+"");

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

					Log.e("allxm", allxm.size()+"111");


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



	@Override
	protected void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub

	}

	//listView = (ListView) kaifaActivity.findViewById(R.id.XMList);

	private Handler handler = new Handler(){
		public void handleMessage(Message e){
			switch (e.what) {
			case 1:

				//listView = (ListView) kaifaActivity.findViewById(R.id.XMList);
				if(allxm.size() == 0){
					Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
					getActivity().finish();
				}else{
					adapter.setGetList(allxm);
					//init(kaifaView);
					listView.setAdapter(adapter);
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



	private void setListViewListener() {
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> a, View v, int position,long l) {

				int a2=allxm.get(position).getId();
				String a3=String.valueOf(a2);
				Log.e("a2", a3);

				Intent intentdianji=new Intent(getActivity(),ListActionActivity.class);
				intentdianji.putExtra("id", a3);
				startActivity(intentdianji);

			}
        });

	}









}
