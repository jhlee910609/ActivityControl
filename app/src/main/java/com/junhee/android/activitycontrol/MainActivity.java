package com.junhee.android.activitycontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start, startFor;
    // 온클릭될 때마다 쓸데없이 new하는 것(메모리 사용)을 방지
    Intent intent;
    EditText main_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view setting
        // 위젯 개념
        start = (Button) findViewById(R.id.btnStart);
        startFor = (Button) findViewById(R.id.btnStartFor);
        // editEdit text
        main_editText = (EditText) findViewById(R.id.main_editText);

        // 온크리에이트 할 때, 메모리에 올려놓음
        intent = new Intent(MainActivity.this, SubActivity.class);

        start.setOnClickListener(this);
        startFor.setOnClickListener(this);
    }
    // 해결하기 위한 구분자를 파이널로 만들어줘야함
    public static final int BUTTON_START = 98;
    public static final int BUTTON_RESULT = 99;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // SubActivity에서 리턴 누르면 다시 넘어옴
        // 버튼을 눌릴 때, 담아서 보내는 코드

        Toast.makeText(this, "Result Code="+resultCode, Toast.LENGTH_SHORT).show();
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case BUTTON_RESULT:
                                            // Intent인 data에서 result 변수로 값을 꺼내는데
                                            // 값이 없을 경우 디폴트값으로 0을 사용함 (넣기 나름)
                    int result = data.getIntExtra("result", 0);
                    main_editText.setText("결과값 = " + result);
                    break;

                case BUTTON_START:
                    Toast.makeText(this, "start가 눌렸습니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            // 일반적인 Activity start
            case R.id.btnStart:
                intent.putExtra("key", "");
                startActivityForResult(intent, BUTTON_START);
                break;

            // 값을 돌렵다는 Activity start
            case R.id.btnStartFor:
                // SubActivity.finish(); 할 때, 결과값을 돌려준다 > MainActivity.onActivityResults(결과값을 넣어서 돌려줌)
                // 구조상은 callBack이지만 callBack이 아님
                intent.putExtra("key", main_editText.getText().toString());
                // (변수, 값)
                // <key, value> 형태로 값을 번달에 전달해줌
                // 액티비티 간의 데이터를 전달하기 위해 사용하는 일종의 바구니
                // 일종의 구분하려고 하는 코드
                startActivityForResult(intent, BUTTON_RESULT);
                break;
        }
    }
}

