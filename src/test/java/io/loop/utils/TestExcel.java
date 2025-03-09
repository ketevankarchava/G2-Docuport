package io.loop.utils;

public class TestExcel {

    public static void main(String[] args) {

        ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\KETO\\IdeaProjects\\cucumber-project-b4\\src\\test\\resources\\Book1test.xlsx", "Sheet1");


        System.out.println("excelUtils.getCellData(0, 0) = " + excelUtils.getCellData(0, 0));


        excelUtils.setCellData("Keti is sleepy", 3,4);
    }
}
