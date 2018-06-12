
// Complex k*n, k can be understand as the base of the number, here we use base 2.
// TODO: any base.
public int [] radix_sort(List<Integer> n) {
    List<Integer> res = new ArrayList<>();

    for(int i=0; i<=31; i++) {
        List<Integer> zo = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for(Integer num: n) {
            int temp = (num>>i) & 1;
            if(temp == 0) zo.add(num);
            else one.add(num);
        }

        for(Integer )
    }
}
