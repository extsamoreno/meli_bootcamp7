public  class SortUtil{
        public  static <T> void ordenar(Precedable<T> [] arr){
            for (int i = arr.length-1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[i].precedeA((T)arr[j]) == 1) {
                        Precedable value = arr[j];
                        arr[j] = arr[i];
                        arr[i] = value;
                    }
                }
            }
        }
    }
