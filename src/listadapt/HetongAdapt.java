package listadapt;

import java.util.ArrayList;

import com.tryee.xiangmuguanli.R;

import listadapt.DanganAdapt.ItemView;
import model.HT;
import model.JD;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HetongAdapt extends BaseAdapter {
	
	private Handler handler;
	private Context context;
	private ArrayList<HT> getList;
	LayoutInflater inflater;
	
	public HetongAdapt(Context context,ArrayList<HT> list){
		this.context=context;
		this.getList=list;
		this.notifyDataSetInvalidated();
		inflater=LayoutInflater.from(context);
	}
	
	public HetongAdapt(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (getList==null) {
			return 0;
		}
		return getList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if (getList!=null) {
			return getList.get(position);
		}
		
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ItemView itemView=null;
		if(itemView==null){
			itemView=new ItemView();
			
			convertView=inflater.inflate(R.layout.list_hetong_type, null);
			itemView.listUser=(TextView)convertView.findViewById(R.id.user);
			itemView.listDaTe=(TextView)convertView.findViewById(R.id.date);
			itemView.listKssj=(TextView)convertView.findViewById(R.id.kssj);
			itemView.listJssj=(TextView)convertView.findViewById(R.id.jssj);
			itemView.listQdsj=(TextView)convertView.findViewById(R.id.qdsj);
			itemView.listHtbz=(TextView)convertView.findViewById(R.id.htbz);
			
			convertView.setTag(itemView);
		}else {
			itemView=(ItemView)convertView.getTag();
		}
		
		HT ht=getList.get(position);
		itemView.listUser.setText(ht.getCjrname());
		itemView.listDaTe.setText(ht.getJlsj());
		itemView.listKssj.setText(ht.getKssj());
		itemView.listJssj.setText(ht.getJssj());
		itemView.listQdsj.setText(ht.getQdsj());
		itemView.listHtbz.setText(ht.getHtjj());
		
		
		
		
		
		
		return convertView;
	}
	
	public class ItemView{
		public TextView listUser;
		public TextView listDaTe;
		public TextView listKssj;
		public TextView listJssj;
		public TextView listQdsj;
		public TextView listHtbz;
		
		
	}
	
	public void setGetList(ArrayList<HT> getList) {
		
		this.getList = getList;
		//list = (ArrayList<GJ>)getList.clone();
		this.notifyDataSetInvalidated();
		
	}

}
