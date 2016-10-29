package walkingdevs;

import org.junit.Assert;
import org.junit.Test;
import walkingdevs.bytes.Bytes;
import walkingdevs.bytes.BytesBuilder;

public class BytesBuilderTest extends Assert {
    @Test
    public void shouldGet() {
        byte[] expected = {1,2,3};
        byte[] actual = BytesBuilder.mk()
                .add(new byte[]{1})
                .add(new byte[]{2})
                .add(new byte[]{3})
                .get();
        assertEquals(
                Bytes.mk(expected),
                Bytes.mk(actual)
        );
    }

    @Test
    public void shouldGetLength() {
        assertEquals(
                3,
                BytesBuilder.mk().add(new byte[3]).length()
        );
    }

    @Test
    public void shouldBeEmpty() {
        assertTrue(BytesBuilder.mk().isEmpty());
    }

    @Test
    public void shouldAdd() {
    }

    @Test
    public void shouldMk() {
        assertNotNull(BytesBuilder.mk());
    }
}