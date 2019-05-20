package com.application.lastfm_lloyds.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.lastfm_lloyds.data.model.LightSearchResult;
import com.application.lastfm_lloyds.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.TextUtils.isEmpty;

public class CombinedResultAdapter extends RecyclerView.Adapter<CombinedResultAdapter.ViewHolder> {

    private List<LightSearchResult> lightSearchResult;
    private OnItemClickListener listener;

    public CombinedResultAdapter(final List<LightSearchResult> lightSearchResult) {
       this.lightSearchResult = lightSearchResult;
    }

    public void addItems(List<LightSearchResult> lightSearchResult) {
        this.lightSearchResult = lightSearchResult;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.combined_search_result_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final LightSearchResult searchResult = lightSearchResult.get(position);
        holder.head.setText(searchResult.getHead());
        holder.description.setText(searchResult.getType());

        if(!isEmpty(searchResult.getImage())) {
            Picasso.get()
                    .load(searchResult.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.searchImg);
        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).into(holder.searchImg);
        }
    }

    @Override
    public int getItemCount() {
        return lightSearchResult.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.CombinedSearchAdapter_TextView_resultTxt)
        TextView head;
        @BindView(R.id.CombinedSearchAdapter_TextView_resultDescriptionTxt)
        TextView description;
        @BindView(R.id.CombinedSearchAdapter_ImageView_resultImg)
        ImageView searchImg;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if(listener != null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(itemView, position);
                    }
                }
            });

        }
    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(final View itemView, final int position);
    }
}
