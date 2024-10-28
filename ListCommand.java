import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ListCommand {
    public ArrayList<String> NormalListCommand() throws Exception {
        Path dir = Path.of(SystemProperties.currentDirectory);
        ArrayList<String> list = new ArrayList<>();
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        for (Path file : stream) {
            String fileName = file.getFileName().toString();
            if(fileName.charAt(0) != '.') {
                list.add(fileName);
            }
        }
        return list;
    }
}