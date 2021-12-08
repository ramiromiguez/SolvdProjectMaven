package com.solvd.gym.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Reflector {

    public static void main(String[] args) throws SecurityException, ClassNotFoundException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

	Logger LOG = Logger.getLogger(Reflector.class.getName());

	Stream.of(Gym.class.getMethods()).forEach(System.out::println);
	System.out.println("\n");
	Stream.of(MartialArtType.class.getFields()).forEach(System.out::println);
	System.out.println("\n");
	Stream.of(Class.forName("com.solvd.gym.data.Client").getMethods()).forEach(System.out::println);
	System.out.println("\n");
	Stream.of(Instructor.class.getConstructors()).forEach(System.out::println);
	System.out.println("\n");
	Constructor<InstructorGym> constructor = InstructorGym.class.getConstructor(int.class, String.class, int.class);
	InstructorGym bautista = constructor.newInstance(10, "Bautista", 500);
	System.out.println("Bautista" + bautista);

	Method method = InstructorGym.class.getMethod("getName");
	String name = (String) method.invoke(bautista);
	System.out.println(name);
    }
}
