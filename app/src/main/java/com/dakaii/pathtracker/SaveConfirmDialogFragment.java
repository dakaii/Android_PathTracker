package com.dakaii.pathtracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by dnakashi on 12/21/15.
 */
public class SaveConfirmDialogFragment extends DialogFragment {
    private static final String ARG_TITLE = "title";
    private static  final String ARG_MESSAGE = "message";

    private static int varTitle;
    private static String varMessage;

    public static SaveConfirmDialogFragment newInstance(int title, String message){
        SaveConfirmDialogFragment fragment = new SaveConfirmDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        if (getArguments() != null){
            varTitle = getArguments().getInt(ARG_TITLE);
            varMessage = getArguments().getString(ARG_MESSAGE);
        }
        return new AlertDialog.Builder(getActivity())
                .setTitle(varTitle)
                .setMessage(varMessage)
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //do nothing
                            }
                        }).setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int i){
                                //((MapsActivity)getActivity()).save();
                                ((MapsActivity)getActivity()).savePathViaCTP();
                            }
                        }).create();

    }


}
