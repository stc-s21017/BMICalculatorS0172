package jp.suntech.s21017.bmicalculators017;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogMaker extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dl_title);
        builder.setMessage(R.string.dl_message);

        DialogClickListener listener = new DialogClickListener();

        builder.setPositiveButton(R.string.confirm,listener);


        AlertDialog dialog = builder.create();

        return dialog;
    }

    private class DialogClickListener implements DialogInterface.OnClickListener
    {
        @Override
        public void onClick(DialogInterface dialog,int which)
        {
            String msg;
            switch (which)
            {
                case DialogInterface.BUTTON_POSITIVE:
                    msg = "計算します";
                    Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = "キャンセルしました";
                    Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
                    break;
            }


        }
    }

}
