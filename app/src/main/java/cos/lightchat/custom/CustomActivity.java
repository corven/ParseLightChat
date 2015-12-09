package cos.lightchat.custom;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

import cos.lightchat.utils.TouchEffect;


public class CustomActivity extends FragmentActivity implements OnClickListener {

	/**
	 * listener для эффектов
	 */
	public static final TouchEffect TOUCH = new TouchEffect();

	/**
	 * Установка touch и click listener для view c id
	 */
	public View setTouchNClick(int id) {
		View v = setClick(id);
		if (v != null)
			v.setOnTouchListener(TOUCH);
		return v;
	}

	/**
	 * Установка click listener для view c id
	 */
	public View setClick(int id) {
		View v = findViewById(id);
		if (v != null)
			v.setOnClickListener(this);
		return v;
	}
	@Override
	public void onClick(View v) {
	}
}
