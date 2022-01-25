package services;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface BankStatementInputService {
    List<String> getLines(Path path) throws IOException;

    Path getPath(String resources, String csv);
}
