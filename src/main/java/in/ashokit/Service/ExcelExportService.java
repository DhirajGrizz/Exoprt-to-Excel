package in.ashokit.Service;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Mobiles;
import in.ashokit.Repo.MobileRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExcelExportService {

    @Autowired
    private MobileRepository mobileRepo;

    public void exportDataToExcel(HttpServletResponse response) throws Exception {
    	
         java.util.List<Mobiles> list = mobileRepo.findAll();

        // Create a workbook and a sheet
         
        HSSFWorkbook workbook = new HSSFWorkbook();
       HSSFSheet sheet = workbook.createSheet("Mobile info");

        // Create headers
       HSSFRow header = sheet.createRow(0);
       
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("NAME");
        header.createCell(2).setCellValue("PRICE");

        // Add other column headers as needed

        // Populate data
        int rowNum = 1;
        
        for (Mobiles entity : list) {
        	
            Row row = sheet.createRow(rowNum);
            
            row.createCell(0).setCellValue(entity.getMobileId());
            
            row.createCell(1).setCellValue(entity.getMobileName());
            
            row.createCell(2).setCellValue(entity.getMobilePrice());
            
            rowNum ++;

            // Set other column values accordingly
        }

//        // Set the response headers
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Disposition", "attachment; filename=your_entity_data.xls");

        // Write workbook data to the response output stream
        
        ServletOutputStream outputStream = response.getOutputStream();
        
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
}
