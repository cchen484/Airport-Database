package Parsers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlJaxbParser {
    public static <T> T unmarshalXml(File file, Class<T> classXml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classXml);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return classXml.cast(unmarshaller.unmarshal(file));
    }

    public static <T> void marshalXml(File file, T object) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object, file);
    }

}
