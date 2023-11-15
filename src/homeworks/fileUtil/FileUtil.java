package homeworks.fileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String dirPath = "D:\\Java\\JavaCore\\src\\homeworks\\fileUtil\\files";
        String txtPath = "D:\\Java\\JavaCore\\src\\homeworks\\fileUtil\\files\\lorem.txt";

        System.out.println(fileSearch(dirPath, "t2.txt"));
        contentSearch(dirPath, "java");
        findLines(txtPath, "Lorem");
        System.out.println(printSizeOfPackage(dirPath));
        createFileWithContent(dirPath, "newFile.txt", "Hello World!");
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static boolean fileSearch(String path, String fileName) {
        File directory = new File(path);
        boolean exists = false;
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                exists = fileSearch(path + "\\" + file.getName(), fileName);
            } else {
                if (file.getName().equals(fileName)) {
                    exists = true;
                }
            }
        }
        return exists;
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch(String path, String keyword) {
        File directory = new File(path);
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                contentSearch(path + "\\" + file.getName(), keyword);
            } else if (file.getName().endsWith(".txt")) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String content;
                    while ((content = br.readLine()) != null) {
                        if (content.contains(keyword)) {
                            System.out.println(file.getName());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines(String txtPath, String keyword) {
        File txtFile = new File(txtPath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile))) {
            String content;
            while ((content = bufferedReader.readLine()) != null) {
                if (content.contains(keyword)) {
                    System.out.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static long printSizeOfPackage(String path) {
        File directory = new File(path);
        long size = 0;
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                size += printSizeOfPackage(path + "\\" + file.getName());
            } else {
                size += file.length();
            }
        }
        return size;
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent(String path, String fileName, String content) {
        File file = new File(path + "\\" + fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
