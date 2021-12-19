package com.cg.shopme.admin.brand;

import com.cg.shopme.common.entity.Brand;
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

public class BrandCsvExporter {

    public void export(List<Brand> brands, HttpServletResponse response) throws IOException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd_mm-ss");
        String timestamp = dateFormatter.format(new Date());
        String fileName = "brands_" + timestamp + ".csv";

        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = "attachement; filename=" + fileName;
        response.setHeader(headerKey, headerValue);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"ID","Brand Name","Categories"};
        String[] fieldMapping = {"id","name","categories"};

        csvWriter.writeHeader(csvHeader);

        for(Brand b : brands){
            csvWriter.write(b, fieldMapping);
        }

        csvWriter.close();

    }
}
