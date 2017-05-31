# Activity Control

- startActivityForResult - Activity 사이에서 값 주고받기

### 1. startActivityForResult

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

### 3. onResultActivity

```

```



