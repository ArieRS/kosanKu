package com.ui.kosanku;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arierachmadsyulistyo on 12/12/14.
 */

public class TambahKosFrgament extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tambah_kos, container, false);

        return rootView;
    }
}
