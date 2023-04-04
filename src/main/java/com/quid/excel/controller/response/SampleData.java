package com.quid.excel.controller.response;

import static com.quid.excel.component.Internationalization.EN;
import static com.quid.excel.component.Internationalization.KO;

import com.quid.excel.component.ExcelExclude;
import com.quid.excel.component.FieldsHeaders;
import com.quid.excel.component.Headers;

@FieldsHeaders(
    i18n = {
        @Headers(code = KO, fields = {"이름", "주소"}),
        @Headers(code = EN, fields = {"name", "address"})
    }
)
public class SampleData {

    private String name;
    @ExcelExclude
    private String age;
    private String address;

    public SampleData(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
