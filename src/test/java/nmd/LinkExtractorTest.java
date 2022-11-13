package nmd;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static nmd.LinkExtractor.extractLinks;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Igor Usenko
 */
class LinkExtractorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "[[ content",
            "content ]]",
            "[[ [[ content ]]",
    })
    void cornerCases(String line) {
        LinkExtractorException thrown = assertThrows(
                LinkExtractorException.class,
                () -> extractLinks(line),
                "Expected extractLinks to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("malformed link"), "then exception thrown");
    }

    @Test
    void whenLineIsEmptyThenNoLinks() {
        val links = extractLinks("");
        assertTrue(links.isEmpty(), "then no links found");
    }

    @Test
    void whenLineIsNull() {
        val links = extractLinks(null);
        assertTrue(links.isEmpty(), "then no links found");
    }

    @Test
    void whenLineDoesNotContainLinks() {
        val links = extractLinks("no links here");
        assertTrue(links.isEmpty(), "then no links found");
    }

    @Test
    void whenLineDoesContainOneLink() {
        val links = extractLinks("text with link [[12 2022|tags.repeat]]");
        assertEquals(1, links.size(), "then one link found");
        val firstLink = links.get(0);
        assertEquals("12 2022", firstLink.alias(), "then alias is correct");
        assertEquals("tags.repeat", firstLink.path(), "then path is correct");
    }

    @Test
    void whenLineDoesContainOneLinkWithoutAlias() {
        val links = extractLinks("text with link [[tags.repeat]]");
        assertEquals(1, links.size(), "then one link found");
        val firstLink = links.get(0);
        assertEquals("", firstLink.alias(), "then alias is empty");
        assertEquals("tags.repeat", firstLink.path(), "then path is correct");
    }

    @Test
    void whenLineDoesContainSeveralEqualLinks() {
        val links = extractLinks(" [[12 2022|tags.repeat]] text with several links [[12 2022|tags.repeat]]");
        assertEquals(2, links.size(), "then two links found");
        val firstLink = links.get(0);
        assertEquals("12 2022", firstLink.alias(), "then alias is correct");
        assertEquals("tags.repeat", firstLink.path(), "then path is correct");
        val secondLink = links.get(1);
        assertEquals("12 2022", secondLink.alias(), "then alias is correct");
        assertEquals("tags.repeat", secondLink.path(), "then path is correct");
    }

    @Test
    void whenLineDoesContainSeveralDifferentLinks() {
        val links = extractLinks(" [[10 2023|tags.repeat]] text with several links [[12 2022|tags.repeat]]");
        assertEquals(2, links.size(), "then two links found");
        val firstLink = links.get(0);
        assertEquals("10 2023", firstLink.alias(), "then alias is correct");
        assertEquals("tags.repeat", firstLink.path(), "then path is correct");
        val secondLink = links.get(1);
        assertEquals("12 2022", secondLink.alias(), "then alias is correct");
        assertEquals("tags.repeat", secondLink.path(), "then path is correct");
    }

}