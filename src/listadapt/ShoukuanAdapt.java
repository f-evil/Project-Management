package listadapt;

import java.util.ArrayList;

import com.tryee.xiangmuguanli.R;

import listadapt.KaifaAdapt.ItemView;
import model.KF;
import model.SK;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ShoukuanAdapt extends BaseAdapter {
	
	private Handler handler;
	private Context context;
	private ArrayList<SK> getList;
	LayoutInflater inflater;
	
	
	public ShoukuanAdapt(Context context,ArrayList<SK> list){
		this.context=context;
		this.getList=list;
		this.notifyDataSetInvalidated();
		inflater=LayoutInflater.from(context);
	}
	
	public ShoukuanAdapt(Context context){
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
			
			convertView=inflater.inflate(R.layout.list_shoukuan_type, null);
			itemView.listUser=(TextView)convertView.findViewById(R.id.user);
			itemView.listDaTe=(TextView)convertView.findViewById(R.id.date);
			itemView.list_4=(TextView)convertView.findViewById(R.id.list_4);
			convertView.setTag(itemView);
		}else {
			itemView=(ItemView)convertView.getTag();
		}
		
		SK sk=getList.get(position);
		itemView.listUser.setText(sk.getCjrname());
		itemView.listDaTe.setText(sk.getSkjafbsj());
		itemView.list_4.setText(sk.getSkjajj());
		
		
		return convertView;
	}
	
	public class ItemView{
		public TextView listUser;
		public TextView listDaTe;
		public TextView list_4;
	}
	
	public void setGetList(ArrayList<SK> getList) {
		
		this.getList = getList;
		//list = (ArrayList<GJ>)getList.clone();
		this.notifyDataSetInvalidated();
		
	}

}
