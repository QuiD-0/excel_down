package com.quid.excel.controller;

import static com.quid.excel.component.Internationalization.EN;
import static com.quid.excel.component.Internationalization.KR;

import com.quid.excel.component.Internationalization;
import com.quid.excel.controller.response.SampleData;
import com.quid.excel.service.ExcelDownloadService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        List<SampleData> sample = getData(3);

        excel.download(response, "sample", sample, lang);
    }

    @GetMapping("/en")
    public void sampleEn(HttpServletResponse response) {
        List<SampleData> sample = getData(3);
        excel.download(response, "sample", sample, EN);
    }

    @GetMapping("/kr")
    public void sampleKr(HttpServletResponse response) {
        List<SampleData> sample = getData(1000000);
        excel.download(response, "sample", sample, KR);
    }

    @GetMapping("/stream")
    public void sampleStream(HttpServletResponse response) {
        List<SampleData> sample = getData(1000000);
        excel.download(response, "sample", sample, KR);
    }

    private List<SampleData> getData(Integer count) {
        return IntStream.range(0, count).mapToObj(i -> new SampleData("홍길동" + i, "20", "남자"))
            .collect(Collectors.toList());
    }

}
