import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement("C:\\Users\\ALFA\\Documents\\New folder");
        for (int i = 0; i < fileManagement.size; i++) {
            System.out.println(fileManagement.files.get(i));
        }
    }
}

class FileManagement {
    public int size = 0;

    @Override
    public String toString() {
        return "FileManagement{" +
                "files=" + files +
                '}';
    }

    ArrayList<MyFile> files = new ArrayList<>();

    public FileManagement(String dir) {
        moveAllFile(dir);
    }

    void moveAllFile(String dir) {
        File file = new File(dir);
        File[] tempArr = file.listFiles();
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i].isFile()) {
                MyFile myFile = new MyFile(tempArr[i].getName());
                files.add(myFile);
                try {
                    if (!tempArr[i].getParent().equals("C:\\Users\\ALFA\\Documents\\New folder"))
                        Files.move(Paths.get(tempArr[i].getPath()), Paths.get("C:\\Users\\ALFA\\Documents\\New folder\\"+tempArr[i].getName()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                size++;
            } else {
                moveAllFile(tempArr[i].getPath());
            }
        }
        for (int i = 0; i < tempArr.length; i++){
            if (!tempArr[i].isFile()) {
                tempArr[i].delete();
            }
        }
    }

    private class MyFile {
        private String name;
        private int year;
        private String format;

        @Override
        public String toString() {
            return "MyFile{" +
                    "name='" + name + '\'' +
                    ", year=" + year +
                    ", format='" + format + '\'' +
                    '}';
        }

        public MyFile(String d) {
            String[] dd = d.split("\\.");
            this.name = dd[0];
            this.year = Integer.parseInt(dd[1]);
            this.format = dd[2];
        }
    }
}