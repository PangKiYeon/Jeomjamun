package com.example.jeomjamoon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class LibraryAdapter extends ArrayAdapter<library> {
    public LibraryAdapter(Context context, int resource, List<library> libraryList) {
        super(context, resource, libraryList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        library library = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.library_item, parent, false);
        }
        TextView tv = convertView.findViewById(R.id.library_name);
        TextView tv1 = convertView.findViewById(R.id.library_address);
        TextView tv2 = convertView.findViewById(R.id.library_number);

        tv.setText(library.getName());
        tv1.setText(library.getAddress());
        tv2.setText(library.getNumber());

        return convertView;
    }
}
