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
    public void shouldReturnTrueWhenTagIsSingleton() {
        Tag tag = new Tag("<br>");
        assertTrue(tag.isSingleton());
    }

    @Test
    public void shouldReturnFalseWhenTagIsNotSingleton() {
        Tag tag = new Tag("<h1>");
        assertFalse(tag.isSingleton());
    }
}
