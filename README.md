
## 엑셀파일의 헤더명을 다국어로 지정 가능

```java
@FieldsHeaders(
    i18n = {
        @Headers(code = KR, fields = {"이름", "나이", "주소"}),
        @Headers(code = EN, fields = {"name", "age", "address"})
    }
)
public class SampleData {

    private String name;
    private String age;
    private String address;

    public SampleData(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

```

## 스트리밍 다운로드 지원
