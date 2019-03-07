package ToOfferNew;

public class Title4 {
    public static String replaceblank(String str){
        if(str==null)return null;
        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;
        int fromIndex = 0;
        while(index<str.length()) {
            index = str.indexOf(" ", fromIndex);
            if (index>=0) {
                stringBuffer.append(str.subSequence(fromIndex, index)).append("%20");
                index = index + 1;
                fromIndex = index;
            } else {
                stringBuffer.append(str.subSequence(fromIndex, str.length()));
                break;
            }
        }
        return stringBuffer.toString();
    }

    // 合并两个有序数组为另一个有序数组，假设nums1空间足够大。
    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while(index>0){
            if(i<0){
                nums1[index--] = nums2[j--];
            }
            else if(j<0){
                nums1[index--] = nums1[i--];
            }
            else if(nums1[i]>nums2[j]&&i>=0){
                nums1[index--] = nums1[i--];
            }
            else if(nums1[i]<=nums2[j]&&j>=0){
                nums1[index--] = nums2[j--];
            }
        }
        return nums1;
    }

}
