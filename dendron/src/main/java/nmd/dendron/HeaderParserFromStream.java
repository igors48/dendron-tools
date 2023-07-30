package nmd.dendron;

import lombok.val;

public class HeaderParserFromStream {

    private Long updated = null;

    public boolean newLine(String line) {
        if (line.startsWith("updated")) {
            val splitterIndex = line.indexOf(":");
            if (splitterIndex == -1) throw new HeaderParserException("header updated field malformed");
            val timestampString = line.substring(splitterIndex + 1);
            if (timestampString.isBlank()) throw new HeaderParserException("header updated field empty");
            try {
                updated = Long.parseLong(timestampString.trim());
            } catch (Exception e) {
                // empty
            }
            return true;
        } else {
            return true;
        }
    }

    public Header getResult() {
        return updated == null ? null : new Header(updated);
    }
}
