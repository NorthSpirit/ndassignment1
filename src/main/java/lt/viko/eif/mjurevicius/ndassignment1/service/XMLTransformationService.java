package lt.viko.eif.mjurevicius.ndassignment1.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class XMLTransformationService {

    public static void transform(Object object){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, System.out);
        } catch (JAXBException e) {
            System.out.println(e.getLocalizedMessage() + e.getCause());
        }
    }

    public static void transform(Object object, String fileName){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File(fileName + ".xml");
            marshaller.marshal(object, file);
        } catch (JAXBException e) {
            System.out.println(e.getLocalizedMessage() + e.getCause());
        }
    }
}
