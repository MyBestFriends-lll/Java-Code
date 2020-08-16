package Annotation;

public @interface MyAnno {
	public abstract String name() default "Tom";
	public abstract int age();
}
