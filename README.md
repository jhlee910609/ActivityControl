# Activity Control

- startActivityForResult - Activity 사이에서 값 주고받기

### 1. startActivityForResult

##### 1.1. 개념

- startActivityForResutl(); 메소드에 전달되는 파라미터는 intent와 int 타입으로 된 값임
- 일반적으로 각각의 액티비티를 구현하기 위해 사용되며 여러 액티비티 중 어떤 것으로부터 온 응답인지 구분할 필요가 있기 때문에 이 메소드가 사용되는 경우가 많음


- [소스코드 전체보기](https://goo.gl/XuOG5m)


- 이 함수를 통해 Activity를 실행하면 실행된 Activity가 종료되면서 ''**onActivityResult**''함수를 호출해준다. 

```java
// activity를 실행하는 버튼을 구분하기 위한 flag
final int BUTTON_START = 90;
Intent intent = new Intent(this, );
startActivityForResult(intent, BUTTON_START);
```

### 2. setResult

- 호출되는 **sub.class**에 작성되는 코드

```java
Intent intent = new Intent(); // 이미 생성되어 있는 Activity를 사용하기 때문에 Context를 필요로하지 않음
intent.putExtra("result", "결과값");

// RESULT_OK는 부모 activity에 이미 정의되어 있는 플래그값으로 처리가 성공적이라는 것을 의미
// setResult 함수는 현재 activity에 Intent를 저장히기 때문에 18번
```

### 3. onActivityResult

- startActivityForResult(); > setResult();

```java
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
```



