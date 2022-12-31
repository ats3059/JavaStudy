package ch15;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileEx3 {
    static List<File> dirList;
    static List<File> fileList;
    static int fileCount;
    static int dirCount;

    public static void main(String[] args) {
        File dir = new File("C:\\Users\\user1\\Desktop\\javajungsuk3-master\\workspace");

        dirList = new ArrayList<>();
        fileList = new ArrayList<>();

        if(dir.exists() && dir.isDirectory()){
            fileCount(dir);
        }
        
    }

    static void fileCount(File dir){
        System.out.println("파일 경로는 = " + dir.getAbsolutePath());
        File[] files = dir.listFiles();

        for(File file : files){
            if(file.isDirectory()){
                dirList.add(file);
            }else if(file.isFile()){
                fileList.add(file);
            }
        }

        for(File file : dirList){
            for(File inner : file.listFiles()){
                if(inner.isFile()){
                    fileList.add(inner);
                }
            }
        }

        fileCount = fileList.size();
        System.out.println("FileCount =  : " +fileCount);
        dirCount = dirList.size();
        System.out.println("DirCount = " + dirCount);


        printFileAndDirName(dirList,false);
        printFileAndDirName(fileList,true);
    }

    static void printFileAndDirName(List<File> files , boolean isFile){
        String fileOrDir = "";
        if(isFile) fileOrDir = "파일";
        else fileOrDir = "폴더";

        for(File file : files){
            System.out.printf("%s명은 %s 입니다" ,fileOrDir , file.getName());
            System.out.println();
        }

    }

}
