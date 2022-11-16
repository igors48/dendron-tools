package nmd;

import java.util.List;

/**
 * @author Igor Usenko
 */
final class HeaderParser {

    private static final String SIGNATURE = "---";

    static Header parseHeader(List<String> lines) {
        if (lines.isEmpty()) throw new HeaderParserException("no content");
        if (!SIGNATURE.equals(lines.get(0))) throw new HeaderParserException("no header start signature");

        return null;
    }

    private HeaderParser() {
        // empty
    }
}
