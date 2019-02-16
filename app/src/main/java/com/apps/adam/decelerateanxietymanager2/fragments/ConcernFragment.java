package com.apps.adam.decelerateanxietymanager2.fragments;

import android.content.Intent;
import android.view.View;

import com.apps.adam.decelerateanxietymanager2.AddCard;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ConcernFragment extends BaseFragment
{


    public static final String BOOK_ID = "Concerns";

    public ConcernFragment()
    {
        setBookName(BOOK_ID);
        FloatingActionButton actionButton = getFAB();
        actionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), AddCard.class);
                intent.putExtra("cardType", BOOK_ID);
                startActivity(intent);

            }
        });

    }


}
