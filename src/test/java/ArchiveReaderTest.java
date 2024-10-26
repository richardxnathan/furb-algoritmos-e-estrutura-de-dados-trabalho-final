import org.furb.exception.IllegalTagsSequence;
import org.furb.service.ArchiveReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArchiveReaderTest {

    @Test
    public void testReadArchive() {
        try {
            ArchiveReader archiveReader = new ArchiveReader("src/test/resources/html.txt");
            System.out.println("Chegou aqui");
            assertDoesNotThrow(archiveReader::readArchiveLines);
            System.out.println("Passou");
        } catch (Exception e) {
            System.out.println("Algum erro aconteceu: " + e.getMessage());
        }
    }

    @Test
    public void testReadArchiveWithInvalidPath() {
        assertThrows(Exception.class, () -> new ArchiveReader("src/test/resources/html3.txt"));
    }

    @Test
    public void testReadArchiveWithInvalidTags() {
        try {
            ArchiveReader archiveReader = new ArchiveReader("src/test/resources/html2.txt");
            assertThrows(IllegalTagsSequence.class, archiveReader::readArchiveLines);
        } catch (Exception e) {
            System.out.println("Algum erro aconteceu: " + e.getMessage());
        }
    }
}
