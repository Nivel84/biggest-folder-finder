import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Nivel\\Desktop\\Разное";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));
    }

    public static long getFolderSize(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long sum = 0;
        File[] files = file.listFiles();
        for (File f : files) {
            sum += getFolderSize(f);
        }
        return sum;
    }
}
