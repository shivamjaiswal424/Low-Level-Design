package org.example;

public class File implements FileSystemComponent {
    public String fileName;
    public File(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void printContents() {
        System.out.println("File Name : " + fileName);
    }
}
