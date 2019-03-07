package ToOfferNew;

public class Title3 {
    public static boolean find(int[][] array,int num){
        boolean found = false;
        int row = 0;
        int column = array[0].length;
        if(array==null || row<=0 || column<=0){
            return found;
        }
        while(row<array.length && column>=0){
            if(array[row][column]==num){
                found = true;
            }else if(array[row][column]>num){
                column--;
            }else{
                row++;
            }
        }
        return found;
    }
}
