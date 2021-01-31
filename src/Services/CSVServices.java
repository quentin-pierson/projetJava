package Services;

import Models.ListWeapon;
import Models.ListMonster;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CSVServices<E, V> {

    public ArrayList<E> csvParse(String csvFile, Class<E> genericClass){
        String[] listObj = csvFile.split("\n");
        ArrayList<E> objectList = new ArrayList<E>();
        try {
            Constructor[] constructorParams = genericClass.getConstructors();
            for (int j = 0; j < constructorParams.length; j+=1){
                try {
                    Constructor<E> ctr = genericClass.getConstructor(constructorParams[j].getParameterTypes());

                    for(int i = 0; i < listObj.length; i+=1){
                        Type[] types = constructorParams[j].getParameterTypes();
                        String[] values = listObj[i].split(";");

                        ArrayList<Object> serializableList = new ArrayList<Object>();

                        for (int k = 0; k < values.length; k+=1){
                            System.out.println(types[k]);
                            serializableList.add(convertStringToType(types[k], values[k]));

                            //serializableList.add(values[k]);
                        }
                        objectList.add(ctr.newInstance(serializableList.toArray()));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return objectList;
    }

    private Object convertStringToType(Type type, String value){
        switch (type.toString()){
            case "double":
                return Double.parseDouble(value);
            case "int":
                return Integer.parseInt(value);
            case "class java.lang.String":
                return String.valueOf(value);
            case "float":
                return Float.parseFloat(value);
            case "boolean":
                return Boolean.parseBoolean(value);
            case "class Models.ListWeapon":
                return ListWeapon.valueOf(value);
            case "class Models.ListMonster":
                return ListMonster.valueOf(value);
        }

        return null;
    }
}
