import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		String[] result;
		HashMap <String, ArrayList <String> > lists = new HashMap<>();

		result = StringUtil.toStringArray(arr);

		StringUtil.lNormalize(result, '0');

		for ( int i = 0; i < 10 ; i++){
			lists.put("L" + i, new ArrayList<String>());
		}

		int maxLength = result[0].length() - 1;

		while( maxLength >= 0){

			for (int i=0; i < result.length; i++ ){
				char aux = result[i].charAt(maxLength);
				lists.get("L" + aux).add(result[i]);
			}

			int i = 0;

			for(Map.Entry<String,ArrayList <String> > entry:lists.entrySet()){
//				String key = entry.getKey();
				ArrayList <String>  value = entry.getValue();

				for(String number: value){
						result[i] = number;
						i++;
					}
					value.clear();
				};

				maxLength--;
		}

		for(int i=0; i<result.length;i++)
		{
			arr[i] = Integer.parseInt(result[i]);
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
