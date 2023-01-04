package nmd.dendron;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Igor Usenko
 */
final class DocumentParser {

    static Document parse(List<String> lines) {
        val links = new ArrayList<Link>();
        for (var line : lines) {
            val extractedLinks = LinkExtractor.extractLinks(line);
            links.addAll(extractedLinks);
        }
        return new Document(links);
    }

    private DocumentParser() {
        // empty
    }
}
