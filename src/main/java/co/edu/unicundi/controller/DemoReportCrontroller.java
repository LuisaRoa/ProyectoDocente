package co.edu.unicundi.controller;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.pdf.codec.Base64.OutputStream;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;



@RestController
public class DemoReportCrontroller {
	@Autowired
    private DataSource dataSource;
 
    @RequestMapping("/{reportName}")
    public void demoReport1(@PathVariable("reportName") final String reportName,
                            @RequestParam(required = false) Map<String, Object> parameters,
                            HttpServletResponse response, HttpServletRequest request) throws  Exception{
        parameters = parameters == null ? new HashMap<>() : parameters;
        // Obtener la secuencia del archivo
        ClassPathResource resource = new ClassPathResource("Reportes" + File.separator + reportName + ".jasper");
        InputStream jasperStream = resource.getInputStream();
 
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
 
                 // Vista previa de PDF en línea
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final ServletOutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
        /*         // Generar documento pdf
        String fileName = "F:/filename.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,fileName);*/
 
                 // Generar documento de Word
       /* String fileName = "F:/filename.doc";
        JRRtfExporter docExporter = new JRRtfExporter();
        docExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,fileName);
        docExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docExporter.exportReport();*/
 
                 // Generar documento de Excel
        /*JRXlsExporter excel = new JRXlsExporter();
        System.out.println(request.getServletContext().getRealPath("jaspers/demoreport1.jasper"));
        String fileName = "F://filename.xls";
        excel.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,fileName);
        excel.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        excel.exportReport();*/
 
    }


}
