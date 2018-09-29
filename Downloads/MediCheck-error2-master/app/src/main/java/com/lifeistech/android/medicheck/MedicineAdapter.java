package com.lifeistech.android.medicheck;

/**
 * Created by koizumikarin on 2018/03/28.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

public class MedicineAdapter extends RealmBaseAdapter<Medicine> implements ListAdapter {
    private Context context;
    private List<String> itemName;
    private Realm realm;

    public MedicineAdapter(OrderedRealmCollection<Medicine> realmResults, Context context) {
        super(realmResults);
        this.context = context;

    }
    public static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView createdAtTextView;
        LinearLayout layout;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.imageView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            createdAtTextView = (TextView) view.findViewById(R.id.createdAtTextView);
            layout = (LinearLayout) view.findViewById(R.id.layout);
        }
    }


    public View getView(int position, View convertView, final ViewGroup parent) {
        realm = Realm.getDefaultInstance();
        final ViewHolder viewHolder;

        // Viewを再利用している場合は新たにViewを作らない
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (adapterData != null) {
            final Medicine item = adapterData.get(position);
            viewHolder.imageView.setImageResource(item.resId);
            viewHolder.nameTextView.setText(item.name);
            viewHolder.createdAtTextView.setText(item.createdAt);
            viewHolder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MedicineRegistration.class);
                    Log.d("itemid", item.id + "");
                    intent.putExtra("id", item.id);
                    context.startActivity(intent);
                }
            });

            viewHolder.layout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    new AlertDialog.Builder(context)
                            .setTitle("削除")
                            .setMessage("本当に削除しますか？")
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String itemName = item.getName();
                                    realm.executeTransaction(new Realm.Transaction() {
                                        @Override
                                        public void execute(Realm realm) {
                                            RealmResults<Medicine> result = realm.where(Medicine.class).equalTo("id", item.getId()).findAll();
                                            result.get(0).deleteFromRealm();
                                        }
                                    });
                                    Toast.makeText(context,itemName + "を削除しました", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setNegativeButton("No",null)
                            .show();

                    return true;
                }
            });

        }

        return convertView;
    }
}