package org.shopify.integrator.beestore.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*
    Reflection methods to retrieve objects based on property, or to retrieve possible property values in set
*/
public class BeeStoreFtpFileValuesExtractor {

    public static Set<String> getAllDistinctValuesByProperty(final List<BeeStoreFtpProduct> list, final String property) {

        return list.stream().map(object -> {
            try {
                Field field = object.getClass().getDeclaredField(property);
                field.setAccessible(true);
                return (String) field.get(object);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet());
    }

    public static Set<BeeStoreFtpProduct> findAllProductsByPropertyAndValue(final List<BeeStoreFtpProduct> list, final String property, final String value) {
        return list.stream().filter(object -> {

            try {
                Field field = object.getClass().getDeclaredField(property);
                field.setAccessible(true);
                String found = (String) field.get(object);

                if (found == null && value == null) {
                    return true;
                } else {
                    return found.equals(value);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet());
    }


    public static Optional<BeeStoreFtpProduct> getFirstProductByPropertyAndValue(final List<BeeStoreFtpProduct> list, final String property, final String value) {
        return findAllProductsByPropertyAndValue(list,property,value).stream().findFirst();
    }


}
