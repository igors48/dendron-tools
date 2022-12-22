package nmd;

import lombok.val;

import java.util.List;

/**
 * @author Igor Usenko
 */
final class HeaderParser {

    private static final String SIGNATURE = "---";

    static Header parseHeader(List<String> lines) {
        if (lines.isEmpty()) throw new HeaderParserException("no content");
        if (lines.size() < 3) throw new HeaderParserException("invalid content");
        if (!SIGNATURE.equals(lines.get(0))) throw new HeaderParserException("no header start signature");
        var headerStopIndex = -1;
        var updatedLine = "";
        for (var i = 1; i < lines.size(); i++) {
            val current = lines.get(i);
            if (current == null || current.isBlank()) {
                continue;
            }
            if (SIGNATURE.equals(current)) {
                headerStopIndex = i;
                break;
            }
            if (current.startsWith("updated")) {
                updatedLine = current;
            }
        }
        if (updatedLine.isBlank()) throw new HeaderParserException("no header updated field");
        if (headerStopIndex == -1) throw new HeaderParserException("no header stop signature");
        val splitterIndex = updatedLine.indexOf(":");
        if (splitterIndex == -1) throw new HeaderParserException("header updated field malformed");
        val timestampString = updatedLine.substring(splitterIndex + 1);
        if (timestampString.isBlank()) throw new HeaderParserException("header updated field empty");
        try {
            val timestamp = Long.parseLong(timestampString.trim());
            return new Header(timestamp);
        } catch (Exception e) {
            throw new HeaderParserException("header updated field invalid");
        }
    }

    private HeaderParser() {
        // empty
    }
}
