import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RadixSort
{
    public static void radixSort(int []arr)
    {
        //Implementación
        String[] sArr= StringUtil.toStringArray(arr);
        StringUtil.lNormalize(sArr,'0');
        int maxLength= StringUtil.maxLength(sArr);
        ArrayList<String> tempSArr= new ArrayList<String>();
        ArrayList<String> L0= new ArrayList<String>();
        ArrayList<String> L1= new ArrayList<String>();
        ArrayList<String> L2= new ArrayList<String>();
        ArrayList<String> L3= new ArrayList<String>();
        ArrayList<String> L4= new ArrayList<String>();
        ArrayList<String> L5= new ArrayList<String>();
        ArrayList<String> L6= new ArrayList<String>();
        ArrayList<String> L7= new ArrayList<String>();
        ArrayList<String> L8= new ArrayList<String>();
        ArrayList<String> L9= new ArrayList<String>();
        for (int i=maxLength-1; i>=0; i--){
            for (int j=0; j< sArr.length; j++){
                if(sArr[j].charAt(i)=='0') L0.add(sArr[j]);
                if(sArr[j].charAt(i)=='1') L1.add(sArr[j]);
                if(sArr[j].charAt(i)=='2') L2.add(sArr[j]);
                if(sArr[j].charAt(i)=='3') L3.add(sArr[j]);
                if(sArr[j].charAt(i)=='4') L4.add(sArr[j]);
                if(sArr[j].charAt(i)=='5') L5.add(sArr[j]);
                if(sArr[j].charAt(i)=='6') L6.add(sArr[j]);
                if(sArr[j].charAt(i)=='7') L7.add(sArr[j]);
                if(sArr[j].charAt(i)=='8') L8.add(sArr[j]);
                if(sArr[j].charAt(i)=='9') L9.add(sArr[j]);
            }
            for (int j=0; j< L0.size(); j++)tempSArr.add(L0.get(j));
            for (int j=0; j< L1.size(); j++)tempSArr.add(L1.get(j));
            for (int j=0; j< L2.size(); j++)tempSArr.add(L2.get(j));
            for (int j=0; j< L3.size(); j++)tempSArr.add(L3.get(j));
            for (int j=0; j< L4.size(); j++)tempSArr.add(L4.get(j));
            for (int j=0; j< L5.size(); j++)tempSArr.add(L5.get(j));
            for (int j=0; j< L6.size(); j++)tempSArr.add(L6.get(j));
            for (int j=0; j< L7.size(); j++)tempSArr.add(L7.get(j));
            for (int j=0; j< L8.size(); j++)tempSArr.add(L8.get(j));
            for (int j=0; j< L9.size(); j++)tempSArr.add(L9.get(j));
            sArr=tempSArr.toArray(sArr);
            tempSArr.removeAll(tempSArr);
            L0.removeAll(L0);
            L1.removeAll(L1);
            L2.removeAll(L2);
            L3.removeAll(L3);
            L4.removeAll(L4);
            L5.removeAll(L5);
            L6.removeAll(L6);
            L7.removeAll(L7);
            L8.removeAll(L8);
            L9.removeAll(L9);
        }
        int[] newArray= StringUtil.toIntArray(sArr);
        for (int i=0; i< arr.length; i++){
            arr[i]=newArray[i];
        }
    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}