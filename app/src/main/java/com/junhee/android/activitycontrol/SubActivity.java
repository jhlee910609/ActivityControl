package com.junhee.android.activitycontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button btnReturn;
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        // 1. 이전 activity에서 넘어온 intent 객체
        Intent intent = getIntent(); // 여기는 null이 안됨
        // 2. 값의 묶음을 꺼냄
        Bundle bundle = intent.getExtras(); // 여기는 전달될 값이 없으면 null이 됨
        // bundle에 값이 없을 때 무언가를 참고하려고 하면 NullPointerException이 뜸
        // null. 을 할 때 발생하는 예외가 NullPointerException;
        // 3. 단일 값을 꺼냄, 꺼내기 전에 null 체크 해줘야 함
        if (bundle != null) {
            value = bundle.getString("key");
            // 3.1. textView에 String value 가져와서 출력
            textView.setText(value);
        }
        // 위의 두 줄(2, 3번)을 합쳐놓은 method
        // ㄴ 자체적으로 bundle에 대한 null 처리 로직을 포함하고 있음
        // String value  = intent.getStringExtra("key");

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity에서 넘겨 받은 값을 int로 변환
                int num1 = Integer.parseInt(value);
                // 현재 Activity에 입력된 값을 받아서
                String temp = editText.getText().toString();
                // int로 변환
                int num2 = Integer.parseInt(temp);
                int result = num1 + num2;

                //결과값을 intent에 담아서
                Intent intent = new Intent();
                intent.putExtra("result", result);

                // setResult에 넘겨줌
                // 값을 넣어만 줌
                setResult(RESULT_OK, intent);

                // 현재 액티비티를 종료함
                // 시스템 자원을 사용할 일이 없기 때문에
                // 인텐트에 값만 담아서 주면됨
                // 새 액티비티를 열어서 넘겨줄 필요가 없음
                finish();

            }
        });
    }
}
