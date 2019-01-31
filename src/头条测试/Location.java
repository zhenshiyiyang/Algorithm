package 头条测试;

public class Location {
    public static void main(String[] args) {
        String ip = "192.168.2.1";
        if(ip==null){
            //return null;
        }
        String[] ips = ip.split("\\.");
        long first = Long.parseLong(ips[0])<<24;
        long second = Long.parseLong(ips[1])<<16;
        long third = Long.parseLong(ips[2])<<8;
        long four = Long.parseLong(ips[3]);
        long result = first+second+third+four;
        System.out.println(result);
    }
}
