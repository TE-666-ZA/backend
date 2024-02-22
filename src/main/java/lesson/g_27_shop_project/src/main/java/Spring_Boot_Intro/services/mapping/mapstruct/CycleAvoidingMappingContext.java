package Spring_Boot_Intro.services.mapping.mapstruct;

import java.util.IdentityHashMap;
import java.util.Map;
import org.hibernate.MappingException;

public class CycleAvoidingMappingContext {

  private Map<Object, Object> knownInstances = new IdentityHashMap<>();

  @SuppressWarnings("unchecked")
  public <T> T mappedInstance(Object source, Class<T> targetType) {
    if (source == null) {
      return null;
    }
    Object instance = knownInstances.get(source);
    if (instance == null) {
      try {
        instance = targetType.getDeclaredConstructor().newInstance();
        knownInstances.put(source, instance);
      } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
               SecurityException | java.lang.reflect.InvocationTargetException e) {
        throw new MappingException("Can't create type of " + targetType, e);
      }
    }
    return (T) instance;
  }
}
