package org.example;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    String DirectoryName;
    List<FileSystemComponent> children;
    public Directory(String DirectoryName) {
        this.DirectoryName = DirectoryName;
        children = new ArrayList<>();
    }
    public void addChild(FileSystemComponent child) {
        children.add(child);

    }
    public  void removeChild(FileSystemComponent child) {
        children.remove(child);
    }
    @Override
    public void printContents() {
        System.out.println("Directory Name: " + DirectoryName);
        for (FileSystemComponent child : children) {
            child.printContents();
        }
    }
}
