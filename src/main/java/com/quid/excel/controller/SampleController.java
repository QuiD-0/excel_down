package com.quid.excel.controller;

import static com.quid.excel.component.Internationalization.EN;
import static com.quid.excel.component.Internationalization.KR;

import com.quid.excel.service.ExcelDownloadService;
import com.quid.excel.component.Internationalization;
import com.quid.excel.controller.response.SampleData;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    private final ExcelDownloadService excel;
    @GetMapping
    public void sample(@RequestHeader("Lang") Internationalization lang,
        HttpServletResponse response) {
        List<SampleData> sample = Arrays.asList(
            new SampleData("홍길동", "20", "남자"),
            new SampleData("김길동", "30", "여자"),
            new SampleData("박길동", "40", "남자"));

        excel.download(response, "sample", sample, lang);
    }

    @GetMapping("/en")
    public void sampleEn(HttpServletResponse response) {
        List<SampleData> sample = Arrays.asList(
            new SampleData("홍길동", "20", "남자"),
            new SampleData("김길동", "30", "여자"),
            new SampleData("박길동", "40", "남자"));
        excel.download(response, "sample", sample, EN);
    }

    @GetMapping("/kr")
    public void sampleKr(HttpServletResponse response) {
        List<SampleData> sample = Arrays.asList(
            new SampleData("홍길동", "20", "남자"),
            new SampleData("김길동", "30", "여자"),
            new SampleData("박길동", "40", "남자"));
        excel.download(response, "sample", sample, KR);
    }

}
