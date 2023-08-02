package nmd.app;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class AppTest {

    private static String CONTENT = """
            ---
            id: ju39qxmecsnowe3hpy7dr3h
            title: Bloom filter
            desc: ''
            updated: 1663485940679
            created: 1657349160751
            tags: [todo]
            ---
            Probabilistic filter to check to existence of an element in the set.
            """;

    @Test
    void name() {
        List<String> lines = CONTENT.lines().toList();
        Map<String, List<String>> files = Map.of("a", lines);
        TestFileSystem fileSystem = new TestFileSystem(files);
        TestRender render = new TestRender();
        TestTime time = new TestTime();
        String[] args = new String[]{"-w", "a", "-s", "0"};

        new App().run(args, fileSystem, time, render);
    }
}