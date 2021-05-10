package com.cang.controller;

import com.cang.ResponseMessage;
import com.cang.dto.StudentDTO;
import com.cang.starter.student.StudentFeignClient;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("excel")
public class ExcelController {

    @Resource
    private StudentFeignClient studentFeignClient;

    @RequestMapping("/test")
    @ApiOperation("不指定模板导出")
    public void download(HttpServletResponse response) throws IOException {
        HSSFWorkbook sheets = new HSSFWorkbook();
        String[] rowName = {"编号", "姓名", "年龄", "科目"};

        HSSFSheet sheet = sheets.createSheet();
        HSSFSheet sheet1 = sheets.createSheet();
        HSSFRow row2 = sheet1.createRow(0);
        for (int i = 0; i < rowName.length; i++) {
            HSSFCell cell = row2.createCell(i);
            cell.setCellValue(rowName[i]);
        }
        HSSFRow row = sheet.createRow(0);
        //row.setRowStyle(new HSSFCellStyle());
        for (int i = 0; i < rowName.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(rowName[i]);
        }
        ResponseMessage<List<StudentDTO>> responseMessage = studentFeignClient.selectAll();
        if (null != responseMessage) {
            List<StudentDTO> studentList = responseMessage.getResult();
            if (!CollectionUtils.isEmpty(studentList)){
                for (int i = 0; i < studentList.size(); i++) {
                    HSSFRow row1 = sheet.createRow(i + 1);
                    HSSFCell cell1 = row1.createCell(0);
                    cell1.setCellValue(studentList.get(i).getId());
                    HSSFCell cell2 = row1.createCell(1);
                    cell2.setCellValue(studentList.get(i).getName());
                    HSSFCell cell3 = row1.createCell(2);
                    cell3.setCellValue(studentList.get(i).getAge());
                    //        HSSFCell cell4 = row1.createCell(1);
                    //        cell4.setCellValue(studentList.get(i).getGradeId());
                }
            }
        }
        response.setHeader("Content-disposition", "attachment;filename=teac.xls");
        sheets.write(response.getOutputStream());
    }


    @RequestMapping("/template/test")
    @ApiOperation("指定模板导出")
    public void templateDownload(HttpServletResponse response) throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/test.xlsx");
        if (!resource.isFile()){
            return;
        }
        FileInputStream inputStream = new FileInputStream(resource.getFile());
        ResponseMessage<List<StudentDTO>> responseMessage = studentFeignClient.selectAll();
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        if (null != responseMessage){
            List<StudentDTO> studentDTOList = responseMessage.getResult();
            if (!CollectionUtils.isEmpty(studentDTOList)){
                HSSFSheet sheet = workbook.getSheetAt(0);
                for (int i = 0; i < studentDTOList.size(); i++) {
                    HSSFRow row = sheet.createRow(i + 1);
                    HSSFCell cell = row.createCell(0);
                    cell.setCellValue(studentDTOList.get(i).getId());
                    HSSFCell cell1 = row.createCell(1);
                    cell1.setCellValue(studentDTOList.get(i).getName());
                    HSSFCell cell2 = row.createCell(2);
                    cell2.setCellValue(studentDTOList.get(i).getAge());
                }

            }
            response.setHeader("Content-disposition", "attachment;filename=teac.xls");
            workbook.write(response.getOutputStream());
        }
    }

}
