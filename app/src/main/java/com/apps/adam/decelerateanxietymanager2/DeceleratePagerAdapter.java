package com.apps.adam.decelerateanxietymanager2;

import android.content.Context;

import com.apps.adam.decelerateanxietymanager2.fragments.ConcernFragment;
import com.apps.adam.decelerateanxietymanager2.fragments.GratitudeFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DeceleratePagerAdapter extends FragmentPagerAdapter
{
    private Context mContext;

    public DeceleratePagerAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position) {
            case 0:
                return new GratitudeFragment();
            case 1:
                return new ConcernFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position) {
            case 0:
                return "Gratitude";
            case 1:
                return "Concnerns";
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}
