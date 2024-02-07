package dev.loapu.template.common.util;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SingletonFactory
{
	private static final Map<String, Object> instances = new ConcurrentHashMap<>();
	
	public static <T> T instance(Class<T> clazz)
	{
		return clazz.cast(instances.computeIfAbsent(clazz.getName(), k -> {
			try
			{
				Constructor<T> constructor = clazz.getDeclaredConstructor();
				constructor.setAccessible(true);
				return constructor.newInstance();
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		}));
	}
	
	public static <T> void deposit(Class<T> clazz, T instance)
	{
		instances.put(clazz.getName(), instance);
	}
}
