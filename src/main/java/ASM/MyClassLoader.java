package ASM;

public class MyClassLoader extends ClassLoader {

    public Class defineClass(String s, byte[] b) {
        return defineClass(s,b,0,b.length);
    }
}
