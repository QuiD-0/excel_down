
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

## 스트리밍 다운로드 지원(개발중)

 대량의 데이터를 다운로드 할 때, 메모리를 많이 사용하지 않고 다운로드 가능
 
 https://jaimemin.tistory.com/2191
