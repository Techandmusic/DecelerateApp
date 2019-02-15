package com.apps.adam.decelerateanxietymanager2.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.adam.decelerateanxietymanager2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends ListAdapter<Card, CardAdapter.CardHolder>
{
    private OnItemClickListener listener;

    public CardAdapter()
    {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Card> DIFF_CALLBACK = new DiffUtil.ItemCallback<Card>()
    {
        @Override
        public boolean areItemsTheSame(@NonNull Card oldItem, @NonNull Card newItem)
        {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Card oldItem, @NonNull Card newItem)
        {
            return oldItem.getCardName().equals(newItem.getCardName()) &&
                    oldItem.getCardExtras().equals(newItem.getCardExtras());
        }
    };

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_layout, parent, false);
        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position)
    {
        Card currentCard = getItem(position);
        holder.cardTitle.setText(currentCard.getCardName());
    }

    public Card getCardAt(int position)
    {
        return getItem(position);
    }

    public void setOnItemClickListener()
    {
        this.listener = listener;
    }

    public interface OnItemClickListener
    {
        void onItemClick(Card card);
    }

    public class CardHolder extends RecyclerView.ViewHolder
    {
        private RecyclerView mRecyclerView;
        private FloatingActionButton FAB;
        private TextView cardTitle;

        public CardHolder(View itemView)
        {
            super(itemView);
            cardTitle = itemView.findViewById(R.id.card_title);
            mRecyclerView = itemView.findViewById(R.id.recycler);
            FAB = itemView.findViewById(R.id.add_card_button);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }
}
