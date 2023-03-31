package com.quid.excel.controller.response;

import static com.quid.excel.component.Internationalization.EN;
import static com.quid.excel.component.Internationalization.KR;

import com.quid.excel.component.FieldsHeaders;
import com.quid.excel.component.Headers;

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
