package cos.lightchat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import cos.lightchat.custom.CustomActivity;
import cos.lightchat.utils.Utils;

/**
 * Класс activity показывает экран регистрации для пользователя.
 */
public class Register extends CustomActivity {

	private EditText user;
	private EditText pwd;
	private EditText email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		setTouchNClick(R.id.btnReg);

		user = (EditText) findViewById(R.id.user);
		pwd = (EditText) findViewById(R.id.pwd);
		email = (EditText) findViewById(R.id.email);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);

		String u = user.getText().toString();
		String p = pwd.getText().toString();
		String e = email.getText().toString();
		if (u.length() == 0 || p.length() == 0 || e.length() == 0) {
			Utils.showDialog(this, R.string.err_fields_empty);
			return;
		}
		final ProgressDialog dia = ProgressDialog.show(this, null, getString(R.string.alert_wait));
		final ParseUser pu = new ParseUser();
		pu.setEmail(e);
		pu.setPassword(p);
		pu.setUsername(u);
		pu.signUpInBackground(new SignUpCallback() {
			@Override
			public void done(ParseException e) {
				dia.dismiss();
				if (e == null) {
					UserList.user = pu;
					startActivity(new Intent(Register.this, UserList.class));
					setResult(RESULT_OK);
					finish();
				}
				else {
					Utils.showDialog(Register.this, getString(R.string.err_singup) + " " +
							e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}
}
