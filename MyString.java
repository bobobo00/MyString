package TestString;

import java.util.Arrays;

/**
 * @ClassName MyString
 * @Description TODO
 * @Auther danni
 * @Date 2019/10/17 18:41]
 * @Version 1.0
 **/

public final class MyString {
    private final char[] value;
    

    public MyString(char[] value,int offest,int count) {
        this.value=Arrays.copyOfRange(value,offest,offest+count);
    }
    public MyString(char[] value){
        this.value=Arrays.copyOf(value,value.length);
    }

    public char charAt(int index){
        return value[index];
    }

    public char[] toCharArray(){
        return Arrays.copyOf(value,value.length);
    }

    @Override
    public String toString() {
        return "MyString{" +
                "value=" + Arrays.toString(value) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Arrays.equals(value, myString.value);//比较数组是否相等需使用Array.equals方法。
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }

    public MyString toUpperCase(){
        char[] value=this.toCharArray();
        for (int i = 0; i <value.length ; i++) {
            if(value[i]>='a'&&value[i]<='z'){
                value[i]=(char)(value[i]-'a'+'A');
            }
        }
        return new MyString(value);
    }

    public boolean equalsIgnoreCase(MyString o){
        if(o==null){
            return false;
        }
      if(this.value.length!=o.value.length){
          return false;
      }
        for (int i = 0; i <o.value.length ; i++) {
            char c1=(char)(this.value[i]-'a'+'A');
            char c2=(char)(this.value[i]-'a'+'A');
            if(c1!=c2){
                return false;
            }
        }
        return true;
    }

    public MyString contact(MyString o){
        char[] v=new char[this.value.length+o.value.length];
        System.arraycopy(this.value,0,v,0,this.value.length);
        System.arraycopy(o.value,0,v,this.value.length,o.value.length);
        return new MyString(v);
    }

    public static void main(String[] args) {
        char[] value1={'A','2','3','4','5'};
        char[] value2={'a','2','b','4','5','8'};
        MyString myString1=new MyString(value1);
        MyString myString2=new MyString(value2);
        System.out.println(myString1.charAt(2));
        System.out.println(myString1.contact(myString2));
        System.out.println(myString1.equalsIgnoreCase(myString2));
        System.out.println(myString2.toUpperCase());
    }
}
