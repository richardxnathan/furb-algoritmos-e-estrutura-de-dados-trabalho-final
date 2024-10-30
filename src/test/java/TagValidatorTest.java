import org.junit.jupiter.api.Test;
import org.furb.model.Tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TagValidatorTest {

    @Test
    public void should_return_true_when_tag_is_valid() {
        Tag tag = new Tag("<html>");
        assertTrue(tag.isValidTag());
        assertFalse(tag.isFinal());
    }

    @Test
    public void should_be_a_invalid_tag() {
        Tag tag = new Tag("<html");
        assertFalse(tag.isValidTag());
    }

    @Test
    public void should_be_start_tag() {
        Tag tag = new Tag("<html>");
        assertFalse(tag.isFinal());
    }

    @Test
    public void should_be_final_tag() {
        Tag tag = new Tag("</html>");
        assertTrue(tag.isFinal());
    }

    @Test
    public void should_return_true_when_tag_is_valid_and_is_the_final() {
        Tag tag = new Tag("</html>");
        assertTrue(tag.isValidTag());
        assertTrue(tag.isFinal());
    }

    @Test
    public void should_return_true_when_tag_is_invalid_and_has_blank_space_after_start() {
        Tag tag = new Tag("< html>");
        assertFalse(tag.isValidTag());
    }

    @Test
    public void should_return_true_when_tag_is_valid_and_has_blank_space_after_start() {
        Tag tag = new Tag("<html >");
        assertTrue(tag.isValidTag());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_meta() {
        Tag tag = new Tag("<meta>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_base() {
        Tag tag = new Tag("<base>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_br() {
        Tag tag = new Tag("<br>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_col() {
        Tag tag = new Tag("<col>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_command() {
        Tag tag = new Tag("<command>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_embed() {
        Tag tag = new Tag("<embed>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_hr() {
        Tag tag = new Tag("<hr>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_img() {
        Tag tag = new Tag("<img>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_input() {
        Tag tag = new Tag("<input>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_link() {
        Tag tag = new Tag("<link>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_param() {
        Tag tag = new Tag("<param>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_source() {
        Tag tag = new Tag("<source>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnTrueWhenTagIsSingleton_doctype() {
        Tag tag = new Tag("<!DOCTYPE>");
        tag.tagClear();
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnFalseWhenTagIsNotSingleton() {
        Tag tag = new Tag("<h1>");
        assertFalse(tag.isSingleton());
    }
}
