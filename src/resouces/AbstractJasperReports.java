package resouces;


import java.awt.Dialog;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;


public class AbstractJasperReports
{
    private static JasperReport report;
    private static JasperPrint  reportFilled;
    private static JasperViewer viewer;
    

    public  AbstractJasperReports( Connection conn, InputStream path,Map parametros ) throws JRException
    {
        
            report = (JasperReport) JRLoader.loadObject(path);
            reportFilled = JasperFillManager.fillReport( report,parametros,conn );
        
    }
    
    public  AbstractJasperReports(JRDataSource conn, InputStream path,Map parametros ) throws JRException
    {   
            report = (JasperReport) JRLoader.loadObject(path);
            reportFilled = JasperFillManager.fillReport(report, parametros, conn);   
    }
    
    
    
    public AbstractJasperReports(JRDataSource conn, String path ) throws JRException
    {  
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            reportFilled = JasperFillManager.fillReport(report, null, conn);   
    }
    
    public AbstractJasperReports(InputStream path,Map parametros ) throws JRException{
     
            report = (JasperReport) JRLoader.loadObject(path);
            reportFilled = JasperFillManager.fillReport(report, parametros,new JREmptyDataSource());
        
    }
    public void showViewer()
    {
        viewer = new JasperViewer(reportFilled, false);
        viewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        viewer.setResizable(true);
        viewer.setFitWidthZoomRatio();
        viewer.setVisible(true);
    }
    
    public void exportToPdf(String destFileName) throws JRException{
        JasperExportManager.exportReportToPdfFile(reportFilled, destFileName);
    }

}
