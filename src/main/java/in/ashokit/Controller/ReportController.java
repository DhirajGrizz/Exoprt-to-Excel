package in.ashokit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.Service.ExcelExportService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportController {
	
	@Autowired
	private ExcelExportService exptService;
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		String headerkey = "Content-Disposition";
		String headerValue = "attachment;filename=Mobiles.xls";
		
		response.setHeader(headerkey, headerValue);
		
		exptService.exportDataToExcel(response);
	}

}
