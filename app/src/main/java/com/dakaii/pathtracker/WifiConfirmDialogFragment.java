package com.dakaii.pathtracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by dnakashi on 12/21/15.
 */
public class WifiConfirmDialogFragment extends DialogFragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";

    private int varTitle;
    private int varMessage;

    public static WifiConfirmDialogFragment newInstance(int title, int message){
        WifiConfirmDialogFragment fragment = new WifiConfirmDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TITLE, title);
        args.putInt(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        if (getArguments() != null){
            varTitle = getArguments().getInt(ARG_TITLE);
            varMessage = getArguments().getInt(ARG_MESSAGE);
        }
        return new AlertDialog.Builder(getActivity())
                .setTitle(varTitle)
                .setMessage(varMessage)
                .setNegativeButton(R.string.alert_dialog_no,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //do nothing
                            }
                        })
                .setPositiveButton(R.string.alert_dialog_yes,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialogInterface, int i){
                                ((MapsActivity)getActivity()).wifiOff();
                            }
                        }).create();
    }

}
