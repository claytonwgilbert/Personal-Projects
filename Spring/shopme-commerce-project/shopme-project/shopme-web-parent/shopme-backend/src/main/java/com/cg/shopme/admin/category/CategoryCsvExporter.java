package com.cg.shopme.admin.category;

import com.cg.shopme.common.entity.Category;
import com.cg.shopme.common.entity.User;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CategoryCsvExporter {

    public void export(List<Category> categories, HttpServletResponse response) throws IOException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd_mm-ss");
        String timestamp = dateFormatter.format(new Date());
        String fileName = "categories_" + timestamp + ".csv";

        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = "attachement; filename=" + fileName;
        response.setHeader(headerKey, headerValue);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"ID","Name","Alias","Enabled"};
        String[] fieldMapping = {"id","name","alias","enabled"};

        csvWriter.writeHeader(csvHeader);

        for(Category c : categories){
            csvWriter.write(c, fieldMapping);
        }

        csvWriter.close();

    }
}
