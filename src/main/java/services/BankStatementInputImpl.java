package services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementInputImpl implements BankStatementInputService {

    public List<String> getLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public Path getPath(String resourcesLocation, String csv) {
        return Paths.get(resourcesLocation + csv);
    }
}
