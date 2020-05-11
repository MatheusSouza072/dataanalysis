package com.matheus.dataanalysis.model;

public abstract class InputFile {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    } 

    public abstract String generateReport();
}
