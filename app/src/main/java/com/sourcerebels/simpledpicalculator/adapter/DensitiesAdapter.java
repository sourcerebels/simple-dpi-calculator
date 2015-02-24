package com.sourcerebels.simpledpicalculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sourcerebels.simpledpicalculator.R;
import com.sourcerebels.simpledpicalculator.model.ScreenDensity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Densities adapter.
 */
public class DensitiesAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    /**
     * Constructor.
     *
     * @param context Android context.
     */
    public DensitiesAdapter(Context context) {

        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ScreenDensity.values().length;
    }

    @Override
    public ScreenDensity getItem(int position) {
        return ScreenDensity.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ScreenDensityViewHolder holder;
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.adapter_screen_density, parent, false);
            holder = new ScreenDensityViewHolder(convertView);
            convertView.setTag(holder);

        } else {

            holder = (ScreenDensityViewHolder) convertView.getTag();
        }
        holder.decorate(getItem(position));
        return convertView;
    }

    /**
     * View holder class.
     */
    static class ScreenDensityViewHolder {

        @InjectView(R.id.tv_label)
        TextView mLabel;

        public ScreenDensityViewHolder(View layout) {
            ButterKnife.inject(this, layout);
        }

        /**
         * Decorates this view holder for given screen density.
         *
         * @param density Screen density definition.
         */
        public void decorate(ScreenDensity density) {
            mLabel.setText(density.toString());
        }
    }
}
