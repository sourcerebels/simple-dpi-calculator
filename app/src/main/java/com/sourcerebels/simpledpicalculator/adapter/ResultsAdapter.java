/*
Copyright 2015 Eduardo Manuel Rodríguez Castillo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.sourcerebels.simpledpicalculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sourcerebels.simpledpicalculator.R;
import com.sourcerebels.simpledpicalculator.model.Result;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Results adapter.
 */
public class ResultsAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Result> mResults;
    private String mSuffix;

    /**
     * Constructor.
     *
     * @param context Android Context.
     */
    public ResultsAdapter(Context context) {

        mInflater = LayoutInflater.from(context);
        mSuffix = context.getString(R.string.pixels_suffix);
    }

    /**
     * Sets the results for this adapter.
     *
     * @param results Result list.
     */
    public void setResults(List<Result> results) {

        mResults = results;
        notifyDataSetChanged();;
    }

    @Override
    public int getCount() {

        return mResults != null ? mResults.size() : 0;
    }

    @Override
    public Result getItem(int position) {

        return mResults != null && mResults.size() > position ? mResults.get(position) : null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ResultViewHolder holder;
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.adapter_result, parent, false);
            holder = new ResultViewHolder(convertView);
            convertView.setTag(holder);

        } else {

            holder = (ResultViewHolder) convertView.getTag();
        }
        holder.decorate(getItem(position), mSuffix);
        return convertView;
    }

    /**
     * Results view holder class.
     */
    static class ResultViewHolder {

        @InjectView(R.id.tv_density_label)
        TextView mDensityLabel;

        @InjectView(R.id.tv_pixel_value)
        TextView mPixelValue;

        /**
         * Constructor.
         *
         * @param layout Inflated layout.
         */
        public ResultViewHolder(View layout) {

            ButterKnife.inject(this, layout);
        }

        public void decorate(Result result, String suffix) {

            mDensityLabel.setText(result.getDensity().toString());
            mPixelValue.setText(String.valueOf(result.getValue() + " " + suffix));
        }
    }
}
