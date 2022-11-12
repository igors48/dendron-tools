package nmd;

import lombok.val;

import java.util.*;

final class LinkExtractor {

    private static final String BEGIN_LINK = "[[";
    private static final String END_LINK = "]]";
    private static final String SPLITTER = "|";

    public static List<Link> extractLinks(String line) {
        if (line == null) return Collections.emptyList();
        if (line.isBlank()) return Collections.emptyList();

        val begins = findAllIndexes(line, BEGIN_LINK);
        val ends = findAllIndexes(line, END_LINK);

        if (begins.size() != ends.size()) throw new LinkExtractorException("Found malformed link");

        val result = new ArrayList<Link>();
        for (var i = 0; i < begins.size(); i++) {
            val content = line.substring(begins.get(i) + BEGIN_LINK.length(), ends.get(i));
            val splitterIndex = content.indexOf(SPLITTER);
            Link link;
            if (splitterIndex == -1) {
                link = new Link("", content);
            } else {
                val alias = content.substring(0, splitterIndex);
                val path = content.substring(splitterIndex + 1);
                link = new Link(alias, path);
            }
            result.add(link);
        }

        return result;
    }

    private static List<Integer> findAllIndexes(String line, String marker) {
        val result = new ArrayList<Integer>();
        var index = line.indexOf(marker);
        while (index >= 0) {
            result.add(index);
            index = line.indexOf(marker, index + 1);
        }
        return result;
    }

    private LinkExtractor() {
        // empty
    }
}
