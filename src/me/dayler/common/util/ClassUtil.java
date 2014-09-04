/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dayler.common.util;

/**
 * @author asalazar
 */
public class ClassUtil {

    public static <T> T castAs(Class<T> clazz, Object obj) {
        if (obj == null) {
            return null;
        }

        try {
            // Try cast.
            if (clazz.isInstance(obj)) {
                return clazz.cast(obj);
            }

        } catch (ClassCastException ex) {
            // No op.
        }

        return null;
    }
}
