package com.structurizr.util;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class ImageUtilsTests {

    @Test
    void getContentType_ThrowsAnException_WhenANullFileIsSpecified() throws Exception {
        try {
            ImageUtils.getContentType((File)null);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A file must be specified.", iae.getMessage());
        }
    }

    @Test
    void getContentType_ThrowsAnException_WhenAFileIsSpecifiedButItIsNotAFile() throws Exception {
        try {
            ImageUtils.getContentType(new File("../structurizr-core"));
            fail();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            assertTrue(iae.getMessage().endsWith("structurizr-core is not a file."));
        }
    }

    @Test
    void getContentType_ThrowsAnException_WhenAFileIsSpecifiedButItIsNotAnImage() throws Exception {
        try {
            ImageUtils.getContentType(new File("../build.gradle"));
            fail();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            assertTrue(iae.getMessage().endsWith("build.gradle is not a supported image file."));
        }
    }

    @Test
    void getContentType_ThrowsAnException_WhenAFileIsSpecifiedButItDoesNotExist() throws Exception {
        try {
            ImageUtils.getContentType(new File("./foo.xml"));
            fail();
        } catch (IllegalArgumentException iae) {
            assertTrue(iae.getMessage().endsWith("foo.xml does not exist."));
        }
    }

    @Test
    void getContentType_ReturnsTheContentType_WhenAFileIsSpecified() throws Exception {
        String contentType = ImageUtils.getContentType(new File("./src/test/resources/structurizr-logo.png"));
        assertEquals("image/png", contentType);
    }

    @Test
    void getContentType_ThrowsAnException_WhenANullUrlIsSpecified() throws Exception {
        try {
            ImageUtils.getContentType((String)null);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A URL must be specified.", iae.getMessage());
        }
    }

    @Test
    void getContentType_ReturnsTheContentType_WhenAUrlIsSpecified() throws Exception {
        String contentType = ImageUtils.getContentType(new File("../structurizr-core/test/unit/com/structurizr/util/structurizr-logo.png").toURI().toURL().toExternalForm());
        assertEquals("image/png", contentType);
    }

    @Test
    void getContentTypeFromDataUri_ThrowsAnException_WhenANullDataUriIsSpecified() throws Exception {
        try {
            ImageUtils.getContentTypeFromDataUri(null);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A data URI must be specified.", iae.getMessage());
        }
    }

    @Test
    void getContentTypeFromDataUri_ReturnsTheContentType_WhenAUrlIsSpecified() throws Exception {
        assertEquals("image/png", ImageUtils.getContentTypeFromDataUri("data:image/png;base64,..."));
        assertEquals("image/jpeg", ImageUtils.getContentTypeFromDataUri("data:image/jpeg;base64,..."));
        assertEquals("image/svg+xml", ImageUtils.getContentTypeFromDataUri("data:image/svg+xml;utf8,..."));
        assertNull(ImageUtils.getContentTypeFromDataUri("data:..."));
    }

    @Test
    void getImageAsBase64_ThrowsAnException_WhenANullFileIsSpecified() throws Exception {
        try {
            ImageUtils.getImageAsBase64(null);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A file must be specified.", iae.getMessage());
        }
    }

    @Test
    void getImageAsBase64_ThrowsAnException_WhenAFileIsSpecifiedButItIsNotAFile() throws Exception {
        try {
            ImageUtils.getImageAsBase64(new File("../structurizr-core"));
            fail();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            assertTrue(iae.getMessage().endsWith("structurizr-core is not a file."));
        }
    }

    @Test
    void getImageAsBase64_ThrowsAnException_WhenAFileIsSpecifiedButItIsNotAnImage() throws Exception {
        try {
            ImageUtils.getImageAsBase64(new File("../build.gradle"));
            fail();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            assertTrue(iae.getMessage().endsWith("build.gradle is not a supported image file."));
        }
    }

    @Test
    void getImageAsBase64_ThrowsAnException_WhenAFileIsSpecifiedButItDoesNotExist() throws Exception {
        try {
            ImageUtils.getImageAsBase64(new File("./foo.xml"));
            fail();
        } catch (IllegalArgumentException iae) {
            assertTrue(iae.getMessage().endsWith("foo.xml does not exist."));
        }
    }

    @Test
    void getImageAsBase64_ReturnsTheImageAsABase64EncodedString_WhenAFileIsSpecified() throws Exception {
        String imageAsBase64 = ImageUtils.getImageAsBase64(new File("./src/test/resources/structurizr-logo.png"));
        assertTrue(imageAsBase64.startsWith("iVBORw0KGgoAAAANSUhEUgAAAMQAAADECAYAAADApo5rAAA"));
    }

    @Test
    void getImageAsDataUri_ThrowsAnException_WhenANullFileIsSpecified() throws Exception {
        try {
            ImageUtils.getImageAsDataUri(null);
            fail();
        } catch (IllegalArgumentException iae) {
            assertEquals("A file must be specified.", iae.getMessage());
        }
    }

    @Test
    void getImageAsDataUri_ThrowsAnException_WhenAFileIsSpecifiedButItIsNotAFile() throws Exception {
        try {
            ImageUtils.getImageAsDataUri(new File("../structurizr-core"));
            fail();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            assertTrue(iae.getMessage().endsWith("structurizr-core is not a file."));
        }
    }

    @Test
    void getImageAsDataUri_ThrowsAnException_WhenAFileIsSpecifiedButItIsNotAnImage() throws Exception {
        try {
            ImageUtils.getImageAsDataUri(new File("../build.gradle"));
            fail();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            assertTrue(iae.getMessage().endsWith("build.gradle is not a supported image file."));
        }
    }

    @Test
    void getImageAsDataUri_ThrowsAnException_WhenAFileIsSpecifiedButItDoesNotExist() throws Exception {
        try {
            ImageUtils.getImageAsDataUri(new File("./foo.xml"));
            fail();
        } catch (IllegalArgumentException iae) {
            assertTrue(iae.getMessage().endsWith("foo.xml does not exist."));
        }
    }

    @Test
    void getImageAsDataUri_ReturnsTheImageAsADataUri_WhenAFileIsSpecified() throws Exception {
        String imageAsDataUri = ImageUtils.getImageAsDataUri(new File("./src/test/resources/structurizr-logo.png"));
        System.out.println(imageAsDataUri);
        assertTrue(imageAsDataUri.startsWith("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMQAAADECAYAAADA"));  // the actual base64 encoded string varies between Java 8 and 9
    }

    @Test
    void validateImage() {
        // allowed
        ImageUtils.validateImage("https://structurizr.com/image.png");
        ImageUtils.validateImage("data:image/png;base64,iVBORw0KGg");
        ImageUtils.validateImage("data:image/jpeg;base64,iVBORw0KGg");
        ImageUtils.validateImage("image.png");
        ImageUtils.validateImage("image.jpg");
        ImageUtils.validateImage("image.jpeg");
        ImageUtils.validateImage("image.gif");
        ImageUtils.validateImage("data:image/svg+xml;utf8,iVBORw0KGg");

        //disallowed
        try {
            ImageUtils.validateImage("data:image/other");
            fail();
        } catch (Exception e) {
            assertEquals("Only PNG and JPG data URIs are supported: data:image/other", e.getMessage());
        }
    }

    @Test
    void isSupportedDataUri() {
        assertTrue(ImageUtils.isSupportedDataUri("data:image/png;base64,iVBORw0KGg"));
        assertTrue(ImageUtils.isSupportedDataUri("data:image/jpeg;base64,iVBORw0KGg"));
        assertTrue(ImageUtils.isSupportedDataUri("data:image/svg+xml;utf8,<svg..."));
        assertFalse(ImageUtils.isSupportedDataUri("hello world"));
    }

}
