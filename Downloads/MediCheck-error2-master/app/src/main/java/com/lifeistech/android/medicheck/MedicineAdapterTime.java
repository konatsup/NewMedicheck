package com.lifeistech.android.medicheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by koizumikarin on 2018/04/08.
 */

public class MedicineAdapterTime extends RealmBaseAdapter<Medicine> implements ListAdapter {
    private Context context;
    private List<String> itemName;
    private Realm realm;
    public MedicineAdapterTime(OrderedRealmCollection<Medicine> realmResults, Context context) {
        super(realmResults);
        this.context = context;

    }

    public static class ViewHolder {
        TextView nameTextView;
        LinearLayout layout;

        public ViewHolder(View view) {
            nameTextView = (TextView) view.findViewById(R.id.nameTextView2);
            layout = (LinearLayout) view.findViewById(R.id.layout2);
        }
    }

    public View getView(int position, View convertView, final ViewGroup parent) {
        realm = Realm.getDefaultInstance();
        final ViewHolder viewHolder;

        // Viewを再利用している場合は新たにViewを作らない
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine2, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (adapterData != null) {
            final Medicine item = adapterData.get(position);
            viewHolder.nameTextView.setText(item.name);
            viewHolder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MedicineRegistration.class);
                    Log.d("itemid", item.id + "");
                    intent.putExtra("id", item.id);
                    context.startActivity(intent);
//                    String itemName = item.getName();
//                    realm.executeTransaction(new Realm.Transaction() {
//                        @Override
//                        public void execute(Realm realm) {
//                            RealmResults<Medicine> result = realm.where(Medicine.class).equalTo("id", item.getId()).findAll();
//                            result.get("朝");
//                        }
//                    });
                }

            });
        }
        return convertView;
    }
}
