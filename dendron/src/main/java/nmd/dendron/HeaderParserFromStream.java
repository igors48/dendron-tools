package nmd.dendron;

import lombok.val;

public class HeaderParserFromStream {

    private static final String HEADER_UPDATED_FIELD_MALFORMED = "header updated field malformed";

    private Long updated = null;

    public boolean newLine(String line) {
        if (line.startsWith("updated")) {
            val splitterIndex = line.indexOf(":");
            if (splitterIndex == -1) {
                throw new HeaderParserException(HEADER_UPDATED_FIELD_MALFORMED);
            }
            val timestampString = line.substring(splitterIndex + 1);
            long value = -1;
            try {
                value = Long.parseLong(timestampString.trim());
            } catch (Exception e) {
                throw new HeaderParserException(HEADER_UPDATED_FIELD_MALFORMED);
            }
            if (value <= 0) {
                throw new HeaderParserException(HEADER_UPDATED_FIELD_MALFORMED);
            }
            updated = value;
            return false;
        } else {
            return true;
        }
    }

    public Header getResult() {
        return updated == null ? null : new Header(updated);
    }
}
