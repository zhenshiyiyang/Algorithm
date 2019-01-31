package 头条;

public class first {
    public static void main(String[] args) {
        int[] array = {1,1,2,2,2,3,3,3,4,4};
        int key = 2;
        System.out.println(Count(array,key));
    }
    public static int Count(int[] array,int key){
        if(search(array,key)==-1){
            return -1;
        }else {
            int loc = search(array, key);
            int count = 0;
            for (int i = loc; i < array.length; i++) {
                if (array[i] != key) {
                    break;
                }
                count++;
            }
            return count;
        }
    }
    public static int search(int[] array,int key){
        if(array==null){
            return -1;
        }
        int low = 0;
        int high = array.length-1;
        while(low <= high){
            int middle = (low+high)/2;
            if(array[middle]==key && array[middle-1]<key){
                return middle;
            }
            else if(array[middle]<key){
                low = middle+1;
            }
            else{
                high = middle-1;
            }
        }
        return -1;

    }
}
