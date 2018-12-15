package br.ufpb.dcx.sisalfa.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rynzler.literarum.R;

import java.util.List;

import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;

public class ContextAdapter extends BaseAdapter {

    private Activity context;
    private List<SisContext> contexts;
    private static LayoutInflater inflater = null;

    public ContextAdapter(Activity context, List<SisContext> events) {
        this.context = context;
        this.contexts = events;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contexts.size();
    }

    @Override
    public SisContext getItem(int position) {
        return contexts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.context_components, null): itemView;
        ImageView image = itemView.findViewById(R.id.imgCtx);
        TextView name = itemView.findViewById(R.id.nameContext);
        SisContext selectedContext = contexts.get(position);
        name.setText(selectedContext.getName());
        image.setImageBitmap(AndroidUtils.ByteArrayToBitmap(selectedContext.getImageBytes()));
        return itemView;
    }
}
