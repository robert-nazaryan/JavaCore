package homeworks.fileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String dirPath = "D:\\Java\\JavaCore\\src\\homeworks\\fileUtil\\files";
        String txtPath = "D:\\Java\\JavaCore\\src\\homeworks\\fileUtil\\files\\lorem.txt";

        fileSearch(dirPath, "java.txt");
        contentSearch(dirPath, "language");
        findLines(txtPath, "Lorem");
        printSizeOfPackage(dirPath);
        createFileWithContent(dirPath, "newFile.txt", "Hello World!");
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch(String path, String fileName) {
        File file = new File(path);
        for (File listFile : file.listFiles()) {
            if (listFile.getName().equals(fileName)) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch(String path, String keyword) {
        File directory = new File(path);
        int index = 0;
        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                index++;
            }
        }
        File[] txtFiles = new File[index];
        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                txtFiles[--index] = file;
            }
        }
        for (File file : txtFiles) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String content;
                while ((content = bufferedReader.readLine()) != null) {
                    if (content.contains(keyword)) {
                        System.out.println(file.getName());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
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
    static void printSizeOfPackage(String path) {
        File directory = new File(path);
        long size = 0;
        for (File file : directory.listFiles()) {
            size += file.length();
        }
        System.out.println(size);
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
