import java.util.Arrays;

public class ArraySerialize {
    public static void main(String[] args) {
        String[] ary = {"hello", "world", "####", "@#$%"};
        System.out.println(Arrays.toString(ary));
        String ser = serialize(ary);
        System.out.println(ser);

        String[] ary1 = deserialize(ser);
        System.out.println(Arrays.toString(ary1));
    }

    public static String serialize(String[] ar) {
        StringBuffer result = new StringBuffer();
        result.append("#");
        for(int i=0; i<ar.length; i++) {
            result.append(ar[i].length());
            if (i < ar.length - 1)
                result.append(":");
        }
        result.append("#");
        for(String s: ar) {
            result.append(s);
        }
        return result.toString();
    }

    public static String[] deserialize(String s) {
        String s1 = s.substring(1);
        int idx = s1.indexOf("#");
        String header = s1.substring(0, idx);
        String data = s1.substring(idx+1);

        String[] headers = header.split(":");
        String[] rs = new String[headers.length];
        int st = 0;
        for(int i=0; i<headers.length; i++) {
            int len = Integer.valueOf(headers[i]);
            rs[i] = data.substring(st, st+len);
            st = st+len;
        }
        return rs;
    }
}
