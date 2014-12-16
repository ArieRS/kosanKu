package com.ui.kosanku;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ui.common.SessionManager;

public class LoginFragment extends Fragment {
	
	EditText edtusername, edtpass;
	Button buttonLogin;
	SessionManager session;
	
	public LoginFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        
        edtusername = (EditText) rootView.findViewById(R.id.edtUsername);
        edtpass = (EditText) rootView.findViewById(R.id.edtPassword);
        buttonLogin = (Button) rootView.findViewById(R.id.buttonLogin);
        session = new SessionManager(getActivity());
        logicControl();
        return rootView;
    }

	private void logicControl() {
		buttonLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			new AlertDialog.Builder(getActivity())
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle("Login")
				.setMessage("Login Success")
				.setPositiveButton(android.R.string.yes,
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface arg0,
									int arg1) {
								edtusername.setText("admin");
								edtpass.setText("admin");
								session.createLoginSession("admin", "admin", "admin");
								Intent intent = new Intent(getActivity(), MainActivity.class);
								startActivity(intent);
							}
						}).create().show();
			}
		});
	}
}
