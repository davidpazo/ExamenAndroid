package com.example.dpazolopez.examenandroid;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dpazolopez.examenandroid.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";


    private DummyContent.DummyItem mItem;


    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        //8 RECOGEMOS TEXTVIEW Y LO PONEMOS A CEERO
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.textView)).setText("Item " + mItem.id);
        }


        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(this);

        return rootView;
    }

    /** onClick del boton */
    @Override
    public void onClick(View v) {
        Listener.cerrar();
    }

    private MyFragmentListener Listener;

    /** Aqui definimos el fragment que se va a cerrar desde la interfaz */

    public interface MyFragmentListener {
        void cerrar();
    }
    /** Cuando este fragment se una a la activity onAttach se ejecuta
     * y al context se le pasa la activity */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Listener = (MyFragmentListener) context;
    }
}
