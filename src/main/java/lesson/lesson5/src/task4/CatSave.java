package task4;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class CatSave {

    public static void main(String[] args) {



        try{
            File file = new File("cat.xml");
            file.createNewFile();


            Owner owner = new Owner("Bob Marley","666");
            List<Food> food = List.of(new Food("Hills",4),
                new Food("Purina",6));
            Cat cat = new Cat(3,"Black",4.56,owner,food);
            System.out.println("new object");
            System.out.println(cat);

            JAXBContext context = JAXBContext.newInstance(Cat.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(cat,file);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
