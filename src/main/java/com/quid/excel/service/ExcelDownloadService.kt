package com.quid.excel.service

import com.quid.excel.component.Binder
import com.quid.excel.component.Internationalization
import org.springframework.stereotype.Component
import java.net.URLEncoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.servlet.http.HttpServletResponse

@Component
class ExcelDownloadService {

    fun <T> download(response: HttpServletResponse, name: String, data :List<T>, lang: Internationalization) {
        response.contentType = "application/vnd.ms-excel"
        response.characterEncoding = "utf-8"
        val fileNameUtf8 = URLEncoder.encode(name, "UTF-8")
        val now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        response.setHeader("Content-Disposition", "attachment; filename=" + fileNameUtf8 +"_"+now+".xlsx");
        Binder(response.outputStream, name, data, lang).build()
    }
}