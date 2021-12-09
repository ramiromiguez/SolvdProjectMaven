package com.solvd.gym.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Reflector {
    private final static Logger LOG = Logger.getLogger(Reflector.class.getName());

    public static void main(String[] args) throws SecurityException, ClassNotFoundException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

	Stream.of(Gym.class.getMethods()).forEach(str -> LOG.log(Level.INFO, "Methods " + str));
	System.out.println("\n");
	Stream.of(MartialArtType.class.getFields()).forEach(str -> LOG.log(Level.INFO, "Fields" + str));
	System.out.println("\n");
	Stream.of(Class.forName("com.solvd.gym.data.Client").getMethods())
		.forEach(str -> LOG.log(Level.INFO, "methods"));
	System.out.println("\n");
	Stream.of(Instructor.class.getConstructors()).forEach(str -> LOG.log(Level.INFO, "constructor"));
	System.out.println("\n");
	Constructor<InstructorGym> constructor = InstructorGym.class.getConstructor(int.class, String.class, int.class);
	InstructorGym bautista = constructor.newInstance(10, "Bautista", 500);
	LOG.log(Level.INFO, "Bautista" + bautista);

	Method method = InstructorGym.class.getMethod("getName");
	String name = (String) method.invoke(bautista);
	LOG.log(Level.INFO, name);
    }
}
