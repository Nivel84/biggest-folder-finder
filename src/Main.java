import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
//        "-l", "1Kb", "-d", "C:\\Users\\Nivel\\Desktop\\Разное"
        ParametersBag parametersBag = new ParametersBag(args);
        String folderPath = parametersBag.getPath();
        long limit = parametersBag.getLimit();
        File file = new File(folderPath);
        Node root = new Node(file, limit);

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
    }
}
