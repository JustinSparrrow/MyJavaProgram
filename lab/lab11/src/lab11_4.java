import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class lab11_4 {

    public void XMLReader() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("example.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        // 使用doc对象来读取和操作XML文件内容


    }

//    public void ExcelReader() throws FileNotFoundException {
//        FileInputStream file = new FileInputStream(new File("example.xlsx"));
//        Workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        // 读取和修改Excel文件的内容
//        // 例如，修改第一行第一列的内容
//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
//        cell.setCellValue("新的值");
//
//        // 保存修改后的Excel文件
//        FileOutputStream outFile = new FileOutputStream(new File("modified_example.xlsx"));
//        workbook.write(outFile);
//        outFile.close();
//
//        workbook.close();
//        file.close();
//    }
//
//    public void WordReader() throws FileNotFoundException {
//        FileInputStream file = new FileInputStream(new File("example.docx"));
//        XWPFDocument doc = new XWPFDocument(file);
//
//        // 读取和修改Word文件的内容
//        List<XWPFParagraph> paragraphs = doc.getParagraphs();
//        for (XWPFParagraph para : paragraphs) {
//            // 修改段落内容，这里只是示例，具体修改逻辑需要根据实际需求编写
//            para.createRun().setText("新的段落内容");
//        }
//
//        // 保存修改后的Word文件
//        FileOutputStream outFile = new FileOutputStream(new File("modified_example.docx"));
//        doc.write(outFile);
//        outFile.close();
//
//        doc.close();
//        file.close();
//    }

    public static void main(String[] args) {

    }
}
